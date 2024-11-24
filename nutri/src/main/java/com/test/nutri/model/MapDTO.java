package com.test.nutri.model;

import lombok.Data;

@Data
public class MapDTO {
    private String name;
    private String address;
    private String tel;
    private double latitude = 0;  // 기본값
    private double longitude = 0; // 기본값
    private String openTime;  // 영업 시작 시간
    private String closeTime; // 영업 종료 시간
    private boolean open;     // 영업 여부
}
