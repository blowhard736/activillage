package com.activillage.seller.join.dao;

import com.activillage.seller.join.vo.SellerJoinVO;

public interface SellerJoinDAO {
	public SellerJoinVO sellerSelect(String s_email);
	public void sellerInsert(SellerJoinVO svo);
}
