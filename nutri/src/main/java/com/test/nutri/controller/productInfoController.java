package com.test.nutri.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.nutri.entity.productInfo;
import com.test.nutri.repository.ProductInfoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class productInfoController {

	private final ProductInfoRepository productrepo;
	
	@GetMapping("/productInfo")
	public String productInfo(Model model) {
		
		
		/* Optional<Address> address = addressRepository.findByName("강아지"); */
		/* model.addAttribute("dto", address.get().toDTO()); */
		
		/* Optional<productInfoEntity> findByName(String productName); */
		/*
		 * model.addAttribute("productinfolist", productrepo.findByName("센트롬 실버 프로"));
		 */
		
		Optional<productInfo> productInfoEntity = productrepo.findByproductName("센트룸 실버 프로");

		model.addAttribute("productInfo", productInfoEntity.get().toDTO());
		
		
		return "page/productInfo";
	}
	
}
