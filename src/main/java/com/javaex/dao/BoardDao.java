package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;
	// 생성자

	// GS

	// 일반
	public List<BoardVo> boardList() {

		return sqlSession.selectList("board.boardList");
	}

	public BoardVo readBoard(int no) {

		return sqlSession.selectOne("board.readBoard", no);
	}

	public int delete(int no) {

		return sqlSession.delete("board.delete", no);

	}

	public int write(BoardVo boardVo) {

		return sqlSession.insert("board.write", boardVo);

	}

	public int hitcount(int no) {

		return sqlSession.update("board.hitcount", no);

	}
	
	public int modify(BoardVo boardVo) {
		
		return sqlSession.update("board.modify", boardVo);
	}
	
	public List<BoardVo> search(String key){
		
		return sqlSession.selectOne("board.search", key);
	}
}
