package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CombinationController {

	@GetMapping("/combination")
	public String combination() {
		
		return "page/combination";
	}
	
	
	
}
