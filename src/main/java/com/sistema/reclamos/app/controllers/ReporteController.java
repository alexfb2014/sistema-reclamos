package com.sistema.reclamos.app.controllers;


import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/reportes")
public class ReporteController {

	
	@GetMapping("/reporteSolicitud")
	public String nuevo(Map<String, Object> model, Authentication aut) {


		
		return "reportes/reporteSolicitud";
	}

	
	
}
