package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		boardService.hitcount(no);
		
		BoardVo readBoard = boardService.readBoard(no);
		
		model.addAttribute("boardVo", readBoard);
		
		return "board/read";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no, HttpSession session) {
		
		System.out.println(session);
		
		boardService.delete(no);
		
		return "redirect:list";
		
	}
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		return "board/writeForm";
		
	}
	@RequestMapping(value="/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo) {
		
		boardService.write(boardVo);
		
		return "redirect:list";
		
	}
	@RequestMapping(value="/modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, @RequestParam("no") int no) {

		BoardVo boardVo = boardService.readBoard(no);
		
		model.addAttribute("boardVo", boardVo);
		
		return "board/modifyForm";
	}
	
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		
		boardService.modify(boardVo);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/search", method = {RequestMethod.GET, RequestMethod.POST})
	public String search(@RequestParam("key") String key, Model model) {
		
		List<BoardVo> boardList = boardService.search(key);
		
		model.addAttribute("boardList", boardList);
	
		return "board/list";
	}
}