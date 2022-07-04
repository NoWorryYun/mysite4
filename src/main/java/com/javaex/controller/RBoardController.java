package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RBoardService;
import com.javaex.vo.RBoardVo;

@Controller
public class RBoardController {

	@Autowired
	private RBoardService rBoardService;
	
	//게시글 불러오기
	@RequestMapping(value="/rboard/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String rBoardList(Model model) {
		
		List<RBoardVo> boardList = rBoardService.boardList();
		
		model.addAttribute("boardList", boardList);
		
		return "rboard/rList";
	}
	
	//글읽기
	@RequestMapping(value="/rboard/read", method = {RequestMethod.GET, RequestMethod.POST})
	public String rBoardRead(@RequestParam("no") int no, Model model) {
		
		RBoardVo rBoardVo = rBoardService.readBoard(no);
		
		model.addAttribute("rBoardVo", rBoardVo);
		
		return "rboard/rRead";
		
	}
	
	//쓰기폼(일반글쓰기)
	@RequestMapping(value="/rboard/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String rBoardWriteForm() {
		
		return "rboard/rWriteForm";
	}
	
	//글등록
	@RequestMapping(value="/rboard/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String rBoardWriteForm(@ModelAttribute RBoardVo rBoardVo) {
		
		int groupNo = rBoardVo.getGroupNo();
		
		System.out.println(groupNo);
		if(groupNo < 1) {
			rBoardService.writeBoard(rBoardVo);
			System.out.println("write");
		} else {
			rBoardService.writeComment(rBoardVo);
			System.out.println(rBoardVo);
			System.out.println("comment");
		}
		
		
		return "redirect:list";
	}
	
	//쓰기폼(댓글쓰기)
	@RequestMapping(value="/rboard/replyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String rBoardReplyForm(Model model, @RequestParam("no") int no) {
		
		RBoardVo rBoardVo = rBoardService.getTrinity(no);
		
		model.addAttribute("rBoardVo", rBoardVo);
		
		return "rboard/rWriteForm";
	}
	
	@RequestMapping(value="/rboard/reply", method = {RequestMethod.GET, RequestMethod.POST})
	public String rBoardReply(@ModelAttribute RBoardVo rBoardVo) {
		return "redirect:list";
	}
	

	
}
