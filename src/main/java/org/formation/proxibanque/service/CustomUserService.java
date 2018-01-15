package org.formation.proxibanque.service;

import org.formation.proxibanque.dao.IDaoConseiller;
import org.formation.proxibanque.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserService implements UserDetailsService {

//	http://www.yiibai.com/spring-security/spring-mvc-4-and-spring-security-4-integration-example.html
	
	@Autowired
    private IDaoConseiller daoConseiller;
	
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee user = daoConseiller.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }

}
