package com.test.nutri.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@link NewsService} 클래스의 메서드 성능을 테스트하는 클래스입니다.
 * 주어진 두 메서드의 실행 시간을 측정하여 성능 개선 여부를 비교합니다.
 * 
 * @author chimy2
 */
@SpringBootTest
public class NewsServiceTest {

    /**
     * {@link NewsService} 클래스의 인스턴스.
     * Spring의 의존성 주입을 통해 자동으로 주입됩니다.
     */
	@Autowired
	private NewsService newsService;

    /**
     * {@link NewsService}의 두 메서드(`updateLatestNews`와 `updateLatestNewsBinary`)의 평균 실행 시간을 비교하는 테스트 메서드입니다.
     * 각 메서드에 대해 20번의 실행 시간을 측정하고, 평균 실행 시간을 출력합니다.
     * 성능 향상 여부를 비교하는 용도로 사용됩니다.
     */
	@Test
	public void checkTime() {
		int count = 15;
		long beforeAvg = 0;
		long afterAvg = 0;
		
		for(int i=0; i<count; i++) {
			long startTime = System.nanoTime();
			newsService.updateLatestNews();
			
			long endTime = System.nanoTime();
			
			beforeAvg += endTime - startTime;
		}
		
		beforeAvg /= count;
		
		for(int i=0; i<count; i++) {
			long startTime = System.nanoTime();
			
			newsService.updateLatestNewsBinary();
			
			long endTime = System.nanoTime();
			
			afterAvg += endTime - startTime;
		}
		
		afterAvg /= count;
		
		System.out.printf("이전 메서드 평균 시간: %dns, %dms, %dsec\n", beforeAvg, beforeAvg/1000, beforeAvg/1000/1000);
		System.out.printf("개선 메서드 평균 시간: %dns, %dms, %dsec\n", afterAvg, afterAvg/1000, afterAvg/1000/1000);
//		이전 메서드 평균 시간: 941538946ns, 941538ms, 941sec
//		개선 메서드 평균 시간: 98812940ns, 98812ms, 98sec
		
		assertEquals(true, beforeAvg > afterAvg);
	}
}
