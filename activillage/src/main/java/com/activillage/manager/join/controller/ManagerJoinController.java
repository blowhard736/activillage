package com.activillage.manager.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activillage.manager.service.ManagerJoinService;
import com.activillage.manager.vo.ManagerJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/mainjoin")
public class ManagerJoinController {
	
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ManagerJoinService managerJoinService;
	
	// 관리자 등록 페이지로 이동
	@RequestMapping(value="/managerJoin", method = RequestMethod.GET)
	public String managerJoin() {		
		log.info("managerJoin get 호출 성공");
		return "manager/main/managerJoin";
	}
	
	// 사용자 아이디 중복 체크 메서드
	@ResponseBody
	@RequestMapping(value="/idConfirm", method=RequestMethod.POST)
	public String idConfirm(@RequestParam("m_id") String m_id){
		log.info("idConfirm post 호출 성공");
		int result = managerJoinService.idConfirm(m_id);
		return result+"";
	}
	
	// 회원 가입 처리
	@RequestMapping(value="/mainjoin", method = RequestMethod.POST)
	public String managerInsert(@ModelAttribute ManagerJoinVO mvo, BindingResult bindResult, Model model) throws Exception {
		/*@ModelAttribute ManagerJoinVO mvo*/
		log.info("mainjoin post 방식에 의한 메서드 호출 성공");
		//비밀번호 암오화 작업
        if(StringUtils.hasText(mvo.getM_pw())) {
            String bCryptString = bCryptPasswordEncoder.encode(mvo.getM_pw());
            mvo.setM_pw(bCryptString);
        }
		managerJoinService.managerInsert(mvo);
		return "manager/main/userManage";
	}
}
