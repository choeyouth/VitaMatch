package com.test.admin.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.admin.entity.Admin;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AdminDetails implements UserDetails {
	
	private Admin admin;
	
	public AdminDetails(Admin admin) {
		this.admin = admin;
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
		return this.admin.getPw();
	}

	@Override
	public String getUsername() {
		return this.admin.getId();
	}

}
