package com.test.nutri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		//기존에 리소스 + 페이지 접근 + csrf 토큰 설정 다 섞여 있어서 분리 시켰습니다.
		
		//정적 리소스 접근 허용
		http.headers((headerConfig) -> headerConfig.frameOptions((frameOptionConfig -> frameOptionConfig.disable())));
		
		//페이지 접근 허용
		http.authorizeHttpRequests((auth) -> 
	            auth
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated());
		

		//CSRF 토큰 해제
		//http.csrf(auth -> auth.disable());
		
		//커스텀 로그인 설정
		http.formLogin(auth -> auth
				.loginPage("/login") //사용자 로그인 페이지 URL
				.defaultSuccessUrl("/") //로그인 성공시 페이지 URL 
				.loginProcessingUrl("/loginok").permitAll());
		
		return http.build();
		
		
		
	}
	
	//암호화 객체
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	//로그아웃 설정
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

		http.logout(auth -> auth
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
				);
		
		return http.build();
	}
	
	
}
