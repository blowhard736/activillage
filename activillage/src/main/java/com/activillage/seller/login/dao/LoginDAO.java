package com.activillage.seller.login.dao;

import java.util.List;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

public interface LoginDAO {
	public SellerJoinVO sellerlogin(SellerJoinVO svo);
	public UserJoinVO userlogin(UserJoinVO uvo);
	public List<SellerJoinVO> sellerfindId(SellerJoinVO svo);
	public List<UserJoinVO> userfindId(UserJoinVO uvo);
	public SellerJoinVO sellerPwCheck(SellerJoinVO svo);
	public int sellerPwupdate(SellerJoinVO svo);
	public UserJoinVO userPwCheck(UserJoinVO uvo);
	public int userPwupdate(UserJoinVO uvo);
}
