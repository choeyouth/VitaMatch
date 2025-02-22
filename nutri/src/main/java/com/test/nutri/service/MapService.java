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

/**
 * MapService
 * MapService 클래스는 약국 API에서 데이터를 가져와 파싱하고, 
 * 이를 MapDTO 객체로 변환하여 반환하는 서비스 클래스입니다. 
 * 이 클래스는 약국 목록 및 세부 정보를 조회하고, 
 * 운영 시간과 영업 여부를 계산하여 클라이언트에 제공하는 역할을 합니다.
 * @Service Spring 서비스 클래스 정의
 * @author YuJeong Choi
 */
@Service
public class MapService {

    private final MapAPI mapAPI;
    private final ObjectMapper objectMapper = new ObjectMapper(); 

    public MapService(MapAPI mapAPI) {
        this.mapAPI = mapAPI;
    }

    public List<MapDTO> getPharmacyList(String url) {
        System.out.println(url);
        List<MapDTO> pharmacyList = new ArrayList<>();
        HttpURLConnection conn = null;
        
        try {
            conn = createConnection(url);
            if (conn.getResponseCode() == 200) {
                String xmlResponse = getXmlResponse(conn);
                Document doc = parseXmlResponse(xmlResponse);
                pharmacyList = extractPharmacyData(doc);
            } else {
                throw new RuntimeException("API 호출 실패: HTTP 상태 코드 " + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pharmacyList;
    }

    private HttpURLConnection createConnection(String url) throws Exception {
    	
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        
        return conn;
    }

    private String getXmlResponse(HttpURLConnection conn) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        br.close();
        return sb.toString();
    }

    private Document parseXmlResponse(String xmlResponse) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xmlResponse.getBytes()));
    }

    private List<MapDTO> extractPharmacyData(Document doc) {
    	
        List<MapDTO> pharmacyList = new ArrayList<>();
        Element root = doc.getDocumentElement();
        NodeList items = root.getElementsByTagName("item");

        for (int i = 0; i < items.getLength(); i++) {

        	Node itemNode = items.item(i);
            
            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                Element itemElement = (Element) itemNode;
                MapDTO dto = mapItemToDto(itemElement);
                pharmacyList.add(dto);
            }
        }
        
        return pharmacyList;
    }

    private MapDTO mapItemToDto(Element itemElement) {
    	
        MapDTO dto = new MapDTO();
        
        dto.setName(getTagValue("dutyName", itemElement, "정보 없음"));
        dto.setAddress(getTagValue("dutyAddr", itemElement, "정보 없음"));
        dto.setTel(getTagValue("dutyTel1", itemElement, "정보 없음"));
        dto.setHpid(getTagValue("hpid", itemElement, null));

        setCoordinates(dto, itemElement);
        setOperatingHours(dto, itemElement);
        setHolidayHours(dto, itemElement);
        dto.setEtc(getTagValue("dutyEtc", itemElement, "-"));

        return dto;
    }

    private void setCoordinates(MapDTO dto, Element itemElement) {
    	
        String latStr = getTagValue("wgs84Lat", itemElement, "0");
        String lonStr = getTagValue("wgs84Lon", itemElement, "0");
        dto.setLatitude(Double.parseDouble(latStr.isEmpty() ? "0" : latStr));
        dto.setLongitude(Double.parseDouble(lonStr.isEmpty() ? "0" : lonStr));
        
    }

    private void setOperatingHours(MapDTO dto, Element itemElement) {
    	
        LocalDate date = LocalDate.now();
        DayOfWeek week = date.getDayOfWeek();
        int weekNum = week.getValue();
        
        String openTime = formatTime(getTagValue("dutyTime" + weekNum + "s", itemElement, "0000"), "00:00");
        String closeTime = formatTime(getTagValue("dutyTime" + weekNum + "c", itemElement, "0000"), "00:00");

        dto.setOpenTime(openTime);
        dto.setCloseTime(closeTime);

        setBusinessStatus(dto, openTime, closeTime);
    }

    private void setBusinessStatus(MapDTO dto, String openTime, String closeTime) {
    	
        if (!"정기 휴무".equals(openTime) && !"정기 휴무".equals(closeTime)) {
        	
            try {
                LocalTime open = LocalTime.parse(openTime);
                LocalTime close = LocalTime.parse(closeTime);
                LocalTime now = LocalTime.now();
                dto.setOpen(now.isAfter(open) && now.isBefore(close));
            } catch (Exception e) {
                System.out.println("영업 여부 계산 중 오류 발생: " + e.getMessage());
                dto.setOpen(false); // 오류 발생 시 닫힘 상태로 처리
            }
            
        } else {
            dto.setOpen(false); // "정기 휴무"인 경우 영업하지 않음
        }
    }

    private void setHolidayHours(MapDTO dto, Element itemElement) {
    	
        for (int j = 1; j <= 8; j++) {
        	
            String dutyTimeStart = formatTime(getTagValue("dutyTime" + j + "s", itemElement, "정기 휴무"), "00:00");
            String dutyTimeClose = formatTime(getTagValue("dutyTime" + j + "c", itemElement, "정기 휴무"), "00:00");

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
    }

    private String getTagValue(String tag, Element element, String defaultValue) {
    	
        NodeList nodeList = element.getElementsByTagName(tag);
        
        if (nodeList.getLength() > 0 && nodeList.item(0).getChildNodes().getLength() > 0) {
            String value = nodeList.item(0).getTextContent();
            return (value != null && !value.isEmpty()) ? value : defaultValue;
        }
        
        return defaultValue;
    }

    private String formatTime(String time, String defaultValue) {
    	
        if ("정기 휴무".equals(time)) {
            return time;
        }

        if (time == null || time.isEmpty() || time.length() < 4) {
            return defaultValue;
        }
        try {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(2, 4));
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new IllegalArgumentException("유효하지 않은 시간 값: " + time);
            }
            return String.format("%02d:%02d", hour, minute);
        } catch (Exception e) {
            System.out.println("시간 포맷팅 중 오류 발생: " + e.getMessage());
            return defaultValue;
        }
        
    }
}

 
