 package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DepartmentDao;
import entity.Client;
import entity.Department;

import org.springframework.ui.ModelMap;

@Controller
public class DepartmentsController{
	@Autowired
	DepartmentDao dao;
   @RequestMapping(value = "departments", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("departmentsList", dao.getAll());
      return "departments";
   }
   @RequestMapping(value = "add_department", method = RequestMethod.GET)
   public String Adddepartment(ModelMap model, @RequestParam(value="id", required= false) Long id) {
	   if (id == null) {
		   model.addAttribute("department", new Department());
		   } else {
			   Department c = dao.get(id);
			   if (c == null) {
				   return "error";
			   }
			   model.addAttribute("department", c);
		   }
	   return "add_department";
   }
   @RequestMapping(value = "add_department", method = RequestMethod.POST)
   public String Savedepartment(ModelMap model,@ModelAttribute("department") Department department) {
	   dao.save(department);
	   return "redirect:departments";
   }
   @RequestMapping(value = "delete_department", method = RequestMethod.GET)
   public String DeleteDepartment(ModelMap model,@RequestParam(value="id", required = true) Long id) {
	   Department c = dao.get(id);
	   if (c == null) {
		   return "error";
	   }
	   dao.delete(c);
	   return "redirect:departments";
   }
} 