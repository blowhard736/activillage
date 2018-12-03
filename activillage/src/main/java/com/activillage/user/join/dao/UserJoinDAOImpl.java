package com.activillage.user.join.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.activillage.user.join.vo.UserJoinVO;

public class UserJoinDAOImpl implements UserJoinDAO {
	
	@Autowired
	private SqlSession session;

	// 아이디 중복체크
	@Override
	public UserJoinVO userSelect(String u_email) {
		return (UserJoinVO)session.selectOne("userSelect", u_email);
	}

	// 사용자 회원가입
	@Override
	public void userInsert(UserJoinVO uvo) {
		session.insert("userInsert", uvo);
	}

}
