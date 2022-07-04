package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RBoardDao;
import com.javaex.vo.RBoardVo;


@Service
public class RBoardService {
	
	@Autowired
	private RBoardDao rboardDao;
	
	// 게시판 읽기
	public List<RBoardVo> boardList(){
		
		return rboardDao.boardList();
	
	}
	
	// Group, order, depth가져오기
	public RBoardVo getTrinity(int groupNo) {
		
		return rboardDao.getTrinity(groupNo);
		
	}
	
	//일반 글쓰기
	public int writeBoard(RBoardVo rBoardVo) {
		
		return rboardDao.writeBoard(rBoardVo);
		
	}
	
	//코멘트 글쓰기
	public int writeComment(RBoardVo rBoardVo) {
		
		return rboardDao.writeComment(rBoardVo);
		
	}
	
	//게시판 읽기
	public RBoardVo readBoard(int no) {
		
		rboardDao.hitCount(no);
		
		return rboardDao.readBoard(no);
		
	}
	
}
