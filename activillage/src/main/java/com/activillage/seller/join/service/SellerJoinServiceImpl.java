package com.activillage.seller.join.service;

import org.apache.commons.jexl2.UnifiedJEXL.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.seller.join.dao.SellerJoinDAO;
import com.activillage.seller.join.vo.SellerJoinVO;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class SellerJoinServiceImpl implements SellerJoinService {

	@Autowired
	private SellerJoinDAO sellerJoinDAO;
	
	// 아이디 중복체크
	@Override
	public int idConfirm(String s_email) {
		int result;
		if (sellerJoinDAO.sellerSelect(s_email) != null ) {
			result = 1; 
		} else{
			result = 2; 
		}
		return result;
	}

	// 사업자 등록
	@Override
	public void sellerInsert(SellerJoinVO svo) throws Exception {
		sellerJoinDAO.sellerInsert(svo);
	}

}
