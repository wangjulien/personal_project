package org.formation.proxibanque.dao;

import org.formation.proxibanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gestion des Clients
 * 
 * @author JW
 *
 */
public interface IDaoClient extends JpaRepository<Client, Long> {

	/**
	 * Renvoie la liste des clients du conseiller dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param idConseiller
	 * @return List
	 */
//	public List<Client> selectAllClientByEmployeeId(Long id);
	
//	public List<ClientParticulier> selectAllClientParticulierByConseillerId(Long idConseiller);
//	
//	public List<ClientEntreprise> selectAllClientEntrepriseByConseillerId(Long idConseiller);
	
	
}
