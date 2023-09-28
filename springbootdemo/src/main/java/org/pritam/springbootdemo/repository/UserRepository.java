package org.pritam.springbootdemo.repository;

import java.util.List;

import org.pritam.springbootdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByLastName(String lastName);

}
