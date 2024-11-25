package com.test.nutri.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.nutri.api.MapAPI;
import com.test.nutri.model.MapDTO;

@Service
public class MapService {

    private final MapAPI mapAPI;
    private final ObjectMapper objectMapper = new ObjectMapper(); 

    public MapService(MapAPI mapAPI) {
        this.mapAPI = mapAPI;
    }
    
    // 메서드 분리하고 싶음....
    public List<MapDTO> getPharmacyList(String url) {
    	
    	System.out.println(url);
        List<MapDTO> pharmacyList = new ArrayList<>();
        HttpURLConnection conn = null;
        
        try {
            // API 호출
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                // 응답 읽기
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();

                // XML 파싱
                String xmlResponse = sb.toString();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new ByteArrayInputStream(xmlResponse.getBytes()));

                // XML에서 데이터 추출
                Element root = doc.getDocumentElement();
                NodeList items = root.getElementsByTagName("item");

                for (int i = 0; i < items.getLength(); i++) {
                    Node itemNode = items.item(i);
                    if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element itemElement = (Element) itemNode;

                        // MapDTO에 매핑
                        MapDTO dto = new MapDTO();
                        dto.setName(getTagValue("dutyName", itemElement, "정보 없음"));
                        dto.setAddress(getTagValue("dutyAddr", itemElement, "정보 없음"));
                        dto.setTel(getTagValue("dutyTel1", itemElement, "정보 없음"));
                        dto.setHpid(getTagValue("hpid", itemElement, null));

                        // Latitude와 Longitude
                        String latStr = getTagValue("wgs84Lat", itemElement, "0");
                        String lonStr = getTagValue("wgs84Lon", itemElement, "0");
                        dto.setLatitude(Double.parseDouble(latStr.isEmpty() ? "0" : latStr));
                        dto.setLongitude(Double.parseDouble(lonStr.isEmpty() ? "0" : lonStr));

                        //요일 숫자 구하기
                        LocalDate date = LocalDate.now();
                        DayOfWeek week = date.getDayOfWeek();
                        int weekNum = week.getValue();
                        
                        // 영업 시간
                        String openTime = getTagValue("dutyTime" + weekNum + "s", itemElement, null);
                        String closeTime = getTagValue("dutyTime" + weekNum + "c", itemElement, null);
                        dto.setOpenTime(openTime);
                        dto.setCloseTime(closeTime);
                        
                        // 영업 여부 계산
                        if (openTime != null && closeTime != null) {
                            int currentHour = LocalTime.now().getHour();
                            int currentMinute = LocalTime.now().getMinute();
                            int openHour = Integer.parseInt(openTime.substring(0, 2));
                            int openMinute = Integer.parseInt(openTime.substring(2, 4));
                            int closeHour = Integer.parseInt(closeTime.substring(0, 2));
                            int closeMinute = Integer.parseInt(closeTime.substring(2, 4));

                            // 현재 시간이 영업 시간 안에 있는지 확인
                            boolean isOpen = (currentHour > openHour || (currentHour == openHour && currentMinute >= openMinute)) &&
                                             (currentHour < closeHour || (currentHour == closeHour && currentMinute <= closeMinute));
                            dto.setOpen(isOpen);
                        } else {
                            dto.setOpen(false); // 영업 시간 정보가 없으면 false
                        }
                        
                        //월~일, 공휴일 영업 시간
                        for (int j = 1; j <= 8; j++) {
                            String dutyTimeStart = getTagValue("dutyTime" + j + "s", itemElement, "정기 휴무");
                            String dutyTimeClose = getTagValue("dutyTime" + j + "c", itemElement, "정기 휴무");

                            switch (j) {
                                case 1:
                                    dto.setDutyTime1s(dutyTimeStart);
                                    dto.setDutyTime1c(dutyTimeClose);
                                    break;
                                case 2:
                                    dto.setDutyTime2s(dutyTimeStart);
                                    dto.setDutyTime2c(dutyTimeClose);
                                    break;
                                case 3:
                                    dto.setDutyTime3s(dutyTimeStart);
                                    dto.setDutyTime3c(dutyTimeClose);
                                    break;
                                case 4:
                                    dto.setDutyTime4s(dutyTimeStart);
                                    dto.setDutyTime4c(dutyTimeClose);
                                    break;
                                case 5:
                                    dto.setDutyTime5s(dutyTimeStart);
                                    dto.setDutyTime5c(dutyTimeClose);
                                    break;
                                case 6:
                                    dto.setDutyTime6s(dutyTimeStart);
                                    dto.setDutyTime6c(dutyTimeClose);
                                    break;
                                case 7:
                                    dto.setDutyTime7s(dutyTimeStart);
                                    dto.setDutyTime7c(dutyTimeClose);
                                    break;
                                case 8:
                                    dto.setDutyTime8s(dutyTimeStart);
                                    dto.setDutyTime8c(dutyTimeClose);
                                    break;
                            }
                        }
                        
                        //비고 
                        String etc = getTagValue("dutyEtc", itemElement, "-");
                        dto.setEtc(etc);
                        
                        pharmacyList.add(dto);
                    }
                }

            } else {
                throw new RuntimeException("API 호출 실패: HTTP 상태 코드 " + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pharmacyList;
    }


	private String getTagValue(String tag, Element element, String defaultValue) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0 && nodeList.item(0).getChildNodes().getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        System.out.println("태그 [" + tag + "]가 존재하지 않거나 값이 비어 있습니다.");
        return defaultValue;
    }

	public MapDTO getPharmacyInfo(String url) {

		
		
		return null;
	}


}
