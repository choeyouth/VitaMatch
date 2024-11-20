package com.test.nutri.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrfConfig) -> csrfConfig.disable())
			.headers((headerConfig) -> headerConfig.frameOptions((frameOptionConfig -> frameOptionConfig.disable())))
			.authorizeHttpRequests((authorizeRequests) -> 
	            authorizeRequests
                .requestMatchers("/**").permitAll() // 정적 리소스 접근 허용
                .anyRequest().authenticated());

		
		return http.build();
	}
}
