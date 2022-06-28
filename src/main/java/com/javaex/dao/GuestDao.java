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
	
	public int insertGuest(GuestVo guestVo) {
		
		System.out.println("쿼리문 전 >>" + guestVo);	//no 값 x
		
		int count = sqlSession.insert("guestbook.insertSelectKey", guestVo);
		
		System.out.println("쿼리문 후 >>" + guestVo);
		return count;
		
		//no 값 o
	}
	
	//방명록 저장 후 등록한 데이타 가져오기(ajax)
	public GuestVo getGuest(int no) {
		
		GuestVo guestVo = sqlSession.selectOne("guestbook.getGuest", no);
		
		return null;
	}
}
