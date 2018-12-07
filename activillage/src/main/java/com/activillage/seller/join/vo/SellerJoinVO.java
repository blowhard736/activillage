package com.activillage.seller.join.vo;

import com.activillage.common.vo.CommonVO;

public class SellerJoinVO extends CommonVO{
	private int s_no;            // 사업자 고유 번호
	private String s_email;      // 사업자email
	private String s_pw;         // 비밀번호
	private String s_bnum;       // 사업자 번호
	private String s_bname;      // 대표자 명
	private String s_cname;      // 회사 명
	private String s_phone;      // 연락처
	private String s_withdrawal; // 탈퇴여부
	private String s_joinday;    // 가입일
	private String s_agree;      // 약관 동의 여부
	private String s_approval;   // 사업자 승인 여부
	
	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_pw() {
		return s_pw;
	}

	public void setS_pw(String s_pw) {
		this.s_pw = s_pw;
	}

	public String getS_bnum() {
		return s_bnum;
	}

	public void setS_bnum(String s_bnum) {
		this.s_bnum = s_bnum;
	}

	public String getS_bname() {
		return s_bname;
	}

	public void setS_bname(String s_bname) {
		this.s_bname = s_bname;
	}

	public String getS_cname() {
		return s_cname;
	}

	public void setS_cname(String s_cname) {
		this.s_cname = s_cname;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public String getS_withdrawal() {
		return s_withdrawal;
	}

	public void setS_withdrawal(String s_withdrawal) {
		this.s_withdrawal = s_withdrawal;
	}

	public String getS_joinday() {
		return s_joinday;
	}

	public void setS_joinday(String s_joinday) {
		this.s_joinday = s_joinday;
	}

	public String getS_agree() {
		return s_agree;
	}

	public void setS_agree(String s_agree) {
		this.s_agree = s_agree;
	}

	public String getS_approval() {
		return s_approval;
	}

	public void setS_approval(String s_approval) {
		this.s_approval = s_approval;
	}

}