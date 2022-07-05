package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;
	// 생성자

	// GS

	// 일반
	public List<BoardVo> boardList() {

		return boardDao.boardList();
	}

	public BoardVo readBoard(int no) {

		return boardDao.readBoard(no);
	}

	public int delete(int no) {

		return boardDao.delete(no);

	}

	public int write(BoardVo boardVo) {

		return boardDao.write(boardVo);
	}

	public int hitcount(int no) {

		return boardDao.hitcount(no);
	}

	public int modify(BoardVo boardVo) {

		return boardDao.modify(boardVo);
	}

	public List<BoardVo> search(String key) {

		return boardDao.search(key);
	}

	public List<BoardVo> boardList2(String key) {

		return boardDao.boardList2(key);
	}
	
	public Map<String, Object> getBoardList4(int crtPage) {
		System.out.println("보드서비스 리스트");
		System.out.println(crtPage);

		//페이지당 글 갯수
		
		int listCnt = 10;
		
		//현재페이지
		crtPage = (crtPage>0) ? crtPage : (crtPage=1);
		
//		if(crtPage > 0 ) {
//		} else {
//			crtPage = 1;
//		}
//		
		//시작글번호
		int startRnum = (crtPage - 1) * listCnt+1;
		
		//끝글번호
		int endRnum = (startRnum + listCnt) - 1;
		
		/*
		int endRnum =  crtPage * 10;
		int startRnum = endRnum - 9;
		*/
		
		//System.out.println(crtPage + ", " + listCnt + ", " + startRnum + ", " + endRnum);
		//System.out.println(crtPage +  ", " + startRnum + ", " + endRnum);
	
		List<BoardVo> boardList = boardDao.boardList4(startRnum, endRnum);
		/////////////////////////////
		//페이징 계산
		/////////////////////////////
		
		//전체글 갯수 확인
		int totalCnt = boardDao.selectTotalCnt();
		
		//페이지 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 번호
		int endPageBtnNo = (int)Math.ceil(crtPage / (double) pageBtnCount) * pageBtnCount;
		
		//시작 번호
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		//다음 화살표
		boolean next = false;
		
		if((listCnt*endPageBtnNo) < totalCnt) {
			next=true;
		} else {
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		}
		
		//이전 화살표
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		
		pMap.put("boardList", boardList);
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		
		System.out.println(pMap);
		System.out.println(endPageBtnNo);
		
		return pMap;
	}
	
	

}