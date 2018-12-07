package com.activillage.seller.login.dao;

import java.util.List;

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

	// 사업자 아이디 찾기
	@Override
	public List<SellerJoinVO> sellerfindId(SellerJoinVO svo) {
		return session.selectList("sellerfindId" , svo);
	}

	// 사용자 아이디 찾기
	@Override
	public List<UserJoinVO> userfindId(UserJoinVO uvo) {
		return session.selectList("userfindId" , uvo);
	}

	// 사업자 비밀번호 찾기
	@Override
	public SellerJoinVO sellerPwCheck(SellerJoinVO svo) {
		return (SellerJoinVO) session.selectOne("sellerPwCheck", svo);
	}

	// 사업자 비밀번호 찾기
	@Override
	public int sellerPwupdate(SellerJoinVO svo) {
		return session.update("sellerPwupdate", svo);
	}

	// 사용자 비밀번호 찾기
	@Override
	public UserJoinVO userPwCheck(UserJoinVO uvo) {
		return (UserJoinVO) session.selectOne("userPwCheck", uvo);
	}

	// 사용자 비밀번호 찾기
	@Override
	public int userPwupdate(UserJoinVO uvo) {
		return session.update("userPwupdate", uvo);
	}
	
}