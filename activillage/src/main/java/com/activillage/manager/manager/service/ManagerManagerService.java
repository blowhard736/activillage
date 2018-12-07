package com.activillage.manager.manager.service;

import java.util.List;

import com.activillage.manager.vo.ManagerJoinVO;

public interface ManagerManagerService {
	public List<ManagerJoinVO> managerList(ManagerJoinVO mvo);
	public boolean managerRetire(ManagerJoinVO mvo);
	public int managerListCnt(ManagerJoinVO mvo);
	public ManagerJoinVO managerLogin(ManagerJoinVO mvo);
}
