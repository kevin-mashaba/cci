package cci.ac.za.usertasks.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cci.ac.za.usertasks.enums.Status;
import cci.ac.za.usertasks.model.Task;
import cci.ac.za.usertasks.model.User;
import cci.ac.za.usertasks.repository.TaskRepository;
import cci.ac.za.usertasks.repository.UserRepository;
import cci.ac.za.usertasks.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Override
	public Task createUserTask(long userId, Task task) throws Exception 
	{
		User user = userRepository.findById(userId);
		if(user!=null)
		{
			
			if(task.getStatus().equals(Status.PENDING.toString()))
			{
				task.setStatus(Status.PENDING.toString());
			}
			else if(task.getStatus().equals(Status.DONE.toString()))
			{
				task.setStatus(Status.DONE.toString());
			}
			else
			{
				throw new Exception("Value must be PENDING or DONE");
			}
			
			task.setDate(new Date());
			task.setUser(user);
			
			return taskRepository.save(task);
		
		}
		else
		{
			throw new Exception("Customer with ID " + userId + " does not exist! Address could not be added");
		}
	}

	@Override
	public Task deleteUserTask(long userId, long taskId) throws Exception 
	{
		User user =userRepository.findById(userId);
		Task task = taskRepository.findById(taskId);
		
		if(user!=null)
		{
			if( task!=null)
			{
				 taskRepository.delete(task);
				 return task;
			}
			else
			{
				throw new Exception("Task with ID " + taskId + " does not exist! Could not delete");
			}
	 
		}
		else
		{
			throw new Exception("User with ID " + userId + " does not exist! Could not delete");
		}
	}

	@Override
	public Task updateUserTask(long userId, Task task, long taskId) throws Exception 
	{
		User user =userRepository.findById(userId);
		Task t = taskRepository.findById(taskId);
		
		if(user!=null)
		{
			if( t!=null)
			{
				if(task.getDate()!=null)
				{
					t.setDate(task.getDate());
			    }
				
				if(task.getDescription()!=null)
				{
					t.setDescription(task.getDescription());
				}
				
				if(task.getName()!=null)
				{
					t.setName(task.getName());
				}
				
				if(task.getStatus()!=null)
				{
					if(task.getStatus().equals(Status.PENDING.toString()))
					{
						t.setStatus(Status.PENDING.toString());
					}
					else if(task.getStatus().equals(Status.DONE.toString()))
					{
						t.setStatus(Status.DONE.toString());
					}
					else
					{
						throw new Exception("Value must be PENDING or DONE");
					}
					
				}
				
				if(task.getUser()!=null)
				{
					t.setUser(task.getUser());
				}
					
				if(task.getDate()!=null) 
				{
					t.setDate(task.getDate());
				}
				
				
				 return taskRepository.save(t);
			}
			else
			{
				throw new Exception("Task with ID " + taskId + " does not exist! Could not update");
			}
	 
		}
		else
		{
			throw new Exception("User with ID " + userId + " does not exist! Could not update task");
		}
		
		
		
	}

	@Override
	public Task getUserTask(long userId, long taskId) throws Exception 
	{
		// TODO Auto-generated method stub
		User user =userRepository.findById(userId);
		Task task = taskRepository.findById(taskId);
		
		if(user!=null)
		{
			if( task!=null)
			{
				 taskRepository.delete(task);
				 return task;
			}
			else
			{
				throw new Exception("Task with ID " + taskId + " does not exist! Could not delete");
			}
	 
		}
		else
		{
			throw new Exception("User with ID " + userId + " does not exist! Could not delete");
		}
	}

	@Override
	public List<Task> getUserTasks(long userId) throws Exception
	{
		// TODO Auto-generated method stub
		
		if(taskRepository.getUserTasks(userId)!=null)
		{
			return taskRepository.getUserTasks(userId);
		}
		else
		{
			throw new Exception("User: " + userId + " has no assigned tasks");
		}
		
	}

	@Override
	public List<Task> getTaskStatus() throws Exception {
		// TODO Auto-generated method stub
		
		return taskRepository.getTaskStatus();
		
	}

	@Override
	public void updateStatus() throws Exception {
		// TODO Auto-generated method stub
		 taskRepository.updateToDone();
	}

}
