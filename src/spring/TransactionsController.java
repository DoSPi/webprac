  package spring;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.AccountDao;
import dao.TransactionDao;
import dao.TypeDao;
import entity.Account;
import entity.Transaction;
import entity.Type;

import org.springframework.ui.ModelMap;

@Controller
public class TransactionsController{
	@Autowired
	TransactionDao dao;
	@Autowired
	AccountDao adao;
	@Autowired
	TypeDao tdao;
   @RequestMapping(value = "transactions", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("transactionsList", dao.getAll());
      return "transactions";
   }
   @RequestMapping(value = "add_transaction", method = RequestMethod.GET)
   public String Addtransaction(ModelMap model) {
	   model.addAttribute("transaction", new Transaction());
	   return "add_transaction";
   }
   @Transactional
   @RequestMapping(value = "add_transaction", method = RequestMethod.POST)
   public String Savetransaction(ModelMap model,@ModelAttribute("transaction") Transaction transaction) {
	   if (transaction.getAccount() == null) {
		   return "error";
	   }
	   Account account = adao.get(transaction.getAccount().getAccount_id());
	   if (account == null) {
		   return "error";
	   }
	   Type type = tdao.get(account.getType().getType_id());
	   if (type == null) {
		   return "error";
	   }
       double value = transaction.getValue();
       double max = account.getType().getAdd_max();
       System.out.print(max);
       double min = account.getType().getSub_max();
       double balance = account.getBalance();
       double loan = account.getType().getLoan_max();
       if (value > max || value < -min||  balance + value < -loan ) {
           return "error";
       }
       Instant instant = Instant.now();
       Timestamp timestamp = Timestamp.from(instant);
       transaction.setDate(timestamp);
       dao.save(transaction);
       account.setBalance(account.getBalance() + value);
       return "redirect:transactions";
   }
} 

