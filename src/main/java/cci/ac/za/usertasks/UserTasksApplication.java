package cci.ac.za.usertasks;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class UserTasksApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(UserTasksApplication.class, args);
		
		 
	}

}
