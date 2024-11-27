package com.test.nutri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		List<VwGoodCombination> good = goodCombinationRepository.listAll();
		List<VwBadCombination> bad = badCombinationRepository.listAll();

		Map<String, String> ingredientSeqName = new HashMap<>();

		for (int i = 0; i < good.size(); i++) {
			ingredientSeqName.put(good.get(i).getIngredientSeq(), good.get(i).getIngredientName()); // getSeq()로 seq 값을
																									// 가져옴
		}
		for (int i = 0; i < bad.size(); i++) {
			ingredientSeqName.put(bad.get(i).getIngredientSeq(), bad.get(i).getIngredientName()); // getSeq()로 seq 값을
																									// 가져옴
		}

		System.out.println(ingredientSeqName);

		model.addAttribute("ingredientSeqName", ingredientSeqName);

		return "page/combination";
	}

	@PostMapping("/combination/ajax")
	// json으로 변경해줄려고 넣음 > ResponseEntity
	public ResponseEntity<Map<String, Object>> combinationGoodBad(@RequestBody Map<String, Object> requestData) {
	    String ingredientSeq = (String) requestData.get("ingredientSeq");
	    String ingredient = (String) requestData.get("ingredient");
	    
		List<VwGoodCombination> good = goodCombinationRepository.findByIngredientSeq(ingredientSeq);
		List<VwBadCombination> bad = badCombinationRepository.findByIngredientSeq(ingredientSeq);
		System.out.println("good>>>>>>>>>>" + good);
		System.out.println("bad>>>>>>>>>>" + bad);
		
		
		Map<String, Object> combination = new HashMap<>();
		combination.put("seq", ingredientSeq);
		combination.put("ingredient", ingredient);
		combination.put("good", good);
		combination.put("bad", bad);
		if (good != null && !good.isEmpty()) {
			if(good.get(0).getFunctionalContent()!= null) {
				combination.put("functionalContent", good.get(0).getFunctionalContent());
			}
		}else if (bad != null && !bad.isEmpty()) {
			if(bad.get(0).getFunctionalContent()!= null) {
				combination.put("functionalContent", bad.get(0).getFunctionalContent());
			}
		}
		
		System.out.println(combination);
		System.out.println(">>>>"+combination.get("functionalContent"));
		
		System.out.println(ingredientSeq);
		System.out.println(ingredient);
		
		return ResponseEntity.ok(combination);
		//return null;
	}

}
