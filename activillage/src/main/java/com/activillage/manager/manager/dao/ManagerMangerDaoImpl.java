package com.activillage.manager.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.manager.vo.ManagerJoinVO;

@Repository
public class ManagerMangerDaoImpl implements ManagerManagerDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<ManagerJoinVO> managerList(ManagerJoinVO mvo) {
		return session.selectList("managerList");
	}

	@Override
	public int managerRetire(ManagerJoinVO mvo) {
		return session.update("managerRetire", mvo);
	}

	@Override
	public int managerListCnt(ManagerJoinVO mvo) {
		return (Integer) session.selectOne("mangerListCnt", mvo);
	}

	@Override
	public ManagerJoinVO managerLogin(ManagerJoinVO mvo) {
		return (ManagerJoinVO) session.selectOne("managerLogin", mvo);
	}
}
