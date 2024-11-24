package com.test.nutri.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.test.nutri.entity.News;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsDTO {

	private String title;
	private String originallink;
	private String link;
	private String description;
	private LocalDateTime pubDate;
	
    public void setPubDate(String pubDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
        this.pubDate = LocalDateTime.parse(pubDate, formatter);
    }

	public News toEntity() {
		return News.builder()
				.title(title)
				.originalLink(originallink)
				.link(link)
				.description(description)
				.regDate(pubDate)
				.build();
	}
}
