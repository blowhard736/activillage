package com.activillage.manager.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/manager")
public class ManagerManagerController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String managerLogin(HttpSession session, HttpServletRequest request) {
		log.info("manager userManagePost 호출 성공");
		
		session.setAttribute("m_id", "yes");
		return "manager/main/userManage";
	}
	
	@RequestMapping(value="/logout")
	public String managerLogout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		session = request.getSession(true);
		return "redirect:main/userManage.do";
	}
}
