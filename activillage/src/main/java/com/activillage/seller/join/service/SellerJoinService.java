package com.activillage.seller.join.service;

import com.activillage.seller.join.vo.SellerJoinVO;

public interface SellerJoinService {
	public int idConfirm(String s_email);
	public void sellerInsert(SellerJoinVO svo);
}
