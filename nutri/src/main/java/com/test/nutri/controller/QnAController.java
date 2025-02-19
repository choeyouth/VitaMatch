package com.test.nutri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController {

	// Q&A 목록 페이지 열기용
	@GetMapping("/qna")
	public String showQnaPage() {
	    return "page/qnaList";  // qna.html 페이지를 반환
	}
	
	@GetMapping("/viewQna")
	public String showQnView() { 
	    return "page/viewQna";  // viewQna.html 페이지를 반환
	}
	
    @GetMapping("/addQna")
    public String anaAdd() {
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