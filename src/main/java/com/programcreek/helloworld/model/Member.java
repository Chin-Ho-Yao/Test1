/**
 * 
 */
/**
 * @author yaochinho
 *
 */
package com.programcreek.helloworld.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MEMBER", uniqueConstraints = { @UniqueConstraint(columnNames = { "MEMBER_ID" }) })
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	private Integer memberId;

	@Column(name = "MEMBER_EMAIL", length = 100, nullable = false)
	private String memberEmail;

	@Column(name = "MEMBER_NAME", length = 30)
	private String memberName;

	@Column(name = "PASSWORD", length = 64, nullable = false)
	private String password;

	@Column(name = "REGISTER_TIME")
	private Timestamp registerTime;

	@Column(name = "LOGIN_TIME")
	private Timestamp loginTime;

	@Column(name = "UPDATE_TIME")
	private Timestamp updateTime;

	public Member() {
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


}