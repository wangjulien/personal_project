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

@Component
public class CustomUserService implements UserDetailsService {

	private static final Logger LOGGER =  LoggerFactory.getLogger(CustomUserService.class);
	
//	http://www.yiibai.com/spring-security/spring-mvc-4-and-spring-security-4-integration-example.html
	
	@Autowired
    private IDaoEmployee daoEmployee;
	
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    	Employee user = daoEmployee.findEmployeeByLogin(login);
        
    	LOGGER.info("Utilisateur login ", login);
		if(user == null){
			LOGGER.info("L'utilisateur non trouve");
			throw new UsernameNotFoundException("L'utilisateur non trouve par login " + login);
		}
    	
    	List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
    	
        return new User(user.getLogin(), user.getPassword(), authorities);
    }
    
    
    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
