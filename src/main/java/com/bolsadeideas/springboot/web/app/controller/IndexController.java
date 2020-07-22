package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	//@RequestMapping(value="/index",method = RequestMethod.GET)
	@GetMapping({"/index","/","/home"})
	public String index(){
		return "index";
	}
}
