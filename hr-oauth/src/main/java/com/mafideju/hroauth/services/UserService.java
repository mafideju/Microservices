package com.mafideju.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mafideju.hroauth.entities.User;
import com.mafideju.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		
		User user = userFeignClient.findByEmail(email).getBody();
		
		if (user == null) {
			logger.error("Email Não Encontrado => " + email);
			throw new IllegalArgumentException("** EMAIL NÃO ENCONTRADO **");
		}
		
		logger.info("EMAIL -> " + email);
		
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userFeignClient.findByEmail(username).getBody();
		
		if (user == null) {
			logger.error("Email Não Encontrado => " + username);
			throw new UsernameNotFoundException("** USUARIO NÃO ENCONTRADO **");
		}
		
		logger.info("Username -> " + username);
		
		return user;
	}
}
