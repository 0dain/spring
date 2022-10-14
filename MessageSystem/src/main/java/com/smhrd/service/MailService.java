package com.smhrd.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.common.Criteria;
import com.smhrd.mapper.MailMapper;
import com.smhrd.model.WebMessage;

@Service
public class MailService {
	
	@Autowired
	MailMapper mailMapper;
	
	public void sendMail(WebMessage webMessage) {
		mailMapper.sendMail(webMessage);
	}
	
	//메일 확인
	public List<WebMessage> selectMail(String email) {
		List<WebMessage> messageList=mailMapper.selectMail(email);
		return messageList;
	}
	
	//전체 메일 삭제
	public void deleteAllMail(String email) {
		mailMapper.deleteAllMail(email);
	}
	
	//특정 메일 삭제
	public void selectDeleteMail(int num) {
		mailMapper.selectDeleteMail(num);
	}
	
	//메일 페이징
	public List<WebMessage> selectMailPaging(String email, Criteria cri){
		HashMap<String, Object> map=new HashMap<>();
		map.put("email", email);
		map.put("cri", cri);
		
		List<WebMessage> messageList=mailMapper.selectMailPaging(map);
		
		return messageList;
	}
	
	//몇 페이지가 필요한가?! 에 대한 메서드
	public int countMail(String email) {
		int total=mailMapper.countMail(email);
		return total;
	}

}
