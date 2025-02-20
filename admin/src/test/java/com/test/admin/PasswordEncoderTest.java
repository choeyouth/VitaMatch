package com.test.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	
    public static void main(String[] args) {
    	
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("1111");
        System.out.println("Encoded Password: " + encodedPassword);
        
    }
    
}