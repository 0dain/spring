package com.smhrd.common;

import lombok.Getter;
import lombok.Setter;

//Data라고 하면 기본 생성자를 같이 만들어주기 때문에 getter, setter로만 적어주기
//여기서는 우리가 생성자를 만들어 주기 때문에~
@Getter
@Setter
//검색 기준
public class Criteria {

	private int pageNum;//페이지 번호
	private int amount;//한 페이지당 글 개수
	
	//기본 생성자
	public Criteria() {
		//pageNum:1, amount:5
		//기본 생성자를 호출이 되면 1, 5를 넣어주겠다
		this(1,5);//아래 생성자가 호출이 되어서 1, 5로 각각 초기화 시켜줌
	}
	
	//초기화 시켜줄 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	
	
	
}
