package com.activillage.user.join.service;

import com.activillage.user.join.vo.UserJoinVO;

public interface UserJoinService {
	public int idConfirm(String u_email);
	public void userInsert(UserJoinVO uvo);
}
