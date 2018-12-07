package com.activillage.user.goodslist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activillage.user.goodslist.vo.GoodsListVO;

@Repository
public class GoodsListDAOImpl implements GoodsListDAO {

	@Autowired
	private SqlSession session;

	@Override
	public List<GoodsListVO> goodsList(GoodsListVO gvo) {
		return session.selectList("goodsList", gvo);
	}

}
