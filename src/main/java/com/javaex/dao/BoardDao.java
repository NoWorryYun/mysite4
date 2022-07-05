package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		return sqlSession.selectList("board.search", key);
	}
	
	public List<BoardVo> boardList2(String key) {

		return sqlSession.selectList("board.boardList2", key);
	}

	public List<BoardVo> boardList4(int startRnum, int endRnum) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		System.out.println(map);
		
		return sqlSession.selectList("board.boardList4", map);
	}
	
	//전체글개수
	public int selectTotalCnt() {
		System.out.println("selectTotalCnt , dao");
		
		int totalCnt = sqlSession.selectOne("board.selectTotalCnt");
		System.out.println("서비스 토탈카운트"+totalCnt);
		return totalCnt;
	}
	
}
