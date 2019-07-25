package com.sherold.dojospagination.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sherold.dojospagination.repositories.DojoRepository;

@Service
@Transactional // for pagination
public class DojoService {
	@Autowired // for pagination
	
	// <----- Attributes ----->
	// dependency injection
	private DojoRepository dojoRepo;
	
	// <----- Constructors ----->
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	// <----- Methods ----->
	// Static variable to set the number of dojos we want per page
	private static final int PAGE_SIZE = 5;
	public Page<Object[]> dojosPerPage(int pageNumber) {
		// get all the dojos per page and sort them in ascending order by dojo
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "name");
		Page<Object[]> dojos = dojoRepo.allDojosAndNinjas(pageRequest);
		return dojoRepo.allDojosAndNinjas(pageRequest);
	}
}
