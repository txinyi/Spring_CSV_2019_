package csv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import csv.domain.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "SELECT u FROM User u WHERE u.salary >= ?1 and u.salary <= ?2")
	List<User> findSalaryRange(Double min, Double max); 
}
