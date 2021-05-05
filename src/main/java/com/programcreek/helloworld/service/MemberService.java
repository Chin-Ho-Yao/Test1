package com.programcreek.helloworld.service;

import org.json.JSONObject;

import com.programcreek.helloworld.model.Member;

//這啥
public interface MemberService {

	Member getMember(Integer memberId);

	Member createMember(Member member);

	Member updateMember(JSONObject receiveJsonObject);

	void deleteMember(Integer memberId);

}
