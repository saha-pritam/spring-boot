package org.pritam.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import org.pritam.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByLastName(String lastName);
	
	@Query("select user from User user where user.id>=:start and user.id<=:end")
	public List<User> findAllUsersBetweenIdRange(@Param("start") int start, @Param("end") int end);
	
	@Query("select user.id from User user where user.id=:id")
	public Optional<Integer> findIdIfAvailable(@Param("id") int id);

}
