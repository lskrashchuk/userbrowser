package by.intexsoft.lskrashchuk.userbrowser.controller;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.lskrashchuk.userbrowser.model.User;
import by.intexsoft.lskrashchuk.userbrowser.service.UserService;

/**
 * Basic controller class
 *
 */
@RestController
public class BasicController
{
	@Autowired
	private UserService userService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(BasicController.class);
	
	/**
	 * Home page mapping method
	 * @return hello string
	 */
	@RequestMapping("/")
    public String helloWorld() 
    {
		LOGGER.info("Start hello method");
		return "Hello, World! Welcome to User Browser!";
    }

	/**
	 * Users page mapping method
	 * @return all users list
	 */
	@RequestMapping("/users")
    public String getAllUsers() 
    {
		return userService.findAll().stream().map(User::toString).collect(Collectors.joining("<br>"));
    }
}
