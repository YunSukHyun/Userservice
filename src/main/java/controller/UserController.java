package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String home(Model model) {
		List<User> userList = userRepository.findAll();
		model.addAttribute("users", userList);
		return "index";
	}
	
	@PostMapping("/users")
	public String enroll(@RequestParam(name = "name") String name) {
		User user = new User();
		user.setName(name);
		userRepository.save(user);
		return "index";
	}
}
