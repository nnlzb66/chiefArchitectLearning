package com.zhss.oa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhss.oa.auth.model.Authorization;
import com.zhss.oa.auth.service.AuthorizationService;
import com.zhss.oa.flow.model.Application;
import com.zhss.oa.flow.service.ApplicationService;
import com.zhss.oa.organ.model.Employee;
import com.zhss.oa.organ.service.EmployeeService;

@Controller
public class WebController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping("/addEmployee")
	@ResponseBody
	public String addEmployee(Employee employee) {
		try {
			employeeService.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping("/authorize")
	@ResponseBody
	public String authorize(Authorization auth) {
		try {
			authorizationService.authorize(auth); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "ok";
	}
	
	@RequestMapping("/createApplication")
	@ResponseBody
	public String createApplication(Application app) {
		try {
			applicationService.create(app);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "ok";
	}
	
}
