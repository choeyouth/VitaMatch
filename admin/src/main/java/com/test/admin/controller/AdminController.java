package com.test.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AdminController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "page/login";
	}
	
	@PostMapping("/login")
	public String postLogin() {

		return "page/login";
	}
	
}
