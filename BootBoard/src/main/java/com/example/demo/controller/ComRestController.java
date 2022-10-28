package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import com.google.gson.Gson;

//비동기 통신
@RestController
public class ComRestController {
	
	@Autowired
	CommentService commentService;
	
	//댓글 추가
	@PostMapping("/com/add")
	public String comAdd(@RequestBody HashMap<String, Object> map) {
		//새로 작성된, 기존에 있던 내용들 출력 하려면 CommentService에 있는 메서드 활용해서 불러오면 됨


		commentService.comAdd(map);
		
		HashMap<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("result", "success");//만약에 판단하고 싶으면 반환타입 int로 받아서 0이면 실패 1이면 성공을 해주면 됨
		
		//JS에서는 HashMap을 바로 쓸 수 없어서 형변환 해야 함 JSON형식으로!
			//Gson이라는 라이브러리를 이용해서 json으로 변경해서 넘겨주자!
		Gson gson=new Gson();
		
		String result=gson.toJson(resultMap);//json형식의 문자열 반환
		
		return result;
	}
	
}
