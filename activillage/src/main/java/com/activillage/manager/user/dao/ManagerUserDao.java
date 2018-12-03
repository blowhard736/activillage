package com.activillage.manager.user.dao;

import java.util.List;

import com.activillage.manager.vo.ManagerJoinVO;
import com.activillage.user.join.vo.UserJoinVO;

public interface ManagerUserDao {
	public List<UserJoinVO> userList(UserJoinVO uvo);

	public boolean userWithdrawal(UserJoinVO uvo);

	public int userListCnt(UserJoinVO uvo);
}
