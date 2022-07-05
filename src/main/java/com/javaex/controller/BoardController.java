package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "/board")
public class BoardController {

	// 필드
	@Autowired
	private BoardService boardService;
	// 생성자

	// Gs

	// 일반

	// List따로
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String boardList(Model model) {

		List<BoardVo> boardList = boardService.boardList();

		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	// Search따로
	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String search(@RequestParam("key") String key, Model model) {

		List<BoardVo> boardList = boardService.search(key);

		model.addAttribute("boardList", boardList);

		return "board/list";
	}

	// 읽기
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String readBoard(Model model, @RequestParam("no") int no) {

		boardService.hitcount(no);

		BoardVo readBoard = boardService.readBoard(no);

		model.addAttribute("boardVo", readBoard);

		return "board/read";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, HttpSession session) {

		System.out.println(session);

		boardService.delete(no);

		return "redirect:list";

	}

	// 글쓰기form
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		return "board/writeForm";

	}

	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {

		boardService.write(boardVo);

		return "redirect:list";

	}

	// 수정form
	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(Model model, @RequestParam("no") int no) {

		BoardVo boardVo = boardService.readBoard(no);

		model.addAttribute("boardVo", boardVo);

		return "board/modifyForm";
	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {

		boardService.modify(boardVo);

		return "redirect:list";
	}

	// 검색+List 동시에 사용하는 컨트롤러
	@RequestMapping(value = "/list2", method = { RequestMethod.GET, RequestMethod.POST })
	public String list2(Model model, @RequestParam(value = "key", required = false, defaultValue = "") String key) {

		System.out.println("Controller > BoardList2");

		List<BoardVo> boardList = boardService.boardList2(key);

		model.addAttribute("boardList", boardList);

		return "board/list2";

	}
	
	//리스트 일반 + 페이징 + 검색
	@RequestMapping(value = "/list4", method = { RequestMethod.GET, RequestMethod.POST })
	public String list4(Model model, @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

		Map<String, Object> pMap = boardService.getBoardList4(crtPage);

		model.addAttribute("pMap", pMap);

		return "board/list4";
	}
}