package org.formation.proxibanque.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.proxibanque.entity.Employee;
import org.formation.proxibanque.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controleur des acces post-login (login (POST) est gere par Spring Security)
 *  - /login  		view login
 *  - /conseiller  	vheiculer le conseiller logge
 *  - /gerant		vheiculer le gerant logge
 *  - /logout		view logout
 *  
 * @author JW
 *
 */
@Controller
public class LoginServiceController {

	
	@RequestMapping(value = "/conseiller", method = RequestMethod.GET)
	public String conseillerPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "conseiller/conseiller_welcome";
	}

	@RequestMapping(value = "/gerant", method = RequestMethod.GET)
	public String gerantPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "gerant/gerant_welcome";
	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "access_denied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
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
