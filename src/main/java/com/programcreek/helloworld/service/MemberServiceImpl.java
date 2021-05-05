package com.programcreek.helloworld.service;

import java.sql.Timestamp;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programcreek.helloworld.dao.MemberDao;
import com.programcreek.helloworld.model.Member;

//j個又是啥
@Service("memberService")
@Transactional // 存取映射必須加上交易管理注釋，用來確定這筆資料處理完成都沒報錯才回處理，如果中間有錯誤就不會動到資料庫
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public Member getMember(Integer memberId) {
		return memberDao.getMember(memberId);
	}

	@Override
	public Member createMember(Member member) {
		memberDao.createMember(member);
		Member memberResult = this.getMember(member.getMemberId());
		return memberResult;
	}

	@Override
	public Member updateMember(JSONObject receiveJsonObject) {
		
		Integer memberId = receiveJsonObject.optInt("member_id");
		String memberEmail = receiveJsonObject.optString("member_email");
		String memberName = receiveJsonObject.optString("member_name");
		String password = receiveJsonObject.optString("password");
		
		Member dbMember = memberDao.getMember(memberId);
		
		//將轉換的request 塞入新增的model
		dbMember.setMemberId(memberId);
		dbMember.setMemberName(memberName);
		dbMember.setMemberEmail(memberEmail);
		dbMember.setPassword(password);
		Timestamp timeStampDate = new Timestamp(new Date().getTime());
		dbMember.setUpdateTime(timeStampDate);
		return dbMember;
	}

	@Override
	public void deleteMember(Integer memberId) {
		Member member = this.getMember(memberId);
		memberDao.deleteMember(member);
	}

}