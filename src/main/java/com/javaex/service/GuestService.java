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
}
