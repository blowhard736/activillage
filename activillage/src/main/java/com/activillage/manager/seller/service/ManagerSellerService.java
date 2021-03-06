package com.activillage.manager.seller.service;

import java.util.List;
import java.util.Map;

import com.activillage.seller.join.vo.SellerJoinVO;

public interface ManagerSellerService {
	public List<SellerJoinVO> sellerList(SellerJoinVO svo);

	public int sellerWithdrawal(SellerJoinVO svo);

	public int sellerListCnt(SellerJoinVO svo);
	
	public int sellerApproval(SellerJoinVO svo);
	
	public Map<String, Integer> sellerAreaList();
}
