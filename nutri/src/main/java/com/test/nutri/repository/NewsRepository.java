package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {

}
