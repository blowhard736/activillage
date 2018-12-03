package com.activillage.manager.user.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.activillage.common.page.Paging;
import com.activillage.common.util.Util;
import com.activillage.manager.manager.service.ManagerManagerService;
import com.activillage.manager.user.service.ManagerUserService;
import com.activillage.manager.vo.ManagerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/manager")
public class ManagerUserController {
	
	@Autowired
	private ManagerUserService managerUserService;
	
	@RequestMapping(value="/main/userManage", method=RequestMethod.GET)
	public String userManage(@ModelAttribute UserJoinVO uvo, Model model, HttpServletRequest request) {
		log.info("manager userManage 호출 성공");
		
		//페이지 세팅
				Paging.setPage(uvo);
				
				//전체레코드 수 구현
				int total = managerUserService.userListCnt(uvo);
				log.info("total="+total);
				
				//글번호 재설정
				int count = total - (Util.nvl(uvo.getPage())-1) * Util.nvl(uvo.getPageSize());
				log.info("count = "+count);

				List<UserJoinVO> userList = managerUserService.userList(uvo);
				
				model.addAttribute("userList",userList);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("u_data", uvo);
		
		return "manager/main/userManage";
	}
	
	
}
