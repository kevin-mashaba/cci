package cci.ac.za.usertasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cci.ac.za.usertasks.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{

	Task findById(long id);
	
	@Query(value = "SELECT * FROM task WHERE user_Id = ?1", nativeQuery = true)
	List<Task> getUserTasks(long userId);
	
	@Query(value = "SELECT * FROM task WHERE status ='PENDING' AND CURRENT_TIMESTAMP() > date_time ;",nativeQuery = true)
	List<Task> getTaskStatus();
	
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@javax.transaction.Transactional
	@Query(value = "UPDATE task set status = 'DONE' WHERE status = 'PENDING'",nativeQuery = true)
	void updateToDone();
}
