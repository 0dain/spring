package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;

@Service
public class BoardService {
	
	
	@Autowired
	BoardMapper boardMapper;
	
	//게시물 전부 다 가져오기
	public List<Board> selectAllBoard(){
		return boardMapper.selectAllBoard();
	}

	
	//게시글 제목 클릭 시 해당 게시글로 이동(들어가기)
	public Board selectOneBoard(int boardnum) {
		return boardMapper.selectOneBoard(boardnum);
	}
	
	//다른 타입의 데이터를 같이 넘겨줘야 할 때: HashMap<키, 오브젝트>
	public void setLikeNum(String state, int num) {
		
		//state: plus / minus
		
		HashMap<String, Object> map=new HashMap<>();
		map.put("state", state);
		map.put("num", num);
		
		boardMapper.setLikeNum(map);
	}
	
	//현재 게시글의 좋아요 개수 불러오기
	public int getLikeNum(int boardnum) {
		
		return boardMapper.getLikeNum(boardnum);
		
	}
	
	
}
