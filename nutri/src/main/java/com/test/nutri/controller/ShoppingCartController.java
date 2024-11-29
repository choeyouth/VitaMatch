package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartController {
	
	@GetMapping("/shoppingcart")
	public String shoppingcart(Model model) {
		
		
		
		return "shoppingcart";
	}
}
