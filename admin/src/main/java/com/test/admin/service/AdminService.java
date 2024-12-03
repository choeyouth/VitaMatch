package com.test.admin.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.admin.auth.AdminDetails;
import com.test.admin.entity.Admin;
import com.test.admin.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {
	
	private final AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin admin = adminRepository.findById(username);

		System.out.println(admin);
		
		if (admin != null) {
			return new AdminDetails(admin);
		}
		
		return null;
	}

}
