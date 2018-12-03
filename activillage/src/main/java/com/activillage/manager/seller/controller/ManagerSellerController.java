package com.activillage.manager.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value="/manager")
public class ManagerSellerController {
	@RequestMapping(value="/main/sellerManage", method=RequestMethod.GET)
	public String sellerManage() {
		log.info("manager sellerManage 호출 성공");
		
		return "manager/main/sellerManage";
	}
	
	@RequestMapping(value="/main/salesManage", method=RequestMethod.GET)
	public String salesManage() {
		log.info("manager salesManage 호출 성공");
		
		return "manager/main/salesManage";
	}
}
