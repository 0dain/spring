package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
	//필드 이름이랑 DB테이블 이름을 똑같게!
	private String id;
	private String pw;
	private String nick;
	
	//전체파라미터 생성자
	//기본생성자
	//setter
	//getter
	

	
	
	//단축키 alt + shift + s
	//생성자
//	public Member(String id, String pw, String nick) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.nick = nick;
//	}

	//생성자(id,pw)
//	public Member(String id, String pw) {
//		this.id=id;
//		this.pw=pw;
//	}
	
	//기본 생성자
		//@ModelAttribute용
//	public Member() {
//		
//	}
	
	
}
