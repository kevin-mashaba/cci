package cci.ac.za.usertasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cci.ac.za.usertasks.model.Task;
import cci.ac.za.usertasks.service.TaskService;


@RequestMapping(value = "/api/user")
@RestController
public class TaskController 
{

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(path = "/{user_id}/task", method = RequestMethod.POST)
	public ResponseEntity<Object> createUserTask(@PathVariable(name = "user_id")long userId,@RequestBody Task task) throws Exception 
	{	
	    return new ResponseEntity<>(taskService.createUserTask(userId,task), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{user_id}/task/{task_id}", method = RequestMethod.PATCH)
	public ResponseEntity<Object> updateUserTask(@PathVariable(name = "user_id")long userId,@RequestBody Task task, @PathVariable(name = "task_id") int taskId) throws Exception 
	{		
		
	    return new ResponseEntity<>(taskService.updateUserTask(userId, task,taskId), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{user_id}/task/{task_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUserTask(@PathVariable(name = "user_id")long userId, @PathVariable(name = "task_id") int taskId) throws Exception 
	{		
	    return new ResponseEntity<>(taskService.deleteUserTask(userId, taskId), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{user_id}/task/{task_id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getTaskInfo(@PathVariable(name = "user_id")long userId,@PathVariable(name = "task_id")int taskId) throws Exception 
	{		
		
	    return new ResponseEntity<>(taskService.getUserTask(userId, taskId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{user_id}/task", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUserTask(@PathVariable(name = "user_id")long userId) throws Exception 
	{		
		
	    return new ResponseEntity<>(taskService.getUserTasks(userId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<Object> getSrTask() throws Exception 
	{		
		
	    return new ResponseEntity<>(taskService.getTaskStatus(), HttpStatus.OK);
	}
	
}
