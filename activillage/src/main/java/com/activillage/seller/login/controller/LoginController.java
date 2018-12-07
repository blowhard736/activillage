package com.activillage.seller.login.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.seller.login.service.LoginService;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// 로그인 페이지 이동 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		log.info("login get 호출 성공");
		return "login/login";
	}

	// 사용자 로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	// 사업자 로그인
	@RequestMapping(value = "/sellerLogin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("SellerJoinVO") SellerJoinVO svo, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		SellerJoinVO sVo = loginService.sellerlogin(svo);

		String orgPass = svo.getS_pw();

		if (sVo != null) {
			if (BCrypt.checkpw(orgPass, sVo.getS_pw())) {
				if (sVo.getS_approval().equals("Y")) {
					mav.addObject("code", 1);
					session.setAttribute("loginId", sVo.getS_email());
					session.setAttribute("loginType", "seller");
					mav.setViewName("index");
				} else {
					mav.addObject("code", 2);
					mav.setViewName("login/login");
				}
			} else {
				mav.addObject("code", 3);
				mav.setViewName("login/login");
			}
		} else {
			mav.addObject("code", 3);
			mav.setViewName("login/login");
		}
		return mav;

	}

	// 사용자 로그인
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("UserJoinVO") UserJoinVO uvo, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		UserJoinVO uVo = loginService.userlogin(uvo);

		try {
			String orgPass = uvo.getU_pw();
			if (BCrypt.checkpw(orgPass, uVo.getU_pw())) {
				mav.addObject("login", uVo);
				mav.addObject("id", uVo.getU_email());
				mav.addObject("code", 1);
				session.setAttribute("loginSession", uVo);
				session.setAttribute("loginType", "user");
				log.info("로그인 성공");
				mav.setViewName("index");
			} else {
				mav.addObject("code", 3);
				mav.setViewName("login/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("code", 3);
			mav.setViewName("login/login");
		}

		return mav;

	}

	// 회원가입 페이지로 이동 메소드
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		log.info("join get 호출 성공");
		return "index"; // "join/join";
	}

	// 아이디 찾기 선택 페이지 이동 메소드
	@RequestMapping(value = "/idfind", method = RequestMethod.GET)
	public String idfind() {
		log.info("idfind get 호출 성공");
		return "login/idfind";
	}

	// 비밀번호 찾기 선택 페이지 이동 메소드
	@RequestMapping(value = "/pwfind", method = RequestMethod.GET)
	public String pwfind() {
		log.info("pwfind get 호출 성공");
		return "login/pwfind";
	}

	// 사업자 아이디 찾기 닫기 메소드
	@RequestMapping(value = "/sellerBack", method = RequestMethod.GET)
	public String sellerBack() {
		log.info("sellerBack get 호출 성공");
		return "login/login";
	}

	// 사용자 아이디 찾기 닫기 메소드
	@RequestMapping(value = "/userBack", method = RequestMethod.GET)
	public String userBack() {
		log.info("userBack get 호출 성공");
		return "login/login";
	}

	// 사업자 아이디 찾기 페이지 메소드
	@RequestMapping(value = "/selleridfind", method = RequestMethod.GET)
	public String selleridfind() {
		log.info("selleridfind get 호출 성공");
		return "login/selleridSearch";
	}

	// 사용자 아이디 찾기 페이지 메소드
	@RequestMapping(value = "/useridfind", method = RequestMethod.GET)
	public String useridfind() {
		log.info("useridfind get 호출 성공");
		return "login/useridSearch";
	}

	// 사업자 비밀번호 찾기 페이지 메소드
	@RequestMapping(value = "/sellerpwfind", method = RequestMethod.GET)
	public String sellerpwfind() {
		log.info("sellerpwfind get 호출 성공");
		return "login/sellerpwSearch";
	}

	// 사용자 비밀번호 찾기 페이지 메소드
	@RequestMapping(value = "/userpwfind", method = RequestMethod.GET)
	public String userpwfind() {
		log.info("userpwfind get 호출 성공");
		return "login/userpwSearch";
	}

	// 사업자 비밀번호 찾기 페이지 이동 메소드
	@RequestMapping(value = "/sellermove", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ModelAndView sellermove(@ModelAttribute SellerJoinVO svo, Model model, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();

		int result = 0;

		result = loginService.sellerPwCheck(svo);

		if (result == 1) {
			mav.addObject("email", svo.getS_email());
			mav.setViewName("login/sellerpwfind");
		} else {
			mav.setViewName("login/sellerpwSearch");
		}
		return mav;
	}

	// 사업자 비밀번호 찾기 페이지 이동 메소드
	@RequestMapping(value = "/sellerchange", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ModelAndView sellerchange(@ModelAttribute SellerJoinVO svo, Model model, HttpServletResponse response)
			throws Exception {
		log.info("sellerchange 호출 성공");
		ModelAndView mav = new ModelAndView();
		int result = 0;

		if (StringUtils.hasText(svo.getS_pw())) {
			String bCryptString = bCryptPasswordEncoder.encode(svo.getS_pw());
			svo.setS_pw(bCryptString);
		}

		result = loginService.sellerPwupdate(svo);

		if (result == 1) {
			mav.setViewName("login/login");
		} else {
			mav.setViewName("login/sellerpwfind");
		}
		return mav;
	}

	// 사용자 비밀번호 찾기 페이지 이동 메소드
	@RequestMapping(value = "/usermove", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ModelAndView usermove(@ModelAttribute UserJoinVO uvo, Model model, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();

		int result = 0;

		result = loginService.userPwCheck(uvo);

		if (result == 1) {
			mav.addObject("email", uvo.getU_email());
			mav.setViewName("login/userpwfind");
		} else {
			mav.setViewName("login/userpwSearch");
		}
		return mav;
	}

	// 사용자 비밀번호 찾기 페이지 이동 메소드
	@RequestMapping(value = "/userchange", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ModelAndView userchange(@ModelAttribute UserJoinVO uvo, Model model, HttpServletResponse response)
			throws Exception {
		log.info("userchange 호출 성공");
		ModelAndView mav = new ModelAndView();
		int result = 0;

		if (StringUtils.hasText(uvo.getU_pw())) {
			String bCryptString = bCryptPasswordEncoder.encode(uvo.getU_pw());
			uvo.setU_pw(bCryptString);
		}

		result = loginService.userPwupdate(uvo);

		if (result == 1) {
			mav.setViewName("login/login");
		} else {
			mav.setViewName("login/userpwfind");
		}
		return mav;
	}

	// 사업자 아이디를 화면 보여주기 위한 메서드
	@RequestMapping(value = "/selleridsearch", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String idList(@ModelAttribute SellerJoinVO svo, Model model, HttpServletResponse response)
			throws Exception {

		ArrayList<String> idList = loginService.sellerfindId(svo);
		String s_email = "{\"s_email\":\"" + idList + "\"}";
		return s_email;
	}

	// 사용자 아이디를 화면 보여주기 위한 메서드
	@RequestMapping(value = "/useridsearch", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String idList(@ModelAttribute UserJoinVO uvo, Model model, HttpServletResponse response)
			throws Exception {

		ArrayList<String> idList = loginService.userfindId(uvo);
		String u_email = "{\"u_email\":\"" + idList + "\"}";
		return u_email;
	}

}