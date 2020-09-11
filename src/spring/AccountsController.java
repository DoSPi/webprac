package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.AccountDao;

import org.springframework.ui.ModelMap;

@Controller
public class AccountsController{
	@Autowired
	AccountDao adao;
   @RequestMapping(value = "accounts", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("accountsList", adao.getAll());
      return "accounts";
   }
} 