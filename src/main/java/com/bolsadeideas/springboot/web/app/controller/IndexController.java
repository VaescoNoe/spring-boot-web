package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	//@RequestMapping(value="/index",method = RequestMethod.GET)
	@GetMapping({"/index","/","/home"})
	public String index(Model model){
		
		//public String index(ModelMap model){
		
		//public String index(Map<String, Object> model){
			//map.put("title","String con Map");
		
		//public ModelAndView index(ModelAndView mv){
			//mv.addObjec("title", "Spring con ModelAndView");
			//mv.setVienName("index");
		
		model.addAttribute("title", "Spring");
		model.addAttribute("encabezado", "Hola Spring Framework!");
			
			//return mv;
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario u = new Usuario();
		u.setNombre("Noe");
		u.setApellido("Vargas");
		u.setEmail("vaesconoe@gmail.com");
		
		model.addAttribute("usuario", u);
		model.addAttribute("perfil", "Perfil de usuario: ".concat(u.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/perfiles")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("Noe","Vargas","vaesconoe@gmail.com"));
		usuarios.add(new Usuario("Hugo","Vargas","vaescohugo@gmail.com"));
		model.addAttribute("usuarios", usuarios);
		return "perfiles";
	}
}
