package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 필드
	@Autowired
	private UserDao userDao;

	// 생성자

	// GS

	// 일반
	public int join(UserVo userVo) {

		int count = userDao.join(userVo);

		return count;
	}

	public int modify(UserVo userVo) {

		int count = userDao.modify(userVo);

		return count;
	}
}
