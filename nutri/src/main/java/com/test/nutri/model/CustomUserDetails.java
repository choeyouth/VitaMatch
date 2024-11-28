package com.test.nutri.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.nutri.entity.Member;

import lombok.Getter;

@Getter
public class CustomUserDetails implements UserDetails {

	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                String role = "ROLE_MEMBER";
            	return role;
            }
        });

        return authorities;
	}

	@Override
	public String getPassword() {
		
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		
		return member.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		//DB -> 관련 컬럼(active) 존재
		//계정 만료 유무? (활성화 계정이냐 탈퇴 계정이냐?)
		
		//return UserDetails.super.isAccountNonExpired();
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		//계정 잠금 상태
		
		//return UserDetails.super.isAccountNonLocked();
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {

		//자격 증명(암호) 만료 상태
		//암호 90일 마다 변경하세요 -> 이런 것 통제
		
		//return UserDetails.super.isCredentialsNonExpired();
		return true;
	}
	
	@Override
	public boolean isEnabled() {

		//사용 유무
		
		//return UserDetails.super.isEnabled();
		return true;
	}
	
	
	
}