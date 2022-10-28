package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.BoardService;
import com.example.demo.service.CommentService;

//컨트롤러는 view반환
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CommentService commentService;
	
	//해당 게시글에 대한 정보와 댓글 내용 현재 댓글 개수 저장해서 boardView에 반환
	@GetMapping("/board/view/{boardnum}")
	public String view(@PathVariable("boardnum") int num, Model model) {
		model.addAttribute("board", boardService.selectOneBoard(num));
		model.addAttribute("comList", commentService.selectAllCom(num));
		model.addAttribute("comNum", commentService.countCom(num));
		return "boardView";
	}

}
