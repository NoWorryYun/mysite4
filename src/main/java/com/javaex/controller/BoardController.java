package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	//필드
	@Autowired
	private BoardService boardService;
	//생성자
	
	//Gs
	
	//일반
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(Model model){
		
		List<BoardVo> boardList = boardService.boardList();
		
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	@RequestMapping(value="/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String readBoard(Model model, @RequestParam("no") int no) {

		BoardVo readBoard = boardService.readBoard(no);
		
		model.addAttribute("boardVo", readBoard);
		
		return "board/read";
	}
	
	
	
}