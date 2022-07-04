package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RBoardVo;

@Repository
public class RBoardDao {

	@Autowired
	private SqlSession sqlsession;
	//게시판 불러오기
	public List<RBoardVo> boardList(){
		
		return sqlsession.selectList("rBoard.boardList");
		
	}

	//게시판 읽기
	public RBoardVo readBoard(int no) {
		
		return sqlsession.selectOne("rBoard.readBoard", no);
		
	}
	//일반 글쓰기
	public int writeBoard(RBoardVo rBoardVo) {
		
		return sqlsession.insert("rBoard.writeBoard", rBoardVo);
		
	}
	
	//코멘트 글쓰기
	public int writeComment(RBoardVo rBoardVo) {
		
		return sqlsession.insert("rBoard.writeComment", rBoardVo);
	}
	
	//Group, order, depth불러오기
	public RBoardVo getTrinity(int groupNo) {
		
		return sqlsession.selectOne("rBoard.getTrinity", groupNo);
	}
	
	//조회수 올리기
	public int hitCount(int no) {
		
		return sqlsession.update("rBoard.hitcount", no);
	}
	
	
}
