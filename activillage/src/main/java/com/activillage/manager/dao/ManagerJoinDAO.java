package com.activillage.manager.dao;
import com.activillage.manager.vo.ManagerJoinVO;

public interface ManagerJoinDAO {
	public ManagerJoinVO manageSelect(String m_id);
	public void managerInsert(ManagerJoinVO mvo);
}
