package org.formation.proxibanque.controller;

import org.formation.proxibanque.service.IGerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class GerantServiceController {
	
	@Autowired
	private IGerantService gerantService;

}
