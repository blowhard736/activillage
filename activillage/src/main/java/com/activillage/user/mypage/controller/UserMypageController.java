package com.activillage.user.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.activillage.user.join.service.UserJoinService;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value = "/mypage")
public class UserMypageController {

	@Autowired
	private UserJoinService userjoinService;

	// 마이페이지 이동
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage() {

		log.info("myPage 호출성공");
		return "mypage/myPage";
	}

	// 마이페이지 -> 사용자 정보변경페이지 불러오기
	@RequestMapping(value = "user/modifyInfo", method = RequestMethod.GET)
	public ModelAndView userModifyInfo(HttpSession session) {

		log.info("modifyInfo 페이지 호출 성공");

		// 모델뷰 인스턴스 선언
		ModelAndView mav = new ModelAndView();

		// 로그인에서 설정한 세션값 가져오기
		UserJoinVO login = (UserJoinVO) session.getAttribute("loginSession");

		// 변수명 login에 있는 u_email 세션을 가져와 셀렉트하고 다시 vo 객체 인스턴스에 값 저장
		UserJoinVO vo = userjoinService.userSelect(login.getU_email());
		System.out.println("login.getU_email :" + login.getU_email());
		mav.addObject("user", vo); // "user" 에 vo 저장하고 보냄
		mav.setViewName("mypage/user/modifyInfo"); // 페이지 경로설정
		return mav;
	}

	// 마이페이지 -> 사용자 정보변경페이지 불러오기
	@RequestMapping(value = "user/modifyInfo", method = RequestMethod.POST)
	public ModelAndView userModifyProcess(@ModelAttribute("UserJoinVO") UserJoinVO uvo, HttpSession session) {

		log.info("post 방식에 의한 modifyInfo 페이지 호출 성공");

		// 모델뷰 인스턴스 선언
		ModelAndView mav = new ModelAndView();

		// 로그인에서 설정한 세션값 가져오기
		UserJoinVO login = (UserJoinVO) session.getAttribute("loginSession");

		// 메소드에 들어갈 파라미터 uvo에 세션에서 설정한 u_email을 set함
		uvo.setU_email(login.getU_email());

		// uvo에 있는 u_email을 가져와 셀렉트하고 객체 인스턴스명 vo에 값을 저장
		UserJoinVO vo = userjoinService.userSelect(uvo.getU_email());

		if (userjoinService.userUpdate(uvo)) {
			mav.setViewName("redirect:/mypage/myPage.do");
			return mav;
		}
		mav.addObject("user", vo); // "user"에 vo 저장하고 보냄
		mav.setViewName("mypage/user/modifyInfo"); // 페이지 경로 설정

		return mav;
	}

	// 마이페이지 -> 사용자 예약확인페이지 불러오기
	@RequestMapping(value = "user/reservation", method = RequestMethod.GET)
	public String reservation() {

		log.info("reservation 페이지 호출 성공");
		return "mypage/user/reservation";
	}

	// 마이페이지 -> 사업자 정보변경페이지 불러오기

	@RequestMapping(value = "seller/modifyInfo", method = RequestMethod.GET)
	public String sellerModifyInfo() {

		log.info("사업자 정보변경페이지 호출 성공");
		return "mypage/seller/modifyInfo";

	}

	// 마이페이지 -> 사업자 비밀번호변경페이지 불러오기
	@RequestMapping(value = "seller/modifyPw", method = RequestMethod.GET)
	public String sellerModifyPw() {

		log.info("사업자 비밀번호변경페이지 호출 성공");
		return "mypage/seller/modifyPw";
	}

	// 마이페이지 -> 사업자 상품등록페이지 불러오기
	@RequestMapping(value = "seller/goodsRegister", method = RequestMethod.GET)
	public String sellerRegisterGoods() {

		log.info("사업자 상품등록페이지 호출 성공");
		return "mypage/seller/goodsRegister";
	}

	// 마이페이지 -> 사업자 상품관리페이지 불러오기
	@RequestMapping(value = "seller/manageGoods", method = RequestMethod.GET)
	public String sellergoodsManage() {

		log.info("사업자 상품관리페이지 호출 성공");
		return "mypage/seller/manageGoods";
	}

	// 마이페이지 -> 사업자 예약관리페이지 불러오기
	@RequestMapping(value = "seller/reservationManage", method = RequestMethod.GET)
	public String sellerReservationManage() {

		log.info("예약관리페이지 호출 성공");
		return "mypage/seller/reservationManage";
	}

	// 마이페이지 -> 사업자 매출현황페이지 불러오기
	@RequestMapping(value = "seller/salesPresent", method = RequestMethod.GET)
	public String sellerSalesPresent() {

		log.info("사업자 매출현황 페이지 호출 성공");
		return "mypage/seller/salesPresent";
	}

}
