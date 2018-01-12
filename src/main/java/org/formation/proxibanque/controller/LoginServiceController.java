package org.formation.proxibanque.controller;

import org.formation.proxibanque.service.ILoginService;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginServiceController {
	
	@Autowired
	private ILoginService loginService;

}
