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
		
		int count = sqlSession.insert("guestbook.insertSelectKey", guestVo);
		
		return count;
		
		//no 값 o
	}
	
	//방명록 저장 후 등록한 데이타 가져오기(ajax)
	public GuestVo getGuest(int no) {
		
		GuestVo guestVo = sqlSession.selectOne("guestbook.getGuest", no);
		
		return guestVo;
	}
	
	public int guestDelete(GuestVo guestVo) {
		System.out.println("Dao > guestDelete");
		
		System.out.println(guestVo);
		
		int count = sqlSession.delete("guestbook.guestDelete", guestVo);
		return count;
	}
}
