package com.activillage.manager.manager.dao;

import java.util.List;

import com.activillage.manager.vo.ManagerJoinVO;

public interface ManagerManagerDao {
	public List<ManagerJoinVO> managerList(ManagerJoinVO mvo);
	public int managerRetire(ManagerJoinVO mvo);
	public int managerListCnt(ManagerJoinVO mvo);
	public ManagerJoinVO managerLogin(ManagerJoinVO mvo);
}
