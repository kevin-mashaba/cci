package cci.ac.za.usertasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cci.ac.za.usertasks.model.Task;


public interface TaskService 
{
	
	public abstract Task createUserTask(long userId, Task task) throws Exception;
	
	public abstract Task deleteUserTask(long userId,long taskId) throws Exception;
	
	public abstract Task updateUserTask(long userId, Task task, long taskId) throws Exception;
	
	public abstract Task getUserTask(long userId,long taskId) throws Exception;
	
	public abstract List<Task> getUserTasks(long userId) throws Exception;
	
	public abstract List<Task> getTaskStatus() throws Exception;
	
	public abstract void updateStatus() throws Exception;
	
	
}
