package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value="/guest")
public class GuestController {

	//필드
	@Autowired
	private GuestService guestService;
	
	//생성자
	
	//메소드
	@RequestMapping(value="/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addlist(Model model){
		
		List<GuestVo> guestList = guestService.addlist();
		
		model.addAttribute("guestList", guestList);
		
		return "guestbook/addlist";
	}
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(GuestVo guestVo) {
		
		guestService.add(guestVo);
		
		return "redirect:addlist";
	}
	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		return "guestbook/deleteForm";
		
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		
		String oraclepassword = guestService.getPassword(no);
		
		if(oraclepassword.equals(password)) {
			
			guestService.delete(no);
			
		} else {
			
			System.out.println("비밀번호가 틀립니다.");
			
		}
		
		return "redirect:addlist";
	}
}
