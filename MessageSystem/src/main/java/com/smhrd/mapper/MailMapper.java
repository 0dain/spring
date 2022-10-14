package com.smhrd.mapper;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.model.WebMessage;

@Mapper
public interface MailMapper {
	
	//메세지 작성
	@Insert("insert into webmessage values(null, #{sendName}, #{receiveEmail}, #{message}, now())")
	public void sendMail(WebMessage webMessage);
	
	//받은 메세지 보기
	@Select("select * from webmessage where receiveEmail=#{receiveEmail}")
	public List<WebMessage> selectMail(String email);

	
	//메세지(메일) 페이징~
	//HashMap<String(키 값), Object(int, String 등 여러 값이 들어올 수 있음)>
		//hashmap에 (email, criteria(pageNum, amount))이 들어 있음
	public List<WebMessage> selectMailPaging(HashMap<String, Object> map);//HashMap import -> 자바 유틸
	
	//몇 페이지가 필요한가?!
	@Select("select count(*) from webmessage where receiveEmail=#{email}")
	public int countMail(String email);
	

	//메일 전체 삭제
	@Delete("Delete from webmessage where receiveEmail=#{email}")
	public void deleteAllMail(String email);
	
	//특정 메일 삭제
	@Delete("Delete from webmessage where num=#{num}")
	public void selectDeleteMail(int num);
	
	
	
}
