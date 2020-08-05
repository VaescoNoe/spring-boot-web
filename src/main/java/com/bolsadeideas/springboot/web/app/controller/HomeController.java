package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		//forward solo aplica para direcciones dentro del proyecto
		return "forward:/app/index";
	}
	
	@GetMapping("/google")
	public String google() {
		// recomendable para paginas externas
		return "redirect:https://google.com.mx";
	}
	
	
}
