package com.activillage.manager.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.activillage.common.page.Paging;
import com.activillage.common.util.Util;
import com.activillage.manager.manager.service.ManagerManagerService;
import com.activillage.manager.vo.ManagerJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/manager")
public class ManagerManagerController {

	@Autowired
	private ManagerManagerService managerManagerService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String managerLogin(HttpSession session, HttpServletRequest request) {
		log.info("manager userManagePost 호출 성공");
		session.setAttribute("loginType", "manager");
		session.setAttribute("m_id", "yes");
		return "redirect:main/userManage.do";
	}
	
	@RequestMapping(value="/logout")
	public String managerLogout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		session = request.getSession(true);
		return "redirect:main/userManage.do";
	}
	
	@RequestMapping(value="/manage", method=RequestMethod.GET)
	public String managerManage(@ModelAttribute ManagerJoinVO mvo, Model model, HttpServletRequest request) {
		log.info("manager managerManage 호출 성공");
		
		//페이지 세팅
		Paging.setPage(mvo);
		
		//전체레코드 수 구현
		int total = managerManagerService.managerListCnt(mvo);
		log.info("total="+total);
		
		//글번호 재설정
		int count = total - (Util.nvl(mvo.getPage())-1) * Util.nvl(mvo.getPageSize());
		log.info("count = "+count);

		List<ManagerJoinVO> managerList = managerManagerService.managerList(mvo);
		
		model.addAttribute("managerList",managerList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("m_data", mvo);
		
		return "manager/main/managerManage";
	}
	
	@RequestMapping(value="/retire", method=RequestMethod.POST)
	public ModelAndView managerRetire(@ModelAttribute("ManagerJoinVO") ManagerJoinVO mvo, HttpSession session) {
		log.info("manager manager/retire 호출 성공");
		ModelAndView mav = new ModelAndView();
		if(managerManagerService.managerRetire(mvo)) {
			mav.setViewName("redirect:/manager/manage.do");
			return mav;
		}else {
			mav.setViewName("/manager/manage.do");
			return mav;
		}
		 
	}
}
