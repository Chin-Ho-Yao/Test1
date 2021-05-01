package com.programcreek.helloworld.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.programcreek.helloworld.service.MemberService;
import com.programcreek.helloworld.model.Member;
//https://matthung0807.blogspot.com/2018/05/springmvc-4-hibernate-5-mysql.html
@Controller
public class HelloController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/helloHibernate")
	public ModelAndView hello() {
		System.out.println("helloHibernate");

		Member member = memberService.getMember(1);

		
		String MemberName = member.getMemberName();
		Date RegisterTime = member.getRegisterTime();
		System.out.println(MemberName);
		System.out.println(RegisterTime);

		ModelAndView mv = new ModelAndView("helloHibernate");
		mv.addObject("MemberName", MemberName);
		mv.addObject("RegisterTime", RegisterTime);
		return mv;
	}
}
