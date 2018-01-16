package org.formation.proxibanque.dao;

import org.formation.proxibanque.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Gestion des Conseillers
 * 
 * @author JW
 *
 */
public interface IDaoEmployee extends JpaRepository<Employee, Long> {
	
	public Employee findEmployeeByLogin(@Param("login") String login);
}
