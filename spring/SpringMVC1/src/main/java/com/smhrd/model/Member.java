package com.smhrd.model;

public class Member {
	//필드 이름이랑 DB테이블 이름을 똑같게!
	private String id;
	private String pw;
	private String nick;
	
	//단축키 alt + shift + s
	//생성자
	public Member(String id, String pw, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	//생성자(id,pw)
	public Member(String id, String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	//기본 생성자
		//@ModelAttribute용
	public Member() {
		
	}
		
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getId() {
		return id;
	}


	public String getPw() {
		return pw;
	}


	public String getNick() {
		return nick;
	}
	
	
	
}
