package com.test.nutri.service;

import org.springframework.stereotype.Service;

import com.test.nutri.repository.NutriRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NutriService {

	private final NutriRepository nutriRepository;
	
	
}
