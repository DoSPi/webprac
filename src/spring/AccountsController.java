package spring;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AccountDao;
import entity.Account;

import org.springframework.ui.ModelMap;
import form.AccountForm;
@Controller
public class AccountsController{
	@Autowired
	AccountDao adao;
   @RequestMapping(value = "accounts", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("accountsList", adao.getAll());
      return "accounts";
   }
   @RequestMapping(value = "edit_account", method = RequestMethod.GET)
   public String EditAccount(ModelMap model, @RequestParam(value="id", required=true) Long id) {
	   Account p = adao.get(id);
	   if  (p != null) {
		   p.setClosed(!p.isClosed());
		   adao.update(p);
	   }
	   return "redirect:accounts";
   }
   @RequestMapping(value = "add_account", method = RequestMethod.GET)
   public String SaveAccount(ModelMap model) {
	   model.addAttribute("account", new Account());
	   return "add_account";
   }
   @RequestMapping(value = "add_account", method = RequestMethod.POST)
   public String SaveAccount(ModelMap model,@ModelAttribute("account") Account account) {
	   account.setBalance(0);
	   account.setClosed(false);
	   java.util.Date uDate = new java.util.Date();
	   java.sql.Date Date = new java.sql.Date(uDate.getTime());
	   account.setDate(Date);
	   adao.save(account);
	   return "redirect:accounts";
   }
} 