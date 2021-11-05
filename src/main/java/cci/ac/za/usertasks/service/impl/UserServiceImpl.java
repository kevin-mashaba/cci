package cci.ac.za.usertasks.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cci.ac.za.usertasks.model.User;
import cci.ac.za.usertasks.repository.UserRepository;
import cci.ac.za.usertasks.service.UserService;


@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public User createUser(User user) throws Exception 
	{
		if(user!=null)
		{
			logger.info("Creating user: " + user);
			return userRepository.save(user);
		}
		else
		{
			throw new Exception("User could not be created");
		}
	}

	@Override
	public List<User> getAllUsers() 
	{
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) throws Exception 
	{
		User user =userRepository.findById(id);
		
		if(user!=null)
		{
			return user;
		}
		else
		{
			throw new Exception("User with ID " + id + " does not exist!");
		}

	}

	@Override
	public User updateUser(long userId, User user) throws Exception
	{
		// TODO Auto-generated method stub
		User u =userRepository.findById(userId);
		
		if(u!=null)
		{
			if(user.getFirstName()!=null)
			{
				u.setFirstName(user.getFirstName());
			}
			if(user.getLastName()!=null)
			{
				u.setLastName(user.getLastName());
			}
			if(user.getTask()!=null)
			{
				u.setTask(user.getTask());
			}
			if(user.getUsername()!=null)
			{
				u.setUsername(user.getUsername());
			}
			
			
			
			return userRepository.save(u);
		}
		else
		{
			throw new Exception("User with ID " + userId + " does not exist!");
		}
	}

	@Override
	public User getUserInfo(long userId) throws Exception 
	{
		// TODO Auto-generated method stub
		User user =userRepository.findById(userId);
		
		if(user!=null)
		{
			return userRepository.findById(userId);
		}
		else
		{
			throw new Exception("User with ID " + userId + " does not exist!");
		}
	}
}
