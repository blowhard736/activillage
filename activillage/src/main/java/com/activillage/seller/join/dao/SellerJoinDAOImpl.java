package com.activillage.seller.join.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.seller.join.vo.SellerJoinVO;

@Repository
public class SellerJoinDAOImpl implements SellerJoinDAO{
	
	@Autowired
	private SqlSession session;

	// 아이디 중복체크
	@Override
	public SellerJoinVO sellerSelect(String s_email) {
		return (SellerJoinVO)session.selectOne("sellerSelect", s_email);
	}

	// 사업자 등록
	@Override
	public void sellerInsert(SellerJoinVO svo) {
		session.insert("sellerInsert", svo);
	}

}
