package com.activillage.seller.join.controller;

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

import com.activillage.seller.join.service.SellerJoinService;
import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.service.UserJoinService;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/join")
public class JoinController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private SellerJoinService sellerJoinService;
	
	@Autowired
	private UserJoinService userJoinService;
	
	// 사업자 등록 페이지 이동 메소드
		@RequestMapping(value="/join", method = RequestMethod.GET)
		public String joinType() {		
			log.info("joinTpye get 호출 성공");
			return "join/join";
		}
	
	// 사업자 등록 페이지 이동 메소드
	@RequestMapping(value="/sellerJoin", method = RequestMethod.GET)
	public String sellerJoin() {		
		log.info("sellerJoin get 호출 성공");
		return "join/sellerJoin";
	}
	
	// 사용자 등록 페이지 이동 메소드
	@RequestMapping(value="/userJoin", method = RequestMethod.GET)
	public String userJoin() {		
		log.info("userJoin get 호출 성공");
		return "join/userJoin";
	}
	
	// 사업자 아이디 중복 체크 메서드
	@ResponseBody
	@RequestMapping(value="/selleridConfirm", method=RequestMethod.POST)
	public String selleridConfirm(@RequestParam("s_email") String s_email){
		log.info("selleridConfirm post 호출 성공");
		int result = sellerJoinService.idConfirm(s_email);
		return result+"";
	}
	
	// 사용자 아이디 중복 체크 메서드
	@ResponseBody
	@RequestMapping(value="/useridConfirm", method=RequestMethod.POST)
	public String useridConfirm(@RequestParam("u_email") String u_email){
		log.info("useridConfirm post 호출 성공");
		int result = userJoinService.idConfirm(u_email);
		return result+"";
	}
	
	// 사업자 등록 처리
	@RequestMapping(value="/sellerjoin", method = RequestMethod.POST)
	public String sellerInsert(@ModelAttribute SellerJoinVO svo, BindingResult bindResult, Model model) throws Exception {
		log.info("sellerInsert post 방식에 의한 메서드 호출 성공");
		// 비밀번호 암오화 작업
	    if(StringUtils.hasText(svo.getS_pw())) {
	    	String bCryptString = bCryptPasswordEncoder.encode(svo.getS_pw());
	        svo.setS_pw(bCryptString);
	    }
	    sellerJoinService.sellerInsert(svo);
		return "index";
	}

	// 사용자 등록 처리
	@RequestMapping(value="/userjoin", method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserJoinVO uvo, BindingResult bindResult, Model model) throws Exception {
		log.info("userInsert post 방식에 의한 메서드 호출 성공");
		// 비밀번호 암오화 작업
		if(StringUtils.hasText(uvo.getU_pw())) {
		    String bCryptString = bCryptPasswordEncoder.encode(uvo.getU_pw());
		    uvo.setU_pw(bCryptString);
		}
		userJoinService.userInsert(uvo);
		return "index";
	}
	
}