package com.net.webapp;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import com.net.models.service.ContactService;
import com.net.models.Contact;

@Controller
public class HomeController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome(ModelMap model){		
		model.addAttribute("message", "Mapped to Home controller");		
		return "index";
		
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String showContact(Map<String, Object> map){
		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		
		return "contact";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result){
		contactService.addContact(contact);		
		return "redirect:/action/new";
	}

}
