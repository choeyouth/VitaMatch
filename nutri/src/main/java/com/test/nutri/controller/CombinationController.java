package com.test.nutri.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nutri.entity.VwBadCombination;
import com.test.nutri.entity.VwGoodCombination;
import com.test.nutri.repository.BadCombinationRepository;
import com.test.nutri.repository.GoodCombinationRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CombinationController {

	private final GoodCombinationRepository goodCombinationRepository;
	private final BadCombinationRepository badCombinationRepository;
	
	@GetMapping("/combination")
	public String combination(Model model) {
		
		// 이름만 가져오기 > 재권님이 데이터 넣으면 join해서 가져와야 함
		List<VwGoodCombination> good = goodCombinationRepository.findAll();
		List<VwBadCombination> bad = badCombinationRepository.findAll();
		
		List<VwGoodCombination> list = goodCombinationRepository.listAll();
		
		System.out.println(list);
		model.addAttribute("list",list);

		
		
		Set<String> seqSet = new HashSet<>();

        for (int i = 0; i < good.size(); i++) {
            seqSet.add(good.get(i).getIngredientSeq());  // getSeq()로 seq 값을 가져옴
        }
        for (int i = 0; i < bad.size(); i++) {
            seqSet.add(bad.get(i).getIngredientSeq());  // getSeq()로 seq 값을 가져옴
        }
       
        System.out.println(seqSet);
        
		model.addAttribute("good",seqSet);
		
		//List<Long> goodSeq = customaddressRepository.findAllSeq();
		//model.addAttribute("goodSeq",goodSeq);
		
		return "page/combination";
	}
	
	
	@PostMapping("/combination/ajax")
	@ResponseBody
	public Model combinationGoodBad(Model model, @RequestParam("ingredientSeq") String ingredientSeq, @RequestParam("ingredient") String ingredient) {
		
		List<VwGoodCombination> good = goodCombinationRepository.findByIngredientSeq(ingredientSeq);
		List<VwBadCombination> bad = badCombinationRepository.findByIngredientSeq(ingredientSeq);
		
		Map<String, Object> combination = new HashMap<>();
		combination.put("seq", ingredientSeq);
		combination.put("ingredient", ingredient);
		combination.put("good", good);
		combination.put("bad", bad);
		
		System.out.println(combination);
		
		System.out.println(ingredientSeq);
		System.out.println(ingredient);
		
		//return model.addAttribute("combination",combination);
		return null;
	}
	
	
}
