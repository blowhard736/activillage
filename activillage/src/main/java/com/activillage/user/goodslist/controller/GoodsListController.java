package com.activillage.user.goodslist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.activillage.user.goodslist.service.GoodsListService;
import com.activillage.user.goodslist.vo.GoodsListVO;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping(value = "/goods")
public class GoodsListController {

	@Autowired
	private GoodsListService goodsListService;

	/* 상품 리스트 구현하기 */

	@RequestMapping(value = "/goodsList", method = RequestMethod.GET)
	public String goodsList(@ModelAttribute GoodsListVO gvo, Model model) {
		log.info("상품 리스트 호출 성공");
		List<GoodsListVO> goodsList = goodsListService.goodsList(gvo);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("data",gvo);
		log.info("gvo: "+gvo);
		log.info("model: "+model);

	return"goods/goodsList";
}

}
