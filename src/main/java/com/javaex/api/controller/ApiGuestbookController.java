package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class ApiGuestbookController {

	@Autowired
	private GuestService guestService;
	
	
	//방명록 첫페이지(등록폼+리스트(ajax))
	@RequestMapping(value="/api/guestbook/addList", method = {RequestMethod.GET, RequestMethod.POST})
	public String addList() {
		System.out.println("apiContrller > addlist");
		
		return "apiGuestbook/addList";
	}
	
	//방명록 리스트 데이타만 보내줘
	@ResponseBody
	@RequestMapping(value="/api/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<GuestVo> list() {
		System.out.println("apiContrller > list");
		
		List<GuestVo> guestList = guestService.addlist();
		return guestList;
	}
	
	//방명록 저장
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add", method = {RequestMethod.GET, RequestMethod.POST})
	public GuestVo add(@ModelAttribute GuestVo guestVo) {
		System.out.println("apiContrller > add()");
		
		GuestVo gVo = guestService.insertGuest(guestVo);
		
		System.out.println(gVo);
		
		return gVo;
	}
	
	//방명록 삭제
	@ResponseBody
	@RequestMapping(value="/api/guestbook/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("apiCotroller > remove()");
		System.out.println(guestVo);
		
		String state = guestService.removeGuest(guestVo);
		
		return state;
	}
	
	//방명록 저장
	@ResponseBody
	@RequestMapping(value="/api/guestbook/add2", method = {RequestMethod.GET, RequestMethod.POST})
	public GuestVo add2(@RequestBody GuestVo guestVo) {
		System.out.println("apiContrller > add2()");
		System.out.println(guestVo);
		
		GuestVo gVo = guestService.insertGuest(guestVo);
		
		return gVo;
	}
}
