package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;

@Service
public class CommentService {

	@Autowired
	CommentMapper commentMapper;
	
	//모든 댓글
	public List<Comment> selectAllCom(int boardnum){
		return commentMapper.selectAllCom(boardnum);
	}
	
	//현재 게시글 댓글 개수
	public int countCom(int boardnum) {
		return commentMapper.countCom(boardnum);
	}
	
	//댓글 추가
	public void comAdd(HashMap<String, Object> map) {
		commentMapper.comAdd(map);
	}
}
