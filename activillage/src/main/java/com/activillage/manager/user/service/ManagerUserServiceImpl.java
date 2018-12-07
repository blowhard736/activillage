package com.activillage.manager.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.manager.user.dao.ManagerUserDao;
import com.activillage.user.join.vo.UserJoinVO;

@Service
@Transactional
public class ManagerUserServiceImpl implements ManagerUserService {

	@Autowired
	private ManagerUserDao managerUserDao;

	@Override
	public List<UserJoinVO> userList(UserJoinVO uvo) {
		List<UserJoinVO> uList = null;
		uList = managerUserDao.userList(uvo);
		return uList;
	}

	@Override
	public boolean userWithdrawal(UserJoinVO uvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int userListCnt(UserJoinVO uvo) {
		return managerUserDao.userListCnt(uvo);
	}

	@Override
	public Map<String, Integer> userAgeList() {
		Map<String, Integer> ageList = null;
		ageList = managerUserDao.userAgeList();
		return ageList;
	}

}
