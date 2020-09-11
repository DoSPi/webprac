 package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ClientDao;

import org.springframework.ui.ModelMap;

@Controller
public class ClientsController{
	@Autowired
	ClientDao dao;
   @RequestMapping(value = "clients", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("clientsList", dao.getAll());
      return "clients";
   }
} 
