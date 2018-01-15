package org.formation.proxibanque.controller;

import org.formation.proxibanque.service.IVirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class VirementServiceController {
	
	@Autowired
	private IVirementService virementService;

}
