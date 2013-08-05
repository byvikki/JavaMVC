package com.net.webapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {	
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome(ModelMap model){
		
		model.addAttribute("message", "Maven Web project with Spring MVC 3.0 - welcome");
		
		return "index";
		
	}

}
