 package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DepartmentDao;
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
   public String Adddepartment(ModelMap model) {
	   model.addAttribute("department", new Department());
	   return "add_department";
   }
   @RequestMapping(value = "add_department", method = RequestMethod.POST)
   public String Savedepartment(ModelMap model,@ModelAttribute("department") Department department) {
	   dao.save(department);
	   return "redirect:departments";
   }
} 