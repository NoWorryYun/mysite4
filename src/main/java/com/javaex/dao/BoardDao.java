package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자
	
	//GS
	
	//일반
	public List<BoardVo> boardList(){
		
		return sqlSession.selectList("board.boardList");
	}
	
	public BoardVo readBoard(int no) {
		
		return sqlSession.selectOne("board.readBoard", no);
	}
	
}