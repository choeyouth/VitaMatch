package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
