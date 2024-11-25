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

    public String createPharmacyUrl(String sido, String gugun, int page, String keyword) {
    	 try {
    	        String baseUrl = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire";
    	        String apiKey = pharmacyKey;
    	        
    	        // URL 인코딩
    	        String encodedSido = URLEncoder.encode(sido, StandardCharsets.UTF_8);
    	        String encodedGugun = URLEncoder.encode(gugun, StandardCharsets.UTF_8);
    	        String encodedKeyword = keyword != null ? URLEncoder.encode(keyword, StandardCharsets.UTF_8) : "";

    	        // URL 생성
    	        String url = String.format(
    	            "%s?serviceKey=%s&Q0=%s&Q1=%s&QN=%s&pageNo=%d&numOfRows=10",
    	            baseUrl, apiKey, encodedSido, encodedGugun, encodedKeyword, page
    	        );
    	        
    	        System.out.println(url);

    	        return url;
    	        
    	    } catch (Exception e) {
    	        throw new RuntimeException("URL 생성 중 오류 발생", e);
    	    }
    }

     
}

