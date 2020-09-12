package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
public class RootController{
   @RequestMapping(value = "/", method = RequestMethod.GET)public String Root(ModelMap model) {
      return "root";
   }
   @RequestMapping(value = "error", method = RequestMethod.GET)public String Error(ModelMap model) {
	      return "error";
	   }
} 
