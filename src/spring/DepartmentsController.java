 package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DepartmentDao;

import org.springframework.ui.ModelMap;

@Controller
public class DepartmentsController{
	@Autowired
	DepartmentDao dao;
   @RequestMapping(value = "departments", method = RequestMethod.GET)public String Root(ModelMap model) {
	   model.addAttribute("departmentsList", dao.getAll());
      return "departments";
   }
} 