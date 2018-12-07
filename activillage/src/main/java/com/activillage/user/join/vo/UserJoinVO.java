package com.activillage.user.join.vo;

import com.activillage.common.vo.CommonVO;

public class UserJoinVO extends CommonVO{
	private int u_no; // 사용자 고유 번호
	private String u_email; // 사용자 email
	private String u_pw; // 비밀번호
	private String u_name; // 사용자 이름
	private String u_birth; // 생년월일
	private String u_phone; // 연락처
	private String u_withdrawal; // 탈퇴여부
	private String u_joinday; // 가입일

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_withdrawal() {
		return u_withdrawal;
	}

	public void setU_withdrawal(String u_withdrawal) {
		this.u_withdrawal = u_withdrawal;
	}

	public String getU_joinday() {
		return u_joinday;
	}

	public void setU_joinday(String u_joinday) {
		this.u_joinday = u_joinday;
	}

}