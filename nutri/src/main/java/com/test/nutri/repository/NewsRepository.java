package com.test.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.nutri.entity.News;
import com.test.nutri.model.NewsDTO;

public interface NewsRepository extends JpaRepository<News, Long> {

}
