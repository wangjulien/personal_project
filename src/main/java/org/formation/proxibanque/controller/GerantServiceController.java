package org.formation.proxibanque.controller;


import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.entity.Employee;
import org.formation.proxibanque.security.CustomUserDetails;
import org.formation.proxibanque.service.IGerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GerantServiceController {

	@Autowired
	private IGerantService gerantService;

	@RequestMapping(value = "/gerantGestionConseiller", method = RequestMethod.GET)
	public String listConseillers(Model model) {
		try {
			
			Employee user = getPrincipal();
			
			if (null != user) {

				List<Conseiller> conseillerList = 
						gerantService.listerTousClientsDuGerant(user.getId());
				model.addAttribute("conseillerList", conseillerList);

			} else {
				model.addAttribute("error", "Utilisateur non logge, essayez de relogger.");
			}

			return "/gerant/show_all_conseillers";

		} catch (DaoException e) {
			model.addAttribute("error", e.getMessage());
			return "/gerant/show_all_conseillers";
		}
	}
	
	
	private Employee getPrincipal() {
		Employee user = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof CustomUserDetails) {
			user = ((CustomUserDetails) principal).getUser();
		}
		
		return user;
	}
}
