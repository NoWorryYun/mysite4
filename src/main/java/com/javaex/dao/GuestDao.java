package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {

	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	
	//GS
	
	//일반
	public List<GuestVo> addlist(){
		
		return sqlSession.selectList("guestbook.addlist");
	}
	
	public int add(GuestVo guestVo) {
		
		return sqlSession.insert("guestbook.add", guestVo);
	}
	
	public String getPassword(int no) {
		
		return sqlSession.selectOne("guestbook.getPassword", no);
	}
	
	public int delete(int no) {
		
		return sqlSession.delete("guestbook.delete", no);
		
	}
}
