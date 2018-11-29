package com.activillage.manager.service;

import org.apache.commons.jexl2.UnifiedJEXL.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.activillage.manager.dao.ManagerJoinDAO;
import com.activillage.manager.vo.ManagerJoinVO;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class ManagerJoinServiceImpl implements ManagerJoinService {

	@Autowired
	private ManagerJoinDAO managerJoinDAO;
	
	// 아이디 중복체크
	@Override
	public int idConfirm(String m_id) {
		int result;
		if (managerJoinDAO.manageSelect(m_id) != null ) {
			result = 1; 
		} else{
			result = 2; 
		}
		return result;
	}

	// 관리자 등록
	@Override
	public void managerInsert(ManagerJoinVO mvo) throws Exception {
		managerJoinDAO.managerInsert(mvo);
	}
	
}