package org.formation.proxibanque.service;

import static org.junit.Assert.assertNotNull;

import org.formation.proxibanque.config.ApplicationConfig;
import org.formation.proxibanque.dao.DaoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TestLoginService {

	@Autowired
	private ILoginService loginService;
	
	

	@Test
	public void login_Should_Find_User() {
		assertNotNull(loginService);
		
		try {
			assertNotNull(loginService.login("login", "password"));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
