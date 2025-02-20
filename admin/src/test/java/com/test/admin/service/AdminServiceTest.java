package com.test.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.admin.dto.AdminDTO;
import com.test.admin.entity.Admin;
import com.test.admin.repository.AdminRepository;

@SpringBootTest
public class AdminServiceTest {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void count() {
		long count = adminRepository.count();
		
		System.out.println(count);
		
		assertEquals(10, count);
	}

	@Test
	public void insertAdmin() {
		List<AdminDTO> adminDTOList = getAdminList();
		
		List<Admin> adminList = adminDTOList.stream().map(admin -> admin.toEntity()).toList();
	
		for(Admin admin: adminList) {
			if(adminRepository.findById(admin.getId()) == null) {
				adminRepository.save(admin);
			}
		}
		
		assertEquals(10, adminRepository.count());
	}
	
	public List<AdminDTO> getAdminList() {
		List<AdminDTO> list = new ArrayList<AdminDTO>();
		
		list.add(new AdminDTO("deokgrit", bCryptPasswordEncoder.encode("1234"), "김남덕", "19940415", "plando365@gmail.com"));
		list.add(new AdminDTO("yujin0510", bCryptPasswordEncoder.encode("1234"), "김유진", "20001022", "yuyujinkim65@gmail.com"));
		list.add(new AdminDTO("nhh95", bCryptPasswordEncoder.encode("1234"), "남황현", "19950131", "namhh0101001@gmail.com"));
		list.add(new AdminDTO("chimy2", bCryptPasswordEncoder.encode("1234"), "박소혜", "19940824", "prochimmy@gmail.com"));
		list.add(new AdminDTO("FJHGF", bCryptPasswordEncoder.encode("1234"), "장보화", "19960108", "rqfavz33@gmail.com"));
		list.add(new AdminDTO("jiyun980", bCryptPasswordEncoder.encode("1234"), "장지윤", "19980223", "jjyun6225@naver.com"));
		list.add(new AdminDTO("Bristolparkway", bCryptPasswordEncoder.encode("1234"), "전상수", "19930614", "ssangyongjavaprince123@gmail.com"));
		list.add(new AdminDTO("choeyouth", bCryptPasswordEncoder.encode("1234"), "최유정", "20000630", "dbwjd22ek@naver.com"));
		list.add(new AdminDTO("JayChoi97", bCryptPasswordEncoder.encode("1234"), "최재권", "19971213", "chlwornjs159@gmail.com"));
		list.add(new AdminDTO("eunwoo", bCryptPasswordEncoder.encode("1234"), "차은우", "19970330", "eunwoo@gmail.com"));
		
		return list;
	}
		
	@Test
	public void checkEncodedPasswords() {
	    List<Admin> adminList = adminRepository.findAll();

	    for (Admin admin : adminList) {
	        System.out.println("Username: " + admin.getId() + ", Encoded Password: " + admin.getPw());
	    }
	}
	
	@Test
	public void removeAdmin() {
		
		int num = 11;
		
		List<Admin> list = adminRepository.findBySeqGreaterThanEqual(11);
		
		list.stream().forEach(admin -> {
			adminRepository.delete(admin);
		});
	}
}
