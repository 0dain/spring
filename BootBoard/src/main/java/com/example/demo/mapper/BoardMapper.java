package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Board;

@Mapper
public interface BoardMapper {
	
	//게시글 전부 다 불러오기
	public List<Board> selectAllBoard();

	//게시글 제목 클릭 시 해당 게시글로 들어가기
	public Board selectOneBoard(int boardnum);
	
	//좋아요 눌렀을 때 개수 변동 보여주기
	public void setLikeNum(HashMap<String, Object> map);
	
	public int getLikeNum(int boardnum);
}
