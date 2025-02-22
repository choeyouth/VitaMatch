package com.test.nutri.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.nutri.entity.Answer;
import com.test.nutri.service.QnAService.PagResult;


@SpringBootTest
public class QnAServiceTest {

    @Autowired
    private QnAService qnaService; 

//    @Test
//    public void checkQnaPagPerformance() {
//        int rotateCount = 100;  // 실행 횟수 설정
//        long beforeAvg = 0;    // 평균 시간 초기화
//        Integer page = 1;      // 페이지 번호 기본값 설정
//        String keyword = "영양제"; // 테스트 키워드
//
//        // `getQnaPag` 메서드 실행 시간 측정
//        for (int i = 0; i < rotateCount; i++) {
//            long startTime = System.nanoTime();  // 시작 시간 기록
//            PagResult result = qnaService.getQnaPag(page, keyword);  // 메서드 실행
//            long endTime = System.nanoTime();    // 끝 시간 기록
//            beforeAvg += (endTime - startTime);  // 실행 시간 누적
//        }
//
//        beforeAvg /= rotateCount;  // 평균 실행 시간 계산
//
//        // 나노초를 밀리초 및 초로 변환
//        double seconds = beforeAvg / 1_000_000_000.0;  // 초로 변환
//        double milliseconds = beforeAvg / 1_000_000.0; // 밀리초로 변환
//
//        // 성능 출력
//        System.out.printf("getQnaPag 평균 시간: %dns, %.2fms, %.2fsec\n", beforeAvg, milliseconds, seconds);
//
//        // 성능이 일정 기준 이하로 나오는지 확인하는 조건 추가 (예: 평균 시간 500ms 이하로 설정)
//        assertTrue(beforeAvg < 500_000_000, "성능이 기준을 초과했습니다.");  // 500ms 기준
//    }

    
    @Test
    public void checkFindAnswerByQuestionSeqPerformance() throws Exception {
        int rotateCount = 1;  // 실행 횟수 설정
        long beforeAvg = 0;     // 평균 시간 초기화
        Long seq = 3951L;          // 테스트용 seq 값 설정

        // `findAnswerByQuestionSeq` 메서드 실행 시간 측정
        for (int i = 0; i < rotateCount; i++) {
            long startTime = System.nanoTime();  // 시작 시간 기록
            List<Answer> answers = qnaService.getAnswersByQuestionSeq(seq);  // 메서드 실행
            long endTime = System.nanoTime();    // 끝 시간 기록
            beforeAvg += (endTime - startTime);  // 실행 시간 누적
        }

        beforeAvg /= rotateCount;  // 평균 실행 시간 계산

        // 나노초를 밀리초 및 초로 변환
        double seconds = beforeAvg / 1_000_000_000.0;  // 초로 변환
        double milliseconds = beforeAvg / 1_000_000.0; // 밀리초로 변환

        // 성능 출력
        System.out.printf("findAnswerByQuestionSeq 평균 시간: %dns, %.2fms, %.2fsec\n", beforeAvg, milliseconds, seconds);

        // 성능이 일정 기준 이하로 나오는지 확인하는 조건 추가 (예: 평균 시간 500ms 이하로 설정)
        assertTrue(beforeAvg < 500_000_000, "성능이 기준을 초과했습니다.");  // 500ms 기준
    }



}
