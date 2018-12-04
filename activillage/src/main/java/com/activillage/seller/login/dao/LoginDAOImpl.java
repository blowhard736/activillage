package com.activillage.seller.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSession session;
	
	// 사업자 로그인
	@Override
	public SellerJoinVO sellerlogin(SellerJoinVO svo) {
		return (SellerJoinVO) session.selectOne("sellerlogin", svo);
	}

	// 사용자 로그인
	@Override
	public UserJoinVO userlogin(UserJoinVO uvo) {
		return (UserJoinVO) session.selectOne("userlogin", uvo);
	}

}
