package org.formation.proxibanque.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * La classe VisaElectron herite de Carte et a un numero de carte.
 * 
 * @author JW
 *
 */

@XmlRootElement
@Entity
@DiscriminatorValue(value = "ELECTRON")
public class VisaElectron extends Carte {
	
	
	
	public VisaElectron() {
		super();
	}

	public VisaElectron(String noCarte) {
		super(noCarte);
	}
}