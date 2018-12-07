package com.activillage.user.goodslist.dao;

import java.util.List;

import com.activillage.user.goodslist.vo.GoodsListVO;

public interface GoodsListDAO {

	public List<GoodsListVO> goodsList(GoodsListVO gvo);

}
