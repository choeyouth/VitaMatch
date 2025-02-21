package com.test.nutri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.test.nutri.entity.Member;
import com.test.nutri.entity.Question;
import com.test.nutri.model.AnswerDTO;
import com.test.nutri.model.QuestionDTO;
import com.test.nutri.repository.AnswerRepository;
import com.test.nutri.repository.QnACustomRepository;
import com.test.nutri.repository.QuestionRepository;
import com.test.nutri.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QnAController {
	
	private final QnACustomRepository qnaCustomRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	@Autowired
    private	CustomUserDetailsService userService; 
	
	// Q&A 목록 페이지 
	@GetMapping("/qna")
	public String showQnaPage(Model model) {
	    
	    List<Question> list = qnaCustomRepository.findAll(); //TODO: order by seq desc 로 바꾸기 
	    model.addAttribute("list", list);
	    return "page/qnaList";  
	}


	// Q&A 상세 페이지 
	@GetMapping("/viewQna")
	public String showQnView(@RequestParam("seq") Long seq, Model model) { 
		
		Question question = qnaCustomRepository.findQuestionBySeq(seq);
		List<Answer> answers = qnaCustomRepository.findAnswerByQuestionSeq(seq);
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
	    
		Member member = Member.builder().seq(loginSeq).build();
	    Question question = Question.builder()
	    						.title(dto.getTitle())
	    						.content(dto.getContent())
	    						.member(member)
	    						.build();

	    questionRepository.save(question);
	    Long savedSeq = question.getSeq();
	    if(savedSeq == null || savedSeq == 0) return "redirect:/errorPage?message=작성 실패";
    	
		return "redirect:/viewQna?seq=" + savedSeq;
	}
	
    
	// 질문 수정 페이지 
    @GetMapping("/editQuestionView")
    public String qnaEdit(@RequestParam("seq") Long seq, Model model) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
    	if (loginSeq == null) return "redirect:/qna"; 
    	
    	Question question = qnaCustomRepository.findQuestionBySeq(seq);
    	if (question == null) return "redirect:/qna";
    	if(!question.getMember().getSeq().equals(loginSeq)) return "redirect:/qna";
    	
    	model.addAttribute("question", question);
    	
        return "page/editQuestion";  
    }
    
    @PostMapping("/editQuestion/{seq}")
    public String editQuestion(@PathVariable("seq") Long seq, 
    						   @ModelAttribute QuestionDTO dto) {

    	long isUpdate = qnaCustomRepository.updateQuestion(dto);
        if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
        return "redirect:/viewQna?seq=" + seq;
    }
    
    
    @PostMapping("/solvedQuestion/{seq}") 
    public String solvedQuestion(@PathVariable("seq") Long seq) {
    	
    	long isUpdate = qnaCustomRepository.solvedQuestion(seq);
    	if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
    	return "redirect:/viewQna?seq=" + seq;
    }
    
    @DeleteMapping("/delQuestion/{seq}")
    public ResponseEntity<String> delQuestion(@PathVariable("seq") Long seq) {
    	
        Integer loginSeq = userService.getLoginSeqFromAuthentication();
        if (loginSeq == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        Question question = qnaCustomRepository.findQuestionBySeq(seq);
        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 질문입니다.");
        }

        if (!question.getMember().getSeq().equals(loginSeq)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
        }
        
        qnaCustomRepository.delQuestionBySeq(seq);
        
    	return ResponseEntity.ok().body("삭제 완료");
    }
    
    
    @GetMapping("/addAnswerView")
    public String addAnswerView(@RequestParam("seq") Long seq, Model model) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
	    if (loginSeq == null) return "redirect:/login";  
    	
	    Question question = qnaCustomRepository.findQuestionBySeq(seq);
	    model.addAttribute("question", question);
	    
        return "page/addAnswer";  
    }
    
    
    @PostMapping("/addAnswer")
    @Transactional
    public String addAnswer(@RequestParam("seq") Long qSeq, 
    						@RequestParam("answerContent") String content) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
    	if (loginSeq == null) return "redirect:/qna"; 
    	
    	Member member = Member.builder().seq(loginSeq).build();
    	Question question = Question.builder().seq(qSeq).build();
    	Answer answer = Answer.builder().member(member)
    									.question(question)
    									.content(content)
    									.build();
    	
    	answerRepository.save(answer);
    	Long savedSeq = answer.getSeq();
	    if(savedSeq == null || savedSeq == 0) return "redirect:/errorPage?message=댓글 작성 실패";
    	
    	return "redirect:/viewQna?seq=" + qSeq;
    }
    
    @GetMapping("/editAnswerView")
    public String editAnswerView(@RequestParam("seq") Long seq, Model model) {
    	
    	Integer loginSeq = userService.getLoginSeqFromAuthentication();
    	if (loginSeq == null) return "redirect:/qna"; 
    	
    	Answer answer = qnaCustomRepository.findAnswerBySeq(seq);
    	model.addAttribute("answer", answer);
    	
        return "page/editAnswer";  
    }
    
    
    @PostMapping("/editAnswer")
    public String editAnswer(@RequestParam("qseq") Long qseq, @ModelAttribute AnswerDTO dto) {
    	
    	System.out.println("here >>>>>>> " + dto.toString());
    	long isUpdate = qnaCustomRepository.updateAnswer(dto);
        if(isUpdate < 0) return "redirect:/errorPage?message=업데이트 실패";
    	
    	
        return "redirect:/viewQna?seq=" + qseq;
    }
    
    @DeleteMapping("/delAnswer/{seq}")
    public ResponseEntity<String> delAnswer(@PathVariable("seq") Long seq) {
    	
        Integer loginSeq = userService.getLoginSeqFromAuthentication();
        if (loginSeq == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        Answer answer = qnaCustomRepository.findAnswerBySeq(seq);
        if (answer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 답변입니다.");
        }

        if (!answer.getMember().getSeq().equals(loginSeq)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
        }
        
        qnaCustomRepository.delAnswerBySeq(seq);
        
    	return ResponseEntity.ok().body("삭제 완료");
    }

}