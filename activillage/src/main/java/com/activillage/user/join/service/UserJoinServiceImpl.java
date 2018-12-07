package com.activillage.user.join.service;

import org.apache.commons.jexl2.UnifiedJEXL.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.user.join.dao.UserJoinDAO;
import com.activillage.user.join.vo.UserJoinVO;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class UserJoinServiceImpl implements UserJoinService {

	@Autowired
	private UserJoinDAO userJoinDAO;

	// 아이디 중복체크
	@Override
	public int idConfirm(String u_email) {
		int result;
		if (userJoinDAO.userSelect(u_email) != null) {
			result = 1;
		} else {
			result = 2;
		}
		return result;
	}

	// 사용자 회원가입
	@Override
	public void userInsert(UserJoinVO uvo) throws Exception {
		userJoinDAO.userInsert(uvo);
	}

	// 사용자 셀렉트
	@Override
	public UserJoinVO userSelect(String u_email) {
		UserJoinVO vo = userJoinDAO.userSelect(u_email);
		return vo;
	}

	// 사용자 정보변경
	@Override
	public boolean userUpdate(UserJoinVO uvo) {

		userJoinDAO.userUpdate(uvo);

		return true;

	}

}
