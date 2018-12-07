package com.activillage.seller.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.seller.join.vo.SellerJoinVO;
import com.activillage.seller.login.dao.LoginDAO;
import com.activillage.user.join.vo.UserJoinVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Qualifier("loginDAO")

	// 사업자 로그인
	@Override
	public SellerJoinVO sellerlogin(SellerJoinVO svo) {
		return loginDAO.sellerlogin(svo);
	}

	// 사용자 로그인
	@Override
	public UserJoinVO userlogin(UserJoinVO uvo) {
		return loginDAO.userlogin(uvo);
	}

	// 사업자 아이디 찾기
	@Override
	public ArrayList<String> sellerfindId(SellerJoinVO svo) {
		List<SellerJoinVO> list = loginDAO.sellerfindId(svo);
		ArrayList<String> sellerfindId = new ArrayList<String>();  
		for(int i =0; i <list.size(); i ++) {
			String s_email = list.get(i).getS_email();
			sellerfindId.add(s_email);
		}
		return sellerfindId;
	}

	// 사용자 아이디 찾기
	@Override
	public ArrayList<String> userfindId(UserJoinVO uvo) {
		List<UserJoinVO> list = loginDAO.userfindId(uvo);
		ArrayList<String> userfindId = new ArrayList<String>();  
		for(int i =0; i <list.size(); i ++) {
			String u_email = list.get(i).getU_email();
			userfindId.add(u_email);
		}
		return userfindId;
	}

	// 사업자 비밀번호 찾기
	@Override
	public int sellerPwCheck(SellerJoinVO svo) {
		SellerJoinVO sVo = loginDAO.sellerPwCheck(svo);
		int result = 0;
		if (sVo != null) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	// 사업자 비밀번호 찾기
	@Override
	public int sellerPwupdate(SellerJoinVO svo) {
		int result = 0;
		try {
			result = loginDAO.sellerPwupdate(svo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 사용자 비밀번호 찾기
	@Override
	public int userPwCheck(UserJoinVO uvo) {
		UserJoinVO uVo = loginDAO.userPwCheck(uvo);
		int result = 0;
		if (uVo != null) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	// 사용자 비밀번호 찾기
	@Override
	public int userPwupdate(UserJoinVO uvo) {
		int result = 0;
		try {
			result = loginDAO.userPwupdate(uvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
}
