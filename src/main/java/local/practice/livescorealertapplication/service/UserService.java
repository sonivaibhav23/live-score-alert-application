package local.practice.livescorealertapplication.service;

import local.practice.livescorealertapplication.model.User;

import java.util.List;

public interface UserService {

	void addUser(User user);

	List<User> getAllUsers();

	List<User> getSubscribedUsers();

	List<String> getUserMessages(Long userId);

	void addMessageForUser(Long userId, String message);

	void subscribeUser(Long id);

	void unsubscribeUser(Long id);
}
