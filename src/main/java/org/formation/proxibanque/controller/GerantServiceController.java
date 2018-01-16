package org.formation.proxibanque.controller;

import java.security.Principal;
import java.util.List;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.security.CustomUserDetails;
import org.formation.proxibanque.service.IGerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GerantServiceController {

	@Autowired
	private IGerantService gerantService;

	@RequestMapping(value = "/displayConseillers", method = RequestMethod.GET)
	public String listConseillers(Model model, Principal principal) {
		try {
			
			if (principal instanceof CustomUserDetails ) {
			
				List<Conseiller> conseillerList = 
						gerantService.listerTousClientsDuGerant(((CustomUserDetails)principal).getUser().getId());
				model.addAttribute("conseillerList", conseillerList);
				return "show_all_conseiller";
			} else {
				return "redirect:/login";
			}
			
			
		} catch (DaoException e) {
			model.addAttribute("error", e.getMessage());
			return "show_all_conseiller";
		}
	}
}
