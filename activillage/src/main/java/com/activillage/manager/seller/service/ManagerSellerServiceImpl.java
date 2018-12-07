package com.activillage.manager.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activillage.manager.seller.dao.ManagerSellerDao;
import com.activillage.manager.vo.ManagerJoinVO;
import com.activillage.seller.join.vo.SellerJoinVO;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class ManagerSellerServiceImpl implements ManagerSellerService {

	@Autowired
	private ManagerSellerDao managerSellerDao;

	@Override
	public List<SellerJoinVO> sellerList(SellerJoinVO svo) {
		List<SellerJoinVO> sList = null;

		// 정렬에 대한 기본값 설정
		if (svo.getOrder_by() == null)
			svo.setOrder_by("s_joinday");
		if (svo.getOrder_sc() == null)
			svo.setOrder_sc("DESC");

		sList = managerSellerDao.sellerList(svo);
		return sList;
	}

	@Override
	public int sellerWithdrawal(SellerJoinVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sellerListCnt(SellerJoinVO svo) {
		return managerSellerDao.sellerListCnt(svo);
	}

	@Override
	public int sellerApproval(SellerJoinVO svo) {
		int result = 0;
		try {
			result = managerSellerDao.sellerApproval(svo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
