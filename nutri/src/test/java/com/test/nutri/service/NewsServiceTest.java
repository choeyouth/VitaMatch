package com.test.nutri.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewsServiceTest {

	@Autowired
	private NewsService newsService;
	
	@Test
	public void checkTime() {
		int count = 20;
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
		
		assertEquals(true, true);
	}
}
