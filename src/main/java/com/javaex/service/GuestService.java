package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {

	//필드
	@Autowired
	private GuestDao guestDao;
	
	//일반
	public List<GuestVo> addlist(){
		
		return guestDao.addlist();
	}
	
	public int add(GuestVo guestVo) {
		
		return guestDao.add(guestVo);
	}
	
	public String getPassword(int no) {
		
		return guestDao.getPassword(no);
	}
	
	public int delete(int no) {
		
		return guestDao.delete(no);
		
	}
	
	public GuestVo insertGuest(GuestVo guestVo) {
		//저장
		
		guestDao.insertGuest(guestVo);
		
		int no = guestVo.getNo();
		
		//방금 저장한 1개의 데이터를 가져온다.
		GuestVo gVo = guestDao.getGuest(no);
	
		System.out.println(gVo);
	
		return gVo;
	}
	
	public String removeGuest(GuestVo guestVo) {

		String state;
		
		int count = guestDao.guestDelete(guestVo);
		
		if(count>0) {
			state = "success";
		} else {
			state = "fail";
		}
		return state;
	}
}
