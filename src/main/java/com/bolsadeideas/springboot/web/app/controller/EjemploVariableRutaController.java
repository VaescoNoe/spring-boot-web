package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutaController {
	
	@GetMapping({"/",""})
	public String index(Model model) {
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variable(@PathVariable String texto, Model model) {
		//public String variable(@PathVariable(name ="texto") String textoOtro, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado de la ruta es: ".concat(texto));
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variable(@PathVariable String texto,@PathVariable Integer numero, Model model) {
		//public String variable(@PathVariable(name ="texto") String textoOtro, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado de la ruta es: ".concat(texto).concat(" y el numero enviado en el path es: ".concat(String.valueOf(numero))));
		return "variables/ver";
	}

}
