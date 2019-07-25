package com.sherold.dojospagination.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sherold.dojospagination.services.DojoService;

@Controller
public class DojoController {
	// <----- Attributes ----->
	// dependency injection
	private DojoService dojoService;
	
	// <----- Constructors ----->
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	// <----- Methods ----->
	@RequestMapping("/pages/{pageNumber}")
	public String getDojosPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax class="keyword operator from-rainbow">- 1.
	    Page<Object[]> dojos = dojoService.dojosPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = dojos.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("dojos", dojos);
	    return "dojos/index.jsp";
	}
}
