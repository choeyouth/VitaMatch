package com.test.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.test.admin.dto.AdminDTO;
import com.test.admin.repository.AdminRepository;

import lombok.RequiredArgsConstructor;

@SpringBootTest
public class AdminTests {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	public void insertAdmin() {
		List<AdminDTO> list = getAdminList();
		
		list.stream().map(admin -> adminRepository.save(admin.toEntity()));
		
		assertEquals(10, adminRepository.count());
	}
	
	public List<AdminDTO> getAdminList() {
		List<AdminDTO> list = new ArrayList<AdminDTO>();
		
		list.add(new AdminDTO("deokgrit", bCryptPasswordEncoder.encode("1234"), "김남덕", "940415", "plando365@gmail.com"));
		list.add(new AdminDTO("yujin0510", bCryptPasswordEncoder.encode("1234"), "김유진", "001022", "yuyujinkim65@gmail.com"));
		list.add(new AdminDTO("nhh95", bCryptPasswordEncoder.encode("1234"), "남황현", "950131", "namhh0101001@gmail.com"));
		list.add(new AdminDTO("chimy2", bCryptPasswordEncoder.encode("1234"), "박소혜", "940824", "prochimmy@gmail.com"));
		list.add(new AdminDTO("FJHGF", bCryptPasswordEncoder.encode("1234"), "장보화", "960108", "rqfavz33@gmail.com"));
		list.add(new AdminDTO("jiyun980", bCryptPasswordEncoder.encode("1234"), "장지윤", "980223", "jjyun6225@naver.com"));
		list.add(new AdminDTO("Bristolparkway", bCryptPasswordEncoder.encode("1234"), "전상수", "930614", "ssangyongjavaprince123@gmail.com"));
		list.add(new AdminDTO("choeyouth", bCryptPasswordEncoder.encode("1234"), "최유정", "000630", "dbwjd22ek@naver.com"));
		list.add(new AdminDTO("JayChoi97", bCryptPasswordEncoder.encode("1234"), "최재권", "971213", "chlwornjs159@gmail.com"));
		list.add(new AdminDTO("eunwoo", bCryptPasswordEncoder.encode("1234"), "차은우", "970330", "eunwoo@gmail.com"));
		
		return list;
	}
}
