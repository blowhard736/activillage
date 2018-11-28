package com.activillage.manager.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/manager")
public class ManagerUserController {
	
	@RequestMapping(value="/main/userManage", method=RequestMethod.GET)
	public String userManage() {
		log.info("manager userManage 호출 성공");
		
		return "manager/main/userManage";
	}
	
	
}
