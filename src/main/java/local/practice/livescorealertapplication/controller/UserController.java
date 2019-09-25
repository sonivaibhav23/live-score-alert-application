package local.practice.livescorealertapplication.controller;

import local.practice.livescorealertapplication.model.User;
import local.practice.livescorealertapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add")
	public void addUser(@RequestBody User user) {
		this.userService.addUser(user);
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/subscribed")
	public List<User> getSubscribedUsers() {
		return this.userService.getSubscribedUsers();
	}

	@GetMapping("/{id}/messages")
	public List<String> getUserMessages(@PathVariable(name = "id") Long userId) {
		return this.userService.getUserMessages(userId);
	}

	@PostMapping("/{id}/subscribe")
	public void subscribeUser(@PathVariable(name = "id") Long id) {
		this.userService.subscribeUser(id);
	}

	@PostMapping("/{id}/unsubscribe")
	public void unsubscribeUser(@PathVariable(name = "id") Long id) {
		this.userService.unsubscribeUser(id);
	}
}
