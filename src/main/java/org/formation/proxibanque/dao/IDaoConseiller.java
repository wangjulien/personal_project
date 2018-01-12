package org.formation.proxibanque.dao;

import java.util.List;

import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gestion des Conseillers
 * 
 * @author JW
 *
 */
public interface IDaoConseiller extends JpaRepository<Conseiller, Long> {


//	public List<Conseiller> findAllConseillerByGerantId(Long idGerant);
//
//	public Employee findEmployeeByLoginAndPassword(String login, String password);
}
