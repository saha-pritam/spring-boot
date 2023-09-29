package org.pritam.springbootdemo.service;

import java.util.Optional;

import org.pritam.springbootdemo.entity.Address;
import org.pritam.springbootdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public int getAddressId(int userid) {
		Optional<Integer> findArddressIdByUserId = addressRepository.findArddressIdByUserId(userid);
		if(findArddressIdByUserId.isPresent())
			return findArddressIdByUserId.get();
		return 0;
	}
}
