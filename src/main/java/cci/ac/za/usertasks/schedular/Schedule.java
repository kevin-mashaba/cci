package cci.ac.za.usertasks.schedular;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import cci.ac.za.usertasks.service.TaskService;

@Component
public class Schedule 
{
	
	@Autowired
	private TaskService taskService;
	
	
	Logger logger = LoggerFactory.getLogger(Schedule.class);
	
	@Scheduled(fixedRate = 30000)
	public void checkStatus() throws Exception
	{
		logger.info("CURRENT TASKS WITH \"PENDING\" STATUSES: " + Arrays.toString(taskService.getTaskStatus().toArray()));
		
		if(taskService.getTaskStatus().size() > 0)
		{
			for(int x=0;x < taskService.getTaskStatus().size();x++)
			{
				logger.info("UPDATING TO DONE: " + taskService.getTaskStatus().get(x));
				
			}
			
			taskService.updateStatus();
		}
	}

}
