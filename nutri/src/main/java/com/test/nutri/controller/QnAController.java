package com.test.nutri.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Question;
import com.test.nutri.model.AnswerDTO;
import com.test.nutri.model.QuestionDTO;
import com.test.nutri.service.CustomUserDetailsService;
import com.test.nutri.service.QnAService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QnAController {
	
    private	final CustomUserDetailsService userService; 
    private final QnAService qnaService;
	
    @GetMapping("/qna")
    public String showQnaPage(@RequestParam(defaultValue = "1", name = "page") Integer page,
                              @RequestParam(value = "keyword", required = false) String keyword,
                              Model model) {

        // 시작 시간 기록
        long startTime = System.currentTimeMillis();

        // QnA 데이터를 가져오는 서비스 호출
        QnAService.PagResult result = qnaService.getQnaPag(page, keyword);

        // 끝 시간 기록
        long endTime = System.currentTimeMillis();

        // 페이지 로딩 시간 계산
        long duration = endTime - startTime; // 밀리초 단위로 반환

        // 콘솔에 로딩 시간 출력
        System.out.println("페이지 로딩 시간: " + duration + " ms");

        // 기존 모델 데이터 추가
        model.addAttribute("sb", result.getPagHtml());
        model.addAttribute("list", result.getQuestions());
        model.addAttribute("keyword", result.getKeyword());

        return "page/qnaList";
    }


	// Q&A 상세 페이지 
	@GetMapping("/viewQna")
	public String showQnView(@RequestParam("seq") Long seq, Model model) { 
		
		Question question = qnaService.getQuestionBySeq(seq);
	    List<Answer> answers = qnaService.getAnswersByQuestionSeq(seq);
	    Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		model.addAttribute("loginSeq", loginSeq);
		
	    return "page/viewQna"; 
	}
	
	
	// 질문 작성 페이지 
	@GetMapping("/addQuestionView")
	public String qnaAddView() {

		Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    if (loginSeq == null) return "redirect:/login";  

	    return "page/addQuestion";  
	}
	

	// 질문 insert 
	@Transactional
	@PostMapping("/addQuestion")
	public String qnaAdd(@ModelAttribute QuestionDTO dto) {

		Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    if (loginSeq == null) return "redirect:/login"; 
	    
	    long savedSeq = qnaService.addQuestion(dto, loginSeq);
	    if(savedSeq == 0) return "redirect:/errorPage?message=작성 실패";

		return "redirect:/viewQna?seq=" + savedSeq;
	}
	
    
	// 질문 수정 페이지 
	@GetMapping("/editQuestionView")
	public String qnaEdit(@RequestParam("seq") Long seq, Model model) {
	    
	    Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    if (loginSeq == null) return "redirect:/qna"; 
	    
	    Question question = qnaService.getQuestionBySeq(seq);
	    if (question == null) return "redirect:/qna";
	    if (!question.getMember().getSeq().equals(loginSeq)) return "redirect:/qna";
	    
	    model.addAttribute("question", question);
	    
	    return "page/editQuestion";  
	}
    
	
	// 질문 update 
    @PostMapping("/editQuestion/{seq}")
    public String editQuestion(@PathVariable("seq") Long seq, 
    						   @ModelAttribute QuestionDTO dto) {

    	long isUpdate = qnaService.updateQuestion(dto);
        if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
        return "redirect:/viewQna?seq=" + seq;
    }
    
    
    // 질문 해결 (update) 
    @PostMapping("/solvedQuestion/{seq}") 
    public String solvedQuestion(@PathVariable("seq") Long seq) {
    	
    	long isUpdate = qnaService.solvedQuestion(seq);
    	if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
    	return "redirect:/viewQna?seq=" + seq;
    }
    
    
    // 질문 delete 
    @DeleteMapping("/delQuestion/{seq}")
    public ResponseEntity<String> delQuestion(@PathVariable("seq") Long seq) {
        
        Integer loginSeq = userService.getLoginSeqFromAuthentication();
        
        if (loginSeq == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String resultMessage = qnaService.deleteQuestion(seq, loginSeq);
        return handleResponse(resultMessage);
    }
    
    
    // 답변 작성 페이지 
    @GetMapping("/addAnswerView")
    public String addAnswerView(@RequestParam("seq") Long seq, Model model) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    if (loginSeq == null) return "redirect:/login";  
    	
	    Question question = qnaService.findQuestionBySeq(seq);
	    model.addAttribute("question", question);
	    
        return "page/addAnswer";  
    }
    
    
    // 답변 insert 
    @PostMapping("/addAnswer")
    @Transactional
    public String addAnswer(@RequestParam("seq") Long qSeq, 
    						@RequestParam("answerContent") String content) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
        if (loginSeq == null) return "redirect:/qna"; 
        
        long savedSeq = qnaService.addAnswer(qSeq, content, loginSeq);
        if (savedSeq == 0) return "redirect:/errorPage?message=댓글 작성 실패";

    	return "redirect:/viewQna?seq=" + qSeq;
    }
    
    
    // 답변 수정 페이지 
    @GetMapping("/editAnswerView")
    public String editAnswerView(@RequestParam("seq") Long seq, Model model) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
    	if (loginSeq == null) return "redirect:/qna"; 
    	
    	Answer answer = qnaService.findAnswerBySeq(seq);
    	model.addAttribute("answer", answer);
    	
        return "page/editAnswer";  
    }
    
    
    // 답변 update 
    @PostMapping("/editAnswer")
    public String editAnswer(@RequestParam("qseq") Long qseq, @ModelAttribute AnswerDTO dto) {
    	
    	long isUpdate = qnaService.updateAnswer(dto);
        if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
        return "redirect:/viewQna?seq=" + qseq;
    }
    
    
    // 답변 delete 
    @DeleteMapping("/delAnswer/{seq}")
    public ResponseEntity<String> delAnswer(@PathVariable("seq") Long seq) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
        if (loginSeq == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String resultMessage = qnaService.deleteAnswer(seq, loginSeq);
        return handleResponse(resultMessage);
    }

    private ResponseEntity<String> handleResponse(String resultMessage) {
    	
        switch (resultMessage) {
            case "삭제 완료":
                return ResponseEntity.ok().body(resultMessage);
            case "존재하지 않습니다.":
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultMessage);
            case "삭제 권한이 없습니다.":
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resultMessage);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류");
        }
    }
}



