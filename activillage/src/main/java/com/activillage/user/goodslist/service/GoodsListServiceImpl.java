package com.activillage.user.goodslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.user.goodslist.dao.GoodsListDAO;
import com.activillage.user.goodslist.vo.GoodsListVO;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class GoodsListServiceImpl implements GoodsListService {

	@Autowired
	private GoodsListDAO goodsListDAO;

	@Override
	public List<GoodsListVO> goodsList(GoodsListVO gvo) {
		List<GoodsListVO> myList = null;
		myList = goodsListDAO.goodsList(gvo);
		log.info(gvo.getG_name());
		return myList;
	}

}
