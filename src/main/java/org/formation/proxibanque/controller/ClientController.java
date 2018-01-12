package org.formation.proxibanque.controller;

import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.service.IConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	@Autowired
	private IConseillerService conseillerService;
	
	@RequestMapping(value = "/displayClients", method = RequestMethod.GET)
	public ModelAndView listClients() {
		List<Client> listClient;
		try {
			listClient = conseillerService.listerTousClients();
			return new ModelAndView("displayClients", "clients", listClient);
		} catch (DaoException e) {
			return new ModelAndView("errorPage", "msg", e.getMessage());
		}
	}
	
}
