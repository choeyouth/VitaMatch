package com.test.nutri.entity;

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
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
	@SequenceGenerator(name="member_seq_generator", sequenceName = "seqMember", allocationSize = 1)
	private Long seq;
}
