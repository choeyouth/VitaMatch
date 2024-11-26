package com.test.nutri.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nutri.model.MemberDTO;
import com.test.nutri.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "page/signup";
	}
	
	@PostMapping("/signupok")
	public String signupok(MemberDTO dto) {
		
		dto.combineTelephone();
		
		System.out.println("dto: " + dto);
		
		memberService.signup(dto);
		
		return "redirect:page/login";
	}
	
	@GetMapping("/checkusername")
	@ResponseBody
	public ResponseEntity<Boolean> checkUsername(@RequestParam("username") String username) {
		
		boolean isAvailable = memberService.isUsernameAvailable(username);
		
		return ResponseEntity.ok(isAvailable);
		
	}
	
	
}
