package com.smhrd.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//골뱅이 AllArgsConstructor만 써주면 int형인 num에 null값이 못들어가기때문에 쓰지 않거나 
//쓰더라도 int num이 없는 생성자를 하나 더 오버라이딩 해줘야 함 
@Data
public class WebMessage {
	
	private int num;
	private String sendName;
	private String receiveEmail;
	private String message;
	private Date sendDate; //date import sql로 하기
	

}
