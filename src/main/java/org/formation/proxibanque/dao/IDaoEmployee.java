package org.formation.proxibanque.dao;

import org.formation.proxibanque.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Gestion des Conseillers
 * 
 * @author JW
 *
 */
public interface IDaoEmployee extends JpaRepository<Employee, Long> {

	public Employee findEmployeeByLogin(String login);
}
