package org.formation.proxibanque.dao;

import static org.junit.Assert.assertNotNull;

import org.formation.proxibanque.config.WebConfig;
import org.formation.proxibanque.entity.Adresse;
import org.formation.proxibanque.entity.Conseiller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Test unitaire pour test la fonction logger par login 
 * 
 * @author adminl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class TestLoginService {

	@Autowired
	private IDaoEmployee daoEmployee;
	
	@Autowired
	private IDaoConseiller daoConseiller;
	

	@Test
	public void login_Should_Find_User() {
		assertNotNull(daoEmployee);
		assertNotNull(daoConseiller);
		
		Adresse add = new Adresse("Paris", 75001, "IdF", "0123456789");
		Conseiller leConseiller = new Conseiller("JUnit", "test", "J001", add);
		leConseiller.setLogin("Test");
		daoConseiller.save(leConseiller);
		
		assertNotNull(daoEmployee.findEmployeeByLogin("Test"));
	}
	
}
