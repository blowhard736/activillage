package com.activillage.manager.seller.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.seller.join.vo.SellerJoinVO;

@Repository
public class ManagerSellerDaoImpl implements ManagerSellerDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<SellerJoinVO> sellerList(SellerJoinVO svo) {
		// TODO Auto-generated method stub
		return session.selectList("sellerList");
	}

	@Override
	public int sellerWithdrawal(SellerJoinVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sellerListCnt(SellerJoinVO svo) {
		// TODO Auto-generated method stub
		return (Integer) session.selectOne("sellerListCnt", svo);
	}

	@Override
	public int sellerApproval(SellerJoinVO svo) {
		// TODO Auto-generated method stub
		return session.update("sellerApproval",svo);
	}

	@Override
	public Map<String, Integer> sellerAreaList() {
		// TODO Auto-generated method stub
		return session.selectMap("sellerAreaList", "");
	}

}
