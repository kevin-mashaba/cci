package cci.ac.za.usertasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import cci.ac.za.usertasks.model.User;
import cci.ac.za.usertasks.service.UserService;

@RequestMapping(value = "/api/user")
@RestController
public class UserController 
{

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user) throws Exception 
	{		
		
	    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PATCH)
	public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable(name = "userId")long userId) throws Exception 
	{		
		
	    return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUsers() throws Exception 
	{		
	    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserInfo(@PathVariable(name = "userId")long userId) throws Exception 
	{		
		
	    return new ResponseEntity<>(userService.getUserInfo(userId), HttpStatus.OK);
	}
}
