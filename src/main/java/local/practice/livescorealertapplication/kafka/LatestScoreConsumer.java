package local.practice.livescorealertapplication.kafka;

import local.practice.livescorealertapplication.model.User;
import local.practice.livescorealertapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatestScoreConsumer {

	private static final Logger logger = LoggerFactory.getLogger(LatestScoreConsumer.class);

	private UserService userService;

	@Autowired
	public LatestScoreConsumer(UserService userService) {
		this.userService = userService;
	}

	@KafkaListener(topics = "scores", groupId = "group-id")
	public void consume(String message) {
		List<User> subscribedUsers = userService.getSubscribedUsers();
		subscribedUsers.forEach(user -> userService.addMessageForUser(user.getId(), message));
	}

}
