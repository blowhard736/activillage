package com.activillage.user.goodslist.vo;

public class GoodsListVO {

	private int g_no = 0;
	private String g_do = "";
	private String g_category = "";
	private String g_thumb = "";
	private String g_name = "";
	private int g_price = 0;
	private int r_grade = 0;

	// 조건 검색 시 사용할 필드
	private String search_name = "";
	private String search_keyword = "";

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getG_do() {
		return g_do;
	}

	public void setG_do(String g_do) {
		this.g_do = g_do;
	}

	public String getG_category() {
		return g_category;
	}

	public void setG_category(String g_category) {
		this.g_category = g_category;
	}

	public String getG_thumb() {
		return g_thumb;
	}

	public void setG_thumb(String g_thumb) {
		this.g_thumb = g_thumb;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getG_price() {
		return g_price;
	}

	public void setG_price(int g_price) {
		this.g_price = g_price;
	}

	public int getR_grade() {
		return r_grade;
	}

	public void setR_grade(int r_grade) {
		this.r_grade = r_grade;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	@Override
	public String toString() {
		return "GoodsListVO [g_no=" + g_no + ", g_do=" + g_do + ", g_category=" + g_category + ", g_thumb=" + g_thumb
				+ ", g_name=" + g_name + ", g_price=" + g_price + ", r_grade=" + r_grade + ", search_name="
				+ search_name + ", search_keyword=" + search_keyword + ", toString()=" + super.toString() + "]";
	}

}
