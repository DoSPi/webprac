 package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ClientDao;
import entity.Account;
import entity.Client;

import org.springframework.ui.ModelMap;

@Controller
public class ClientsController{
	@Autowired
	ClientDao dao;
   @RequestMapping(value = "clients", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("clientsList", dao.getAll());
      return "clients";
   }
   @RequestMapping(value = "add_client", method = RequestMethod.GET)
   public String AddClient(ModelMap model, @RequestParam(value="id") Long id) {
	   if (id == null) {
	   model.addAttribute("client", new Client());
	   } else {
		   Client c = dao.get(id);
		   if (c == null) {
			   return "Error";
		   }
		   model.addAttribute("client", c);
	   }
	   return "add_client";
   }
   @RequestMapping(value = "add_client", method = RequestMethod.POST)
   public String SaveClient(ModelMap model,@ModelAttribute("client") Client client) {
	   dao.save(client);
	   return "redirect:clients";
   }
} 
