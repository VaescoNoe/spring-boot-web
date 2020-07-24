package com.bolsadeideas.springboot.web.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
@PropertySources({
	@PropertySource("classpath:indexControllerConfig.properties")
})
public class IndexController {

	@Value("${texto.indexController.title}")
	private String textoTitle;
	@Value("${texto.indexController.encabeado}")
	private String textoEncabezado;
	@Value("${texto.indexController.perfil}")
	private String textoPerfil;
	
	
	//@RequestMapping(value="/index",method = RequestMethod.GET)
	@GetMapping({"/index","/","/home",""})
	public String index(Model model){
		
		//public String index(ModelMap model){
		
		//public String index(Map<String, Object> model){
			//map.put("title","String con Map");
		
		//public ModelAndView index(ModelAndView mv){
			//mv.addObjec("title", "Spring con ModelAndView");
			//mv.setVienName("index");
		
		model.addAttribute("title", textoTitle);
		model.addAttribute("encabezado", textoEncabezado);
			
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
		model.addAttribute("perfil", textoPerfil.concat(u.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/perfiles")
	public String listar(Model model) {		
		return "perfiles";
	}
	
	
	// La lista de usuarios esta disponible para todos los metodos
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Noe","Vargas","vaesconoe@gmail.com"),
				new Usuario("Hugo","Vargas","vaescohugo@gmail.com"),
				new Usuario("Paulina","Pastrana","pastpau@gmail.com"));
		return usuarios;
	}
	
	
}
