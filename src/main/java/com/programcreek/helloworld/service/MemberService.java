package com.programcreek.helloworld.service;

import com.programcreek.helloworld.model.Member;

//這啥
public interface MemberService {

	Member getMember(Integer memberId);

	Member createMember(Member member);

}
