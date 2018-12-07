package com.activillage.manager.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.activillage.manager.vo.ManagerJoinVO;

@Repository
public class ManagerJoinDAOImpl implements ManagerJoinDAO {

	@Autowired
	private SqlSession session;
	
	// 아이디 중복체크
	@Override
	public ManagerJoinVO manageSelect(String m_id) {
		return (ManagerJoinVO)session.selectOne("manageSelect", m_id);
	}

	@Override
	public void managerInsert(ManagerJoinVO mvo) {
		session.insert("managerInsert", mvo);
	}

}
