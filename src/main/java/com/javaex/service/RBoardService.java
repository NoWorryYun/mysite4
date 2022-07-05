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

	String dep = "&nbsp&nbsp&nbsp;&nbsp;";
	
	
	// 게시판 읽기
	public List<RBoardVo> boardList() {

		List<RBoardVo> boardList = rboardDao.boardList();

		for(int i = 0 ; i < boardList.size() ; i++) {
			int depths = boardList.get(i).getDepth();
			if(	depths >= 1) {
				for(int j=0 ; j < depths ; j++) {
					dep += dep;
				}
				boardList.get(i).setTitle(dep + boardList.get(i).getTitle());
				dep = "&nbsp&nbsp&nbsp;&nbsp;";
			}
		}
		
		return boardList;

	}

	// Group, order, depth가져오기
	public RBoardVo getTrinity(int groupNo) {

		return rboardDao.getTrinity(groupNo);

	}

	// 일반 글쓰기
	public int writeBoard(RBoardVo rBoardVo) {

		return rboardDao.writeBoard(rBoardVo);

	}

	// 코멘트 글쓰기
	public int writeComment(RBoardVo rBoardVo) {

		int count = rboardDao.writeComment(rBoardVo);

		// 부모 제외 전체 order에 + 1
		rboardDao.orderCount(rBoardVo);
		// depth에 + 1
		rboardDao.depthcount(rBoardVo);
		// 자신 order에 + 1
		rboardDao.selfordercount(rBoardVo);

		return count;

	}

	// 게시판 읽기
	public RBoardVo readBoard(int no) {

		rboardDao.hitCount(no);

		return rboardDao.readBoard(no);

	}

}
