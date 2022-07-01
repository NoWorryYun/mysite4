package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//Gs
	
	//일반
	
	public int join(UserVo userVo) {
		
		int count  =  sqlSession.insert("users.join", userVo);
		
		return count;
	}
	
	public int modify(UserVo userVo) {
		
		int count = sqlSession.update("users.modify", userVo);
		
		return count;
	}
	
	public UserVo getUserInfo(int no) {
		
		UserVo userVo = sqlSession.selectOne("users.getUserInfo", no);
		
		return userVo;
		
	}
	
	public UserVo login(UserVo userVo) {
		
		return sqlSession.selectOne("users.login", userVo);
		
	}
}
