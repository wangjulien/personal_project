package org.formation.proxibanque.service;

import java.util.ArrayList;
import java.util.List;

import org.formation.proxibanque.config.Config;
import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.dao.IDaoClient;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.ClientEntreprise;
import org.formation.proxibanque.entity.ClientParticulier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe qui regroupe tous les traitements concernant un Conseiller courrant.
 * 		- Ajouter un Client
 * 		- Recuperer un Client par son ID, lire toutes ces informations (data)
 * 		- Modifier un Client
 * 		- Supprimer un Client
 * 		- Lister tous les Client dans persistence
 * 		- ToDo : simulationCredit et gestionPatrimoine
 * 
 * DaoClient est utilise ici pour Chercher ou Modifier l'information dans persistance
 *  * 
 * @author JW
 *
 */

@Service
public class ConseillerService implements IConseillerService {
		
	@Autowired
	private IDaoClient daoClient;

	public ConseillerService() {
		super();
	}
	
	@Override
	public Client chercherClient(Long idClient) throws DaoException {
		return daoClient.findOne(idClient);		
	}

	/**
	 * Ajout d'un client dans la persistence
	 * @param client : client a ajouter
	 * @throws DaoException DaoException
	 */
	public void ajouterClient(Client client) throws DaoException {
		
		daoClient.save(client);
		
		// Strategy local de generer reference client automatique
		if (client.getRefClient().isEmpty())
			client.setRefClient(Config.PREFIX_CLI_REF + client.getId());
		
		daoClient.save(client);
	}


	/**
	 * Mettre a jour un client dans la persistence
	 * @param client : le client modifie
	 * @throws DaoException  DaoException
	 */
	public void modifierClient(Client client) throws DaoException {
		daoClient.save(client);
	}

	/**
	 * Suppression d'un client donne dans persistence
	 * @param client : le client a supprimer
	 * @throws DaoException  DaoException
	 */
	public void supprimerClient(Client client) throws DaoException {
		daoClient.delete(client);;
	}

	/**
	 * Recupere tous les client de la persistence
	 * @return : une liste de client
	 * @throws DaoException  DaoException
	 */
	public List<Client> listerTousClients() throws DaoException {
		return daoClient.findAll();

	}
	
	/**
	 * Recupere tous les client de la persistence
	 * @return : une liste de client
	 * @throws DaoException  DaoException
	 */
	public List<Client> listerClientsDeConseiller(Long idConseiller) throws DaoException {
//		return daoClient.selectAllClientByEmployeeId(idConseiller);
		return new ArrayList<>();
	}

	@Override
	public List<ClientParticulier> listerClientsParticulierDeConseiller(Long idConseiller) throws DaoException {
//		return daoClient.selectAllClientParticulierByConseillerId(idConseiller);
		return new ArrayList<>();
	}


	@Override
	public List<ClientEntreprise> listerClientsEntrepriseDeConseiller(Long idConseiller) throws DaoException {
//		return daoClient.selectAllClientEntrepriseByConseillerId(idConseiller);
		return new ArrayList<>();
	}


}
