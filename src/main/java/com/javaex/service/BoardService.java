package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	//필드
	@Autowired
	private BoardDao boardDao;
	//생성자
	
	//GS
	
	//일반
	public List<BoardVo> boardList(){
		
		return boardDao.boardList();
	}
	
	public BoardVo readBoard(int no) {
		
		return boardDao.readBoard(no);
	}
	
}