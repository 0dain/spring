package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BoardService;

//@Controller + @responseBody

//데이터 반환하는 역할: 비동기 통신에 사용됨
@RestController
public class BoardRestController {
	
	@Autowired
	BoardService boardService;

	//좋아요 버튼 눌렀을 때 디비랑 연동될 수 있도록 하기
	@GetMapping("/board/like/{state}/{boardnum}")
	public int setLikeNum(@PathVariable("state") String state, @PathVariable("boardnum") int num) {
		
		boardService.setLikeNum(state, num);
		return boardService.getLikeNum(num);
	}
	
	
}
