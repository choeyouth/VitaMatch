package com.test.nutri.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.nutri.entity.GoodCombination;
import com.test.nutri.model.CombinationRepository;
import com.test.nutri.repository.GoodCombinationRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CombinationController {

	private final GoodCombinationRepository goodCombinationRepository;
	private final CombinationRepository customaddressRepository;
	
	@GetMapping("/combination")
	public String combination(Model model) {
		
		// 이름만 가져오기 > 재권님이 데이터 넣으면 join해서 가져와야 함
		//Optional<goodCombination> good = goodCombinationRepository.findById(1L);
		//model.addAttribute("good",good);
		
		//List<GoodCombination> goodSeq = customaddressRepository.findAllSeq();
		//model.addAttribute("goodSeq",goodSeq);
		
		return "page/combination";
	}
	
	
	
}
