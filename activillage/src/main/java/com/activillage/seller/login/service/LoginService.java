package com.activillage.seller.login.service;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

public interface LoginService {

	public SellerJoinVO sellerlogin(SellerJoinVO svo);
	public UserJoinVO userlogin(UserJoinVO uvo);
	
}
