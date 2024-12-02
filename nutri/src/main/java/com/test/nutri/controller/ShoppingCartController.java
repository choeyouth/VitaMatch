package com.test.nutri.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.ShoppingCartInfo;
import com.test.nutri.model.CustomUserDetails;
import com.test.nutri.repository.ShoppingCartRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShoppingCartController {
	
	private final ShoppingCartRepository shoppingCartRepository;
	
	@GetMapping("/shoppingcart")
	public String shoppingcart(Model model , @RequestParam(name = "seq", required = true) String seq) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	Object principal = authentication.getPrincipal();
    	
    	if (principal instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) principal;
            Integer memberSeq = userDetails.getMember().getSeq();
            System.out.println("현재 회원 seq: " + memberSeq);
        } else {
            System.out.println("인증되지 않은 사용자입니다.");
        }
    	
    	List<ShoppingCartInfo> shoppingCartItem = shoppingCartRepository.findByMemberSeq(seq);
    	
    	if (shoppingCartItem == null || shoppingCartItem.isEmpty()) {
            System.out.println("쇼핑 카트에 데이터가 없습니다.");
        }
    	
        model.addAttribute("shoppingCartItem", shoppingCartItem);
		
		return "page/shoppingCart";
	}
}
