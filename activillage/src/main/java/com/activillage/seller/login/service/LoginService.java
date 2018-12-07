package com.activillage.seller.login.service;

import java.util.ArrayList;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

public interface LoginService {
	public SellerJoinVO sellerlogin(SellerJoinVO svo);
	public UserJoinVO userlogin(UserJoinVO uvo);
	public ArrayList<String> sellerfindId(SellerJoinVO svo);
	public ArrayList<String> userfindId(UserJoinVO uvo);
	public int sellerPwCheck(SellerJoinVO svo);
	public int sellerPwupdate(SellerJoinVO svo);
	public int userPwCheck(UserJoinVO uvo);
	public int userPwupdate(UserJoinVO uvo);
}
