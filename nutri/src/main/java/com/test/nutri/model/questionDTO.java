package com.test.nutri.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.UpdateTimestamp;

import com.test.nutri.entity.Question;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class questionDTO {

	private Long seq;
	private Long memberSeq;
	private String title;
	private String content;
	private Boolean isSolved;
	//private LocalDateTime regDate;
	//private LocalDateTime modDate;
	
	@UpdateTimestamp
	@Column(name = "regDate")
	private LocalDateTime regDate;
	
	@UpdateTimestamp
	@Column(name = "modDate")
	private LocalDateTime modDate;

//    public void setRegDate(String regDate) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
//        this.regDate = LocalDateTime.parse(regDate, formatter);
//    }
//    
//    public void setModDate(String modDate) {
//    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
//    	this.modDate = LocalDateTime.parse(modDate, formatter);
//    }
    
    
//	public Question toEntity() {
//		return Quesion.builder()
//				.title(title)
//				.originalLink(originallink)
//				.link(link)
//				.description(description)
//				.regDate(regDate)
//				.build();
//	}
}
