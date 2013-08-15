package com.net.models.service;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.net.models.dao.UserDetailsImpl;
import org.springframework.stereotype.Service;

@Service("myUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static Map<String, UserDetails> userRepository = new HashMap<String, UserDetails>();
	
	static {
		GrantedAuthority authorityAdmin = new SimpleGrantedAuthority("ADMIN");
		GrantedAuthority authorityGuest = new SimpleGrantedAuthority("ROLE_USER");
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		authorities.add(authorityAdmin);
		
		authorities.add(authorityGuest);
		
		UserDetails user =  new UserDetailsImpl("user", "password", authorities);
		
		userRepository.put("user", user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails matchingUser = userRepository.get(username);
		
		if(matchingUser == null){
			throw new UsernameNotFoundException("You Moron get outta here!!!");
		}
		
		return matchingUser;
	}

}
