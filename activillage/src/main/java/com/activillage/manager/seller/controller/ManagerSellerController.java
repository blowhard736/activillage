package com.activillage.manager.seller.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.activillage.common.graph.ChartMake;
import com.activillage.common.page.Paging;
import com.activillage.common.util.Util;
import com.activillage.manager.seller.service.ManagerSellerService;
import com.activillage.manager.vo.ManagerJoinVO;
import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value = "/manager")
public class ManagerSellerController {

	@Autowired
	private ManagerSellerService managerSellerService;

	@RequestMapping(value = "/main/sellerManage", method = RequestMethod.GET)
	public String sellerManage(@ModelAttribute SellerJoinVO svo, Model model,HttpSession session) {
		log.info("manager sellerManage 호출 성공");

		// 페이지 세팅
		Paging.setPage(svo);

		// 전체 레코드수 구현
		int total = managerSellerService.sellerListCnt(svo);
		log.info("total = " + total);

		// 글번호 재설정
		int count = total - (Util.nvl(svo.getPage()) - 1) * Util.nvl(svo.getPageSize());
		log.info("count = " + count);

		List<SellerJoinVO> sellerList = managerSellerService.sellerList(svo);

		model.addAttribute("sellerList", sellerList);
		model.addAttribute("count", count);
		model.addAttribute("total", total);
		model.addAttribute("s_data", svo);

		return "manager/main/sellerManage";
	}
	
	@RequestMapping(value="/approval", method=RequestMethod.POST)
	public ModelAndView sellerApproval(@ModelAttribute("SellerJoinVO") SellerJoinVO svo, HttpSession session) {
		log.info("manager manager/retire 호출 성공");
		int result=0;
		ModelAndView mav = new ModelAndView();
		result=managerSellerService.sellerApproval(svo);
		if(result==1) {
			mav.setViewName("redirect:/manager/main/sellerManage.do");
			return mav;
		}else {
			mav.setViewName("/manager/main/sellerManage.do");
			return mav;
		}
		 
	}

	@RequestMapping(value = "/main/salesManage", method = RequestMethod.GET)
	public String salesManage() {
		log.info("manager salesManage 호출 성공");

		return "manager/main/salesManage";
	}
	
	@RequestMapping(value="/sellerChart",method=RequestMethod.GET)
	public String sellerChart(@ModelAttribute SellerJoinVO svo, Model model, HttpServletRequest request) {
		//연령데이터
		Map<String, Integer> userAgeList = managerSellerService.sellerAreaList();
		ChartMake.sellerPieChart(request, userAgeList);
		
		return "manager/main/sellerChart";
	}
}
