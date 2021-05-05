package com.programcreek.helloworld.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programcreek.helloworld.model.Member;
import com.programcreek.helloworld.service.MemberService;

//https://matthung0807.blogspot.com/2018/05/springmvc-4-hibernate-5-mysql.html
@Controller
public class HelloController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/helloHibernate")
	public ModelAndView hello() {
		System.out.println("helloHibernate(From HelloController.java)");

		Member member = memberService.getMember(1);

		
		String MemberName = member.getMemberName();
		Date RegisterTime = member.getRegisterTime();
		System.out.println(MemberName);
		System.out.println(RegisterTime);

		ModelAndView mv = new ModelAndView("helloHibernate");//這邊回到views的helloHibernate.jsp
		mv.addObject("MemberName", MemberName);
		mv.addObject("RegisterTime", RegisterTime);
		return mv;
	}
	
	@RequestMapping(value = "/createMember",method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public String createMember(HttpServletRequest request, @RequestBody String receiveJSONString) {
		System.out.println("createMember(From HelloController.java)");
		String resultString = null;
		System.out.println(receiveJSONString);

		//轉換收到的request
		JSONObject receiveJsonObject = new JSONObject(receiveJSONString);
		Integer memberId = receiveJsonObject.optInt("member_id");
		String memberEmail = receiveJsonObject.optString("member_email");
		String memberName = receiveJsonObject.optString("member_name");
		String password = receiveJsonObject.optString("password");
		
		//將轉換的request 塞入新增的model
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		member.setPassword(password);
		//
		Timestamp timeStampDate = new Timestamp(new Date().getTime());
		member.setRegisterTime(timeStampDate);
		member.setLoginTime(timeStampDate);
		member.setUpdateTime(timeStampDate);
		

		Member memberResult = memberService.createMember(member);
		resultString = this.writeValueAsString(memberResult);
		System.out.println(resultString);
		return resultString;
	}
	
	@RequestMapping(value = "/updateMember",method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public String updateMember(HttpServletRequest request, @RequestBody String receiveJSONString) {
		System.out.println("updateMember(From HelloController.java)");
		String resultString = null;
		System.out.println(receiveJSONString);

		//轉換收到的request
		JSONObject receiveJsonObject = new JSONObject(receiveJSONString);

		Member memberResult = memberService.updateMember(receiveJsonObject);
		resultString = this.writeValueAsString(memberResult);
		System.out.println(resultString);
		return resultString;
	}
	
	@RequestMapping(value = "/deleteMember",method = {
			RequestMethod.POST }, produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
	public String deleteMember(HttpServletRequest request, @RequestBody String receiveJSONString) {
		System.out.println("deleteMember(From HelloController.java)");
		String resultString = null;
		System.out.println(receiveJSONString);
		
		//轉換收到的request
		JSONObject receiveJsonObject = new JSONObject(receiveJSONString);
		Integer memberId = receiveJsonObject.optInt("member_id");
		
		memberService.deleteMember(memberId);
		return resultString;
	}
	
	public static String writeValueAsString(Object object){
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (IOException e) {
			System.err.println("IOException :"+e.getMessage());
		}
		return jsonString;
	}
}
