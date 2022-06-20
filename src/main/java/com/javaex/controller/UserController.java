package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//회원가입 폼
	@RequestMapping(value="/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="/joinCheck", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinOk(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.joinCheck()");

		userService.join(userVo);
		
		return "user/joinOk";
	}
	
	@RequestMapping(value="/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.login()");
		
		UserVo authUser = userService.login(userVo);
		
		
		
		return "redirect:main";
	}
	
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @RequestParam("no") int no) {
		System.out.println("UserController.modifyForm()");

		UserVo userVo = userService.getUserInfo(no);
		System.out.println(userVo);
		model.addAttribute("userVo", userVo);
		
		return "user/modifyForm";
	}
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo) {
		
		userService.modify(userVo);
		
		return"redirect:main";
	}
}
