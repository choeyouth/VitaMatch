package com.test.nutri.entity;

import java.time.LocalDate; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq_generator")
	@SequenceGenerator(name="news_seq_generator", sequenceName = "seqMember", allocationSize = 1)
	private Long seq;
	
	private String title;
	private String link;
	private String originalLink;
	private String description;
	private LocalDate regDate;
}
