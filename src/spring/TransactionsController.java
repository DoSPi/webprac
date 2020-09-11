  package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.TransactionDao;

import org.springframework.ui.ModelMap;

@Controller
public class TransactionsController{
	@Autowired
	TransactionDao dao;
   @RequestMapping(value = "transactions", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("transactionsList", dao.getAll());
      return "transactions";
   }
} 

