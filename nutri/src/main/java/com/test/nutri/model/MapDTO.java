package com.test.nutri.model;

import lombok.Data;

@Data
public class MapDTO {
	
	private String hpid; //seq
	
    private String name;
    private String address;
    private String tel;
    private double latitude = 0;  // 기본값
    private double longitude = 0; // 기본값
    private String openTime;      // 영업 시작 시간
    private String closeTime; 	  // 영업 종료 시간
    private boolean open;         // 영업 여부
    private String etc; 	      //비고
    
    private String dutyTime1s; //월요일 start 시간
    private String dutyTime1c; //월요일 close 시간
    private String dutyTime2s; //화요일 start 시간
    private String dutyTime2c; //화요일 close 시간
    private String dutyTime3s; //수요일 start 시간
    private String dutyTime3c; //수요일 close 시간
    private String dutyTime4s; //목요일 start 시간
    private String dutyTime4c; //목요일 close 시간
    private String dutyTime5s; //금요일 start 시간
    private String dutyTime5c; //금요일 close 시간
    private String dutyTime6s; //토요일 start 시간
    private String dutyTime6c; //토요일 close 시간
    private String dutyTime7s; //일요일 start 시간
    private String dutyTime7c; //일요일 close 시간
    private String dutyTime8s; //공휴일 start 시간
    private String dutyTime8c; //공휴일 close 시간 
    
}
