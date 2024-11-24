package com.test.nutri.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class productInfoController {

	@GetMapping("/productInfo")
	public String productInfo(Model model) {
		

						
		return "page/productInfo";
	}
	
}
