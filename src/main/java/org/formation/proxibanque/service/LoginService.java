package org.formation.proxibanque.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.IDaoAgence;
import org.formation.proxibanque.dao.IDaoConseiller;
import org.formation.proxibanque.entity.Adresse;
import org.formation.proxibanque.entity.Agence;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientEntreprise;
import org.formation.proxibanque.entity.ClientParticulier;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;
import org.formation.proxibanque.entity.Gerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Gestion de l'authentification utilisateur
 * 
 * 
 * @author JW
 *
 */

@Service
public class LoginService implements ILoginService {

	@Autowired
	private IDaoConseiller daoConseiller;
	
	@Autowired
	private IDaoAgence daoAgence;


	public LoginService() {
		super();
	}
	
	@PostConstruct
	public void createSomeClient() {
		
		Adresse add = new Adresse("Paris", 75001, "IdF", "0123456789");
		
		Client client01 = new ClientParticulier("WANG", "Julien", "CL001", new Adresse("Palaiseau", 91120, "IdF", "01234567"));
		Client client02 = new ClientParticulier("CLIENT02", "client02", "CL002", new Adresse("Palaiseau", 91120, "IdF", "01234567"));
		Client client03 = new ClientParticulier("CLIENT03", "client03", "CL003", new Adresse("Palaiseau", 91120, "IdF", "01234567"));
		Client client04 = new ClientParticulier("CLIENT04", "client04", "CL004", new Adresse("Palaiseau", 91120, "IdF", "01234567"));
		Client client05 = new ClientParticulier("CLIENT05", "client05", "CL005", new Adresse("Palaiseau", 91120, "IdF", "01234567"));
		
		
		Client enterprise1 = new ClientEntreprise("Darty", "EJ001883", "CL006", add);
		Client enterprise2 = new ClientEntreprise("Carrefour", "EJ001223", "CL007", add);
		Client enterprise3 = new ClientEntreprise("Auchan", "E001234", "CL008", add);
		Client enterprise4 = new ClientEntreprise("SFR", "EJ9179875", "CL009", add);
		
		
		Conseiller leConseiller = new Conseiller("WANG", "Jiliang", "C001", add);
		leConseiller.addClient(client01);
		leConseiller.addClient(client02);
		leConseiller.addClient(client03);
		leConseiller.addClient(client04);
		leConseiller.addClient(client05);
		leConseiller.addClient(enterprise1);
		leConseiller.addClient(enterprise2);
		leConseiller.addClient(enterprise3);
		leConseiller.addClient(enterprise4);
		
		Gerant leGerant = new Gerant("Dupant", "Leo", "CG002", add);
		Agence leAgence = new Agence("0001", LocalDateTime.now().toString(), leGerant);
		
		leGerant.addConseiller(leConseiller);
		leAgence.setGerant(leGerant);
		
		daoAgence.save(leAgence);
	}

	/**
	 * Retourne le premier conseiller de la base de donnee correspondant au login et
	 * au psw fournis en parametre renvoie null si aucun conseiller ne correspond
	 * 
	 * @param login
	 *            du conseiller
	 * @param psw
	 *            du conseiller
	 * @return Conseiller 
	 * 				le conseiller trouve ou null
	 * @throws DaoException
	 *             la requete a achouee
	 */
	public Employee login(String login, String psw) throws DaoException {
//		Employee em = daoConseiller.findEmployeeByLoginAndPassword(login, psw);
//
//		return em;
		return null;
	}

}
