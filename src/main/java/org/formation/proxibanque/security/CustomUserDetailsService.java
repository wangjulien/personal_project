package org.formation.proxibanque.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.formation.proxibanque.dao.IDaoEmployee;
import org.formation.proxibanque.entity.Employee;
import org.formation.proxibanque.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER =  LoggerFactory.getLogger(CustomUserDetailsService.class);
	
//	http://www.yiibai.com/spring-security/spring-mvc-4-and-spring-security-4-integration-example.html
	
	@Autowired
    private IDaoEmployee daoEmployee;
	
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    	
    	Employee user = daoEmployee.findEmployeeByLogin(login);
    	
    	LOGGER.info("Utilisateur login ", login);
		if(user == null){
			LOGGER.info("L'utilisateur non trouve");
			throw new UsernameNotFoundException("L'utilisateur non trouve par login " + login);
		}
		
		user.getRoles().size();
        return new CustomUserDetails(user);
    }
}
