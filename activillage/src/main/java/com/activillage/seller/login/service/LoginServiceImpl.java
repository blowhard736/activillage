package com.activillage.seller.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.seller.login.dao.LoginDAO;
import com.activillage.user.join.vo.UserJoinVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	@Qualifier("loginDAO")
	private LoginDAO loginDAO;

	// 사업자 로그인
	@Override
	public SellerJoinVO sellerlogin(SellerJoinVO svo) {
		return loginDAO.sellerlogin(svo);
	}

	// 사용자 로그인
	@Override
	public UserJoinVO userlogin(UserJoinVO uvo) {
		return loginDAO.userlogin(uvo);
	}
	
}
