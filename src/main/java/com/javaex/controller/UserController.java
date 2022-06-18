package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	//필드
	@Autowired
	private UserService userService;
	//생성자
	
	//GS
	
	//일반
	
	@RequestMapping(value="/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "user/joinForm";
	}
	
	@RequestMapping(value="/joinCheck", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinOk(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.joinCheck()");

		userService.join(userVo);
		
		return "user/joinOk";
	}
	
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		System.out.println("UserController.modifyForm()");
		
		return "user/modifyForm";
	}
	
}
