/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.formation.proxibanque.dao;

import org.formation.proxibanque.entity.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de gestion d'une Agence
 *
 * @author JW 
 */

public interface IDaoAgence extends JpaRepository<Agence, Long> {

       
}
