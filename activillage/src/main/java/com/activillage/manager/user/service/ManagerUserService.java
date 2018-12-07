package com.activillage.manager.user.service;

import java.util.List;
import java.util.Map;

import com.activillage.user.join.vo.UserJoinVO;

public interface ManagerUserService {
	public List<UserJoinVO> userList(UserJoinVO uvo);

	public boolean userWithdrawal(UserJoinVO uvo);

	public int userListCnt(UserJoinVO uvo);
	
	public Map<String, Integer> userAgeList();
}
