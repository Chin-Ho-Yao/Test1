package com.programcreek.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.programcreek.helloworld.service.MemberService;
import com.programcreek.helloworld.model.Member;
//https://matthung0807.blogspot.com/2018/05/springmvc-4-hibernate-5-mysql.html
@Controller
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
