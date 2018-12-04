package com.activillage.seller.login.dao;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

public interface LoginDAO {

	public SellerJoinVO sellerlogin(SellerJoinVO svo);
	public UserJoinVO userlogin(UserJoinVO uvo);
	
}
