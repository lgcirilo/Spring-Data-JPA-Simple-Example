package dev.lgcirilo.SpringDataJPASimpleExample.controllers;

import dev.lgcirilo.SpringDataJPASimpleExample.data.EmployeeRepository;
import dev.lgcirilo.SpringDataJPASimpleExample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


// TODO - refactor to make it a restful application
@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeData;

    @RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
    public String newEmployee(Employee employee) {
        logger.warn("Entered method newEmployee of {}", this.getClass());

        employeeData.save(employee);
        return ("redirect:/listEmployees.html");

    }

    @RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
    public ModelAndView addNewEmployee() {
        logger.warn("Entered method addNewEmployee of {}", this.getClass());
        Employee emp = new Employee();
        return new ModelAndView("newEmployee", "form", emp);

    }

    @RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
    public ModelAndView employees() {
        List<Employee> allEmployees = employeeData.findAll();
        return new ModelAndView("allEmployees", "employees", allEmployees);

    }
}
