package com.bolsadeideas.springboot.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	
	@GetMapping({"/",""})
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "") String texto, Model model) {
		//public String param(@RequestParam(name="texto") String datoTexto, Model model) {		
		model.addAttribute("resultado", "El dato enviado es: ".concat(texto));
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		//public String param(@RequestParam(name="texto") String datoTexto, Model model) {		
		model.addAttribute("resultado", "El saludo es: ".concat(saludo).concat(" y el número es: ").concat( String.valueOf(numero)));
		return "params/ver";
	}
	
	@GetMapping("/mix-params/request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			numero = 0;
		}
		
		//public String param(@RequestParam(name="texto") String datoTexto, Model model) {		
		model.addAttribute("resultado", "El saludo es: ".concat(saludo).concat(" y el número es: ").concat( String.valueOf(numero)));
		return "params/ver";
	}	
	
	
	
}
