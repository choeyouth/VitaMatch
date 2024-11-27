package com.test.nutri.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.VwDailyRecommend;
import com.test.nutri.entity.VwGenderAgeRecommend;
import com.test.nutri.entity.VwHealthRecommend;
import com.test.nutri.entity.VwOrganRecommend;
import com.test.nutri.repository.DailyRecommendRepository;
import com.test.nutri.repository.GenderAgeRecommendRepository;
import com.test.nutri.repository.HealthRecommendRepository;
import com.test.nutri.repository.OrganRecommendRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RecommendController {
	
	private final GenderAgeRecommendRepository genderAgeRecommendRepository;
	private final HealthRecommendRepository healthRecommendRepository;
	private final OrganRecommendRepository organRecommendRepository;
	private final DailyRecommendRepository dailyRecommendRepository;
	
	@GetMapping("/survey")
	public String survey(Model model) {
		
		return "page/survey";
	}
	
	
	@GetMapping("/recommend")
	public String recommend(@RequestParam(value = "gender", required = false)String gender
							, @RequestParam(value = "age", required = false) String age
							, @RequestParam(value = "healthSeq", required = false)String healthSeq
							, @RequestParam(value = "organSeq", required = false)String organSeq
							, @RequestParam(value = "dailySeq", required = false)String dailySeq, Model model) {
		
		List<VwGenderAgeRecommend> galist = new ArrayList<>();
		List<VwHealthRecommend> hlist = new ArrayList<>();
		List<VwOrganRecommend> olist = new ArrayList<>();
		List<VwDailyRecommend> dlist = new ArrayList<>();
		
		if (gender != null & age != null ) {
			galist = genderAgeRecommendRepository.findAll(gender, age + "0");
			System.out.println("gender: " + gender + "age: " + age);
			System.out.println(galist);
		} else {
			System.out.println("성별과 나이대를 선택해주세요.");
		}
		
		if (healthSeq != null || organSeq != null || dailySeq != null) {
			hlist = healthRecommendRepository.findAll(healthSeq);
			System.out.println("health: " + healthSeq);
			System.out.println(hlist);
			
			olist = organRecommendRepository.findAll(organSeq);
			System.out.println("organ: " + organSeq);
			System.out.println(olist);
			
			dlist = dailyRecommendRepository.findAll(dailySeq);
			System.out.println("daily: " + dailySeq);
			System.out.println(dlist);
		
		} else if (healthSeq == null) {
			System.out.println("건강 검진 선택해주세요.");
		} else if (organSeq == null) {
			System.out.println("주요 장기 선택해주세요.");
		} else if (dailySeq == null) {
			System.out.println("일상 생활 선택해주세요.");
		}
		
		
		model.addAttribute("galist", galist);
		model.addAttribute("hlist", hlist);
		model.addAttribute("olist", olist);
		model.addAttribute("dlist", dlist);
		
		return "page/recommend";
	}
	
}
