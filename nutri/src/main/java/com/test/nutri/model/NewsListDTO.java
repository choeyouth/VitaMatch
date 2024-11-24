package com.test.nutri.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;

@Data
public class NewsListDTO {

	private LocalDateTime lastBuildDate;
	private Long total;
	private int start;
	private int display;
	private List<NewsDTO> items;

    public void setLastBuildDate(String lastBuildDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
        this.lastBuildDate = LocalDateTime.parse(lastBuildDate, formatter);
    }
}
