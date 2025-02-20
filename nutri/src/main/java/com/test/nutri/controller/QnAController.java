package com.test.nutri.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Member;
import com.test.nutri.entity.Question;
import com.test.nutri.model.CustomUserDetails;
import com.test.nutri.repository.QnACustomRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QnAController {
	
	private final QnACustomRepository qnaCustomRepository;

	// Q&A 목록 페이지 열기용
	@GetMapping("/qna")
	public String showQnaPage(Model model) {
	    
	    List<Question> list = qnaCustomRepository.findAll();
	    model.addAttribute("list", list);
	    return "page/qnaList";  // qna.html 페이지를 반환
	}

	
	@GetMapping("/viewQna")
	public String showQnView(@RequestParam("seq") Long seq, Model model) { 
		
		Question question = qnaCustomRepository.findQuestionBySeq(seq);
		List<Answer> answers = qnaCustomRepository.findAnswerByQuestionSeq(seq);
		
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		
	    return "page/viewQna";  // viewQna.html 페이지를 반환
	}
	
    @GetMapping("/addQna")
    public String anaAdd() {
    	
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    Object principal = authentication.getPrincipal();
	
	    System.out.println(principal);
	    Member member;
	
	    if (principal instanceof CustomUserDetails) {  
	    } else {
	        System.out.println("인증되지 않은 사용자입니다.");
	        return "redirect:/login";  // 인증되지 않은 사용자일 경우 로그인 페이지로 리다이렉트
	    }
    	
        return "page/addQna";  // addQna.html 페이지를 반환
    }
    
    @GetMapping("/editQna")
    public String qnaEdit() {
        return "page/editQna";  // editQna.html 페이지를 반환
    }
    
    @GetMapping("/addAnswer")
    public String addAnswer() {
        return "page/addAnswer";  // addAnswer.html 페이지를 반환
    }
    
    @GetMapping("/editAnswer")
    public String editAnswer() {
        return "page/editAnswer";  // editAnswer.html 페이지를 반환
    }


}