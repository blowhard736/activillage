package com.activillage.manager.service;

import com.activillage.manager.vo.ManagerJoinVO;

public interface ManagerJoinService {
	public int idConfirm(String m_id);
	public void managerInsert(ManagerJoinVO mvo);
}
