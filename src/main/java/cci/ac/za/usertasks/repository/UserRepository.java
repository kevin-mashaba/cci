package cci.ac.za.usertasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cci.ac.za.usertasks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	User findById(long id);
}
