package com.test.nutri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Member;
import com.test.nutri.entity.Question;
import com.test.nutri.repository.QnACustomRepository;
import com.test.nutri.repository.QuestionRepository;
import com.test.nutri.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QnAController {
	
	private final QnACustomRepository qnaCustomRepository;
	private final QuestionRepository questionRepository;

	@Autowired
    private	CustomUserDetailsService userService; 
	
	// Q&A 목록 페이지 열기용
	@GetMapping("/qna")
	public String showQnaPage(Model model) {
	    
	    List<Question> list = qnaCustomRepository.findAll(); //TODO: order by seq desc 로 바꾸기 
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
	public String qnaAddView() {

		//TODO: 중복 코드 > 리팩토링 가능한지 생각해보기 
		Integer memberSeq = userService.getMemberSeqFromAuthentication();
	    
	    if (memberSeq == null) {
	        return "redirect:/login";  // 인증되지 않은 사용자일 경우 로그인 페이지로 리다이렉트
	    }

	    return "page/addQna";  // addQna.html 페이지를 반환
	}

	@PostMapping("/addQuestion")
	public String qnaAdd(@RequestParam("title") String title, 
						 @RequestParam("content") String content, 
						 Model model) {

		Integer memberSeq = userService.getMemberSeqFromAuthentication();
	    
	    if (memberSeq == null) {
	        return "redirect:/login";  // 인증되지 않은 사용자일 경우 로그인 페이지로 리다이렉트
	    }
	    
	    System.out.println("title: " + title);
		System.out.println("content: " + content);
	    
		//TODO: jpa 영속성 컨텍스트 문제 > 리팩토링 고려 
		Member member = Member.builder().seq(memberSeq).build();
	    Question question = Question.builder()
	    						.title(title)
	    						.content(content)
	    						.member(member)
	    						.build();

	    questionRepository.save(question);
	    Long savedSeq = question.getSeq();
	    System.out.println("저장댐 : " + savedSeq);
	    
		return "redirect:/viewQna?seq=" + savedSeq;
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