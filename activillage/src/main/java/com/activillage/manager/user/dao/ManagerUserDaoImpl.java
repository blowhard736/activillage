package com.activillage.manager.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.user.join.vo.UserJoinVO;

@Repository
public class ManagerUserDaoImpl implements ManagerUserDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<UserJoinVO> userList(UserJoinVO uvo) {
		return session.selectList("userList");
	}

	@Override
	public boolean userWithdrawal(UserJoinVO uvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int userListCnt(UserJoinVO uvo) {
		return (Integer) session.selectOne("userListCnt",uvo);
	}

}
