package com.test.nutri.api;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.test.nutri.model.MapDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapAPI {
    
    @Value("${api-key.kakaomap.appkey}")
    private String kakaomap;
    
    @Value("${api-key.pharmacy.appkey}")
    private String pharmacyKey;

    public String getMap(Model model) {
        model.addAttribute("kakaoApiKey", kakaomap);
        return "page/map"; 
    }
    
    public String getPharmacyApiKey() {
        return pharmacyKey;
    }

    public String pharmacyListUrl(String sido, String gugun, int page, String keyword) {
    	
    	 try {
    	        String baseUrl = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";
    	        String apiKey = pharmacyKey;
    	        
    	        // URL 인코딩
    	        String encodedSido = URLEncoder.encode(sido, StandardCharsets.UTF_8);
    	        String encodedGugun = URLEncoder.encode(gugun, StandardCharsets.UTF_8);
    	        String encodedKeyword = keyword != null ? URLEncoder.encode(keyword, StandardCharsets.UTF_8) : "";

    	        // URL 생성
    	        String url = String.format(
    	            "%s?serviceKey=%s&Q0=%s&Q1=%s&QN=%s&pageNo=%d&numOfRows=1000000",
    	            baseUrl, apiKey, encodedSido, encodedGugun, encodedKeyword, page
    	        );
    	        
    	        System.out.println("페이징 테스트 " + url);
    	        
    	        return url;
    	        
    	    } catch (Exception e) {
    	        throw new RuntimeException("URL 생성 중 오류 발생", e);
    	    }

    }

	public String pharmacyInfoUrl(String hpid) {
		
		String url = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyBassInfoInqire"
				   + "?serviceKey=" + pharmacyKey
				   + "&HPID=" + hpid;
		
		return url;
	}

	
	//1. 페이징 - 꿑!
	//2. 영업중, 영업종료 폰트 색상
	//3. 약국 이름 볼드체
	//4. 영업시간 09:00 < ':' 추가
	//5. null 처리
	//6. 매핑 마커 - 끝!
	//7. 검색할 때 약국 이름으로만 가능한 것.... - 어쩔수없음!
	//8. 추가 기능 > gps, 주소
     
}

