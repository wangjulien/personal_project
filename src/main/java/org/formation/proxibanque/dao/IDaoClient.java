package org.formation.proxibanque.dao;

import java.util.List;

import org.formation.proxibanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface ext. JapRepository de DAO Clients
 * 
 * @author JW NC
 *
 */
public interface IDaoClient extends JpaRepository<Client, Long> {

	/**
	 * Renvoie la liste des clients du conseiller dont l'identifiant est fourni en
	 * parametre
	 * 
	 * @param id
	 * @return List
	 */
	public List<Client> findByConseillerId(Long id);
	
//	@Query("select e from Employee e join e.roles r where e.login = (:login)")
//	public List<ClientParticulier> selectAllClientParticulierByConseillerId(Long idConseiller);
//	
//	public List<ClientEntreprise> selectAllClientEntrepriseByConseillerId(Long idConseiller);
	
	
}
