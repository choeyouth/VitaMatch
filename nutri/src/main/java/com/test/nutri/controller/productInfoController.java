package com.test.nutri.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.productInfo;
import com.test.nutri.repository.ProductInfoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class productInfoController {

	private final ProductInfoRepository productrepo;
	
	@GetMapping("/productInfo")
	public String productInfo(Model model,@RequestParam(name = "seq")long seq) {
		
		

		Optional<productInfo> productInfoEntity = productrepo.findByseq(seq);

		//model.addAttribute("productInfo", productInfoEntity.get().toDTO());
		productInfoEntity.ifPresent(value -> model.addAttribute("productInfo", value.toDTO()));
		
		return "page/productInfo";
	}
	
}
