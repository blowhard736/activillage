package com.activillage.manager.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.manager.manager.dao.ManagerManagerDao;
import com.activillage.manager.vo.ManagerJoinVO;

@Service
@Transactional
public class ManagerManagerServiceImpl implements ManagerManagerService {

	@Autowired
	private ManagerManagerDao managerManagerDao;

	@Override
	public List<ManagerJoinVO> managerList(ManagerJoinVO mvo) {
		List<ManagerJoinVO> mList = null;
		mList = managerManagerDao.managerList(mvo);
		return mList;
	}

	public boolean managerRetire(ManagerJoinVO mvo) {
		try {
			managerManagerDao.managerRetire(mvo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int managerListCnt(ManagerJoinVO mvo) {
		return managerManagerDao.managerListCnt(mvo);
	}

}
