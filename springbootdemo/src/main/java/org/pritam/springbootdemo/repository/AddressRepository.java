package org.pritam.springbootdemo.repository;

import java.util.Optional;

import org.pritam.springbootdemo.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	@Query("select address.id from Address address where address.user.id=:id")
	public Optional<Integer> findArddressIdByUserId(@Param("id") int id);
}
