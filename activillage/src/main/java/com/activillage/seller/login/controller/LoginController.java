package com.activillage.seller.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.activillage.common.util.crypt.SHA256;
import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.seller.login.service.LoginService;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginService loginService;
	
	// 로그인 페이지 이동 메소드
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {		
		log.info("login get 호출 성공");
		return "login/login";
	}
	
	// 사업자 로그인
	@RequestMapping(value="/sellerLogin", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("SellerJoinVO") SellerJoinVO svo, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		SellerJoinVO sVo = loginService.sellerlogin(svo);
		
		String orgPass = svo.getS_pw();
		
		if (sVo != null) {
			if (BCrypt.checkpw(orgPass, sVo.getS_pw())) {
				mav.addObject("code", 1);
				mav.addObject("approval", sVo.getS_approval());
				session.setAttribute("loginId", sVo.getS_email());
				session.setAttribute("loginType", "seller");
			} else {
				mav.addObject("code", 0);
			}
		} else {
			mav.addObject("code", 0);
		}
		
		mav.setViewName("main/main");
		return mav;
		
	}
	
	// 사용자 로그인
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("UserJoinVO") UserJoinVO uvo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
			
		UserJoinVO uVo = loginService.userlogin(uvo);
			
		try {
			String orgPass = uvo.getU_pw();
			if (BCrypt.checkpw(orgPass, uVo.getU_pw())) {
				mav.addObject("id", uVo.getU_email());
				mav.addObject("code", 1);
				mav.addObject("approval", "Y");
				session.setAttribute("loginType", "user");
			} else {
				mav.addObject("code", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		mav.setViewName("main/main");
		
		return mav;
			
	}
	
	// 아이디 찾기 페이지 이동 메소드
	@RequestMapping(value="/idSearch", method = RequestMethod.GET)
	public String idSearch() {		
		log.info("idSearch get 호출 성공");
		return "login/idSearch";
	}
	
	// 비밀번호 찾기 페이지 이동 메소드
	@RequestMapping(value="/pwSearch", method = RequestMethod.GET)
	public String pwSearch() {		
		log.info("pwSearch get 호출 성공");
		return "login/pwSearch";
	}
	
}
