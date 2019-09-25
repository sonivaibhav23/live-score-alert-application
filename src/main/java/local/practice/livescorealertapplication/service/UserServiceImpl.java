package local.practice.livescorealertapplication.service;

import local.practice.livescorealertapplication.model.User;
import local.practice.livescorealertapplication.model.UserMessages;
import local.practice.livescorealertapplication.repository.UserMessagesRepository;
import local.practice.livescorealertapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository repository;
	private final UserMessagesRepository messagesRepository;

	@Autowired
	public UserServiceImpl(UserRepository repository, UserMessagesRepository messagesRepository) {
		this.repository = repository;
		this.messagesRepository = messagesRepository;
	}

	@Override
	public void addUser(User user) {
		logger.info("Saving a new user in repo with id : {}", user.getId());
		this.repository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("Fetching all users from repo");
		return this.repository.findAll();
	}

	@Override
	public List<User> getSubscribedUsers() {
		logger.info("Fetching subscribed users from repo");
		return this.repository.findAllBySubscribedToScoreAlert(true);
	}

	@Override
	public List<String> getUserMessages(Long userId) {
		logger.info("Fetching messages for user : {} from repo", userId);
		return this.messagesRepository.findMessagesByUserId(userId);
	}

	@Override
	public void addMessageForUser(Long userId, String message) {
		logger.info("Adding message for user : {}", userId);
		UserMessages userMessages = new UserMessages();
		userMessages.setUserId(userId);
		userMessages.setMessage(message);
		this.messagesRepository.save(userMessages);
	}

	@Override
	public void subscribeUser(Long id) {
		logger.info("Starting subscription for user : {}", id);
		Optional<User> findUser = this.repository.findById(id);
		if (findUser.isPresent()) {
			User user = findUser.get();
			user.setSubscribedToScoreAlert(true);
			this.repository.save(user);
		} else {
			logger.error("No user exists with this id : {}", id);
		}
	}

	@Override
	public void unsubscribeUser(Long id) {
		logger.info("User : {} has been unsubscribed for score alerts", id);
		Optional<User> findUser = this.repository.findById(id);
		if (findUser.isPresent()) {
			User user = findUser.get();
			user.setSubscribedToScoreAlert(false);
			this.repository.save(user);
		} else {
			logger.error("No user exists with this id : {}", id);
		}
	}
}
