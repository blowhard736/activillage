package com.activillage.user.join.dao;

import com.activillage.user.join.vo.UserJoinVO;

public interface UserJoinDAO {
	public UserJoinVO userSelect(String u_email);

	public void userInsert(UserJoinVO uvo);

	public UserJoinVO userSeleect(String u_email);

	public int userUpdate(UserJoinVO uvo);
}
