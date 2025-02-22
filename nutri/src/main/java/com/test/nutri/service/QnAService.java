package com.test.nutri.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.test.nutri.entity.Answer;
import com.test.nutri.entity.Member;
import com.test.nutri.entity.Question;
import com.test.nutri.model.AnswerDTO;
import com.test.nutri.model.QuestionDTO;
import com.test.nutri.repository.AnswerRepository;
import com.test.nutri.repository.QnACustomRepository;
import com.test.nutri.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnAService {

	private final QnACustomRepository qnaCustomRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final CacheManager cacheManager;
	
	private static final double MAX_LIST = 10;
	private static final double MAX_PAGE = 9;
	
	public PagResult getQnaPag(int page, String keyword) {
	    Long offset = calculateOffset(page);
	    
	    // 캐시에서 데이터를 먼저 조회
	    List<Question> cachedData = findCachedData(offset, MAX_LIST, keyword);
	    List<Question> list;
	    
	    if (cachedData != null) {
	        list = cachedData;
	    } else {
	        list = qnaCustomRepository.findAllPagenationByKeyword(offset, (int) MAX_LIST, keyword);
		    saveToCache(list, offset, keyword);
	    }

	    // 전체 데이터 개수를 세는 부분
	    Long count = qnaCustomRepository.count(keyword);

	    // 전체 페이지 개수 계산
	    Long pageCount = calculatePageCount(count);

	    // 페이지 번호 로직
	    String paginationHtml = generatePagHtml(page, pageCount, keyword);

	    return new PagResult(paginationHtml, list, keyword);
	}

	public Question getQuestionBySeq(Long seq) {
	    return qnaCustomRepository.findQuestionBySeq(seq);
	}

	public List<Answer> getAnswersByQuestionSeq(Long seq) {
	    return qnaCustomRepository.findAnswerByQuestionSeq(seq);
	}
	
	public Question findQuestionBySeq(Long seq) {
		return qnaCustomRepository.findQuestionBySeq(seq);
	}
	
	public Answer findAnswerBySeq(Long seq) {
		return qnaCustomRepository.findAnswerBySeq(seq);
	}

	public long addQuestion(QuestionDTO dto, Integer loginSeq) {
		
	    Member member = Member.builder().seq(loginSeq).build();
	    Question question = Question.builder()
	            .title(dto.getTitle())
	            .content(dto.getContent())
	            .member(member)
	            .build();

	    questionRepository.save(question);
	    clearAllCache();
	    
	    return question.getSeq();
	}

    public long addAnswer(Long qSeq, String content, Integer loginSeq) {
    	
        Member member = Member.builder().seq(loginSeq).build();
        Question question = Question.builder().seq(qSeq).build();
        Answer answer = Answer.builder().member(member)
                                         .question(question)
                                         .content(content)
                                         .build();
        answerRepository.save(answer);
        return answer.getSeq();
        
    }

	public long updateQuestion(QuestionDTO dto) {
		clearAllCache();
		return qnaCustomRepository.updateQuestion(dto);
	}

	public long solvedQuestion(Long seq) {
		return qnaCustomRepository.solvedQuestion(seq);
	}

	public long updateAnswer(AnswerDTO dto) {
		return qnaCustomRepository.updateAnswer(dto);
	}
    
	public String deleteQuestion(Long seq, Integer loginSeq) {
		
	    Question question = qnaCustomRepository.findQuestionBySeq(seq);
	    
	    if (question == null) {
	        return "존재하지 않습니다."; 
	    }
	    
	    if (!question.getMember().getSeq().equals(loginSeq)) {
	        return "삭제 권한이 없습니다."; 
	    }
	    
	    qnaCustomRepository.delQuestionBySeq(seq);
	    clearAllCache();
	    
	    return "삭제 완료"; 
	}
	
	public String deleteAnswer(Long seq, Integer loginSeq) {
		
	    Answer answer = qnaCustomRepository.findAnswerBySeq(seq);
	    
	    if (answer == null) {
	        return "존재하지 않습니다.";
	    }
	    
	    if (!answer.getMember().getSeq().equals(loginSeq)) {
	        return "삭제 권한이 없습니다.";
	    }

	    qnaCustomRepository.delAnswerBySeq(seq);
	    
	    return "삭제 완료";
	}
	
    private Long calculateOffset(int page) {
        return (page - 1) * (long) MAX_LIST;
    }

    private Long calculatePageCount(Long count) {
        return (long) Math.ceil(count / MAX_LIST);
    }

    private String generatePagHtml(int page, Long pageCount, String keyword) {
    	
        StringBuilder sb = new StringBuilder();
        String encodedKeyword = (keyword != null) ? URLEncoder.encode(keyword, StandardCharsets.UTF_8) : "";

        // 페이징 블록 계산
        int firstPage = (int)(Math.floor((page - 1) / MAX_PAGE) * MAX_PAGE + 1);
        int beforePage = firstPage - (int)MAX_PAGE;
        Long nextPage = firstPage + (long)MAX_PAGE;

        // 첫 번째 페이지가 1보다 작으면 1로 설정
        if (beforePage < 1) {
            beforePage = 1;
        }

        // 페이지가 최대 페이지를 초과하면 마지막 페이지로 설정
        if (nextPage > pageCount) {
            nextPage = pageCount;
        }

        // 이전 페이지 링크
        if (page > 1) {
            sb.append(String.format("<a href=\"/qna?page=%d&keyword=%s\">&lt;</a>", page - 1, encodedKeyword));
        }

        // 페이지 번호 링크
        for (int i = firstPage; i <= nextPage && i <= pageCount; i++) {
            if (page == i) {
                sb.append(String.format("<a href=\"/qna?page=%d&keyword=%s\" class=\"active\">%d</a>", i, encodedKeyword, i));
            } else {
                sb.append(String.format("<a href=\"/qna?page=%d&keyword=%s\">%d</a>", i, encodedKeyword, i));
            }
        }

        // 다음 페이지 링크
        if (page < pageCount) {
            sb.append(String.format("<a href=\"/qna?page=%d&keyword=%s\">&gt;</a>", page + 1, encodedKeyword));
        }

        return sb.toString();
        
    }

	public static class PagResult {
		
        private String pagHtml;
        private List<Question> questions;
        private String keyword;

        public PagResult(String pagHtml, List<Question> questions, String keyword) {
            this.pagHtml = pagHtml;
            this.questions = questions;
            this.keyword = keyword;
        }

        public String getPagHtml() {
            return pagHtml;
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public String getKeyword() {
            return keyword;
        }
    }

    // 캐시에서 데이터를 조회하는 메서드
	public List<Question> findCachedData(Long offset, double maxList, String keyword) {
		
	    Cache cache = cacheManager.getCache("questionsCache"); 
	    List<Question> cachedData = cache != null ? cache.get(offset + ":" + keyword, List.class) : null;
	    
	    return cachedData;
	}
    

	// 캐시에 데이터를 저장하는 메서드 
	public void saveToCache(List<Question> list, Long offset, String keyword) {
	    Cache cache = cacheManager.getCache("questionsCache");
	    String cacheKey = offset + ":" + keyword;  

	    if (cache != null) {
	        cache.put(cacheKey, list); // 캐시 저장
	    }
	}
	
	public void clearAllCache() {
	    cacheManager.getCacheNames().forEach(cacheName -> {
	        cacheManager.getCache(cacheName).clear();  // 각 캐시를 초기화
	    });
	}
}


