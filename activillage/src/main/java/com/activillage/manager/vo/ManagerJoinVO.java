package com.activillage.manager.vo;

import java.util.Date;

public class ManagerJoinVO {
	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_retire;
	private String m_name;
	private Date m_joinday;

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_retire() {
		return m_retire;
	}

	public void setM_retire(String m_retire) {
		this.m_retire = m_retire;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Date getM_joinday() {
		return m_joinday;
	}

	public void setM_joinday(Date m_joinday) {
		this.m_joinday = m_joinday;
	}

}