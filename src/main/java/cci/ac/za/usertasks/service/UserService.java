package cci.ac.za.usertasks.service;

import java.util.List;
import cci.ac.za.usertasks.model.User;


public interface UserService 
{

	
	public abstract User createUser(User user) throws Exception;
	
	public abstract User updateUser(long userId,User user) throws Exception;
	
	public abstract List<User> getAllUsers();
	
	public abstract User findById(long id) throws Exception;
	
	public abstract User getUserInfo(long userId) throws Exception;
}
