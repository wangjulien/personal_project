package org.formation.proxibanque.controller;

import java.util.List;
import java.util.Map;

import org.formation.proxibanque.dao.DaoException;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.service.IConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controleur de gestion de client:
 * 	- lister tous les clients
 * 	- modification des champs d'un client selectionne
 * 
 * @author JW
 *
 */
@Controller
public class ClientController {
	
	@Autowired
	private IConseillerService serviceC;


	@RequestMapping(value = "/conseillerGestionClient", method = RequestMethod.GET) // MAPPING servlet qui apparait page adresse
																			// ,non codée
	public ModelAndView ListClients() throws DaoException {

		// List<Client> l=crudClientDAO.findAll();
		List<Client> l = serviceC.listerTousClients();
		return new ModelAndView("/conseiller/displayClients", "cleclients", l); // à l'appel du controller ... code retour
																	// ServletDispatcher K (EL / V
																	// essaie K.jsp
	}

	@RequestMapping(value = "/editClients", method = RequestMethod.GET)
	public ModelAndView editClients() throws DaoException {
		// List<Client> l=crudClientDAO.findAll();
		List<Client> l = serviceC.listerTousClients();
		return new ModelAndView("/conseiller/editClients", "cleclients", l);

	}

	@RequestMapping(value = "/editLoginClient", method = RequestMethod.GET) // retour page index
	public ModelAndView editLoginClient(@RequestParam(value = "idC", defaultValue = "1") Integer value) throws DaoException {
		List<Client> l = serviceC.listerTousClients();
		Client cl = l.get(value - 1);
		System.out.println("client à modifier id = " + value + "  " + cl);
		return new ModelAndView("/conseiller/editLoginClient", "client", cl);
	}

	@RequestMapping(value = "/editedLogin", method = RequestMethod.POST) // retour page index
	// public ModelAndView editedLogin(@RequestParam(value="logedit",
	// defaultValue="1") String logStr) {
	public ModelAndView editedLogin(@RequestParam Map<String, String> requestParams) throws Exception {
		Integer id = Integer.parseInt(requestParams.get("idmod"));
		String logStr = requestParams.get("logedit");
		String nomStr = requestParams.get("nomedit");
		String prenomtr = requestParams.get("prenomedit");
		String mdpStr = requestParams.get("mdpedit");
		String rueStr = requestParams.get("rueedit");
		System.out.println("adresse modifiée : " + rueStr);

		System.out.println("login : " + logStr + " id : " + id);
		BeanClient bean = new BeanClient(id, logStr);
		List<Client> l = serviceC.listerTousClients();
		// Client cl=l.get(id-1);cl.setLogin(logStr);
		// serviceC.updateClient(cl);
		System.out.println("client login modifie = " + logStr + "  ");
		return new ModelAndView("/conseiller/editedLogin", "beanid", bean);
	}

}
