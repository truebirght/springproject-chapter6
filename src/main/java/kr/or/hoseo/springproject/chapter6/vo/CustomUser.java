package kr.or.hoseo.springproject.chapter6.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User{
	private final static String DEF_USER_NAME = "DEF_USER";
	private final static String DEF_PASSWORD = "DEF_PWD";
	
	public CustomUser() {
		super(DEF_USER_NAME, DEF_PASSWORD, Collections.emptyList());
	}
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	private String deptName;
}
