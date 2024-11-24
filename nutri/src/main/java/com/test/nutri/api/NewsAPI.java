package com.test.nutri.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.test.nutri.model.NewsDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewsAPI {

	@Value("${api-key.news.client-id}")
	String clientId;

	@Value("${api-key.news.client-secret}")
	String clientSecret;

//	public List<NewsDTO> getNewsList() {
	public void getNewsList() {
		String search = null;
		try {
			URLEncoder.encode("영양제,건강", "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}
		
		String apiURL = String.format("https://openapi.naver.com/v1/search/news?query=%d&display=100", search);
		
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("X-Naver-Client-Id",  clientId);
		requestHeaders.put("X-Naver-Client-Secret",  clientSecret);
		
		String responseBody = get(apiURL, requestHeaders);
		
		System.out.println(responseBody);
		
	}
	
	private String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
	}
	
	private HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
	}
	
	private String readBody(InputStream body) {

        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}
