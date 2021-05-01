package com.programcreek.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.programcreek.helloworld.service.MemberService;
import com.programcreek.helloworld.model.Member;

public class HelloController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/helloHibernate")
	public String hello() {
		System.out.println("helloHibernate");

		Member member = memberService.getMember(1);

		System.out.println(member.getMemberName());
		System.out.println(member.getRegisterTime());

		return "helloHibernate";
	}
}
