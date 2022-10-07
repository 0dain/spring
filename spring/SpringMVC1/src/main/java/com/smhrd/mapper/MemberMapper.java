package com.smhrd.mapper;

import java.util.List;

import com.smhrd.model.Member;

public interface MemberMapper {
//	sql문을 실행할 수 있도록 추상 메서드 작성
	
	//회원가입
		//제대로 됐는지 안 됐는지 확인해서 조건을 달리하고 싶으면 반환타입 int로 하면 됨
	public void joinMember(Member member);//우리가 만든 Member로 import, MemberControlle에서 호출해서 사용할 거임
	//사용자가 입력한 값을 넣을 수 있도록 매개변수에 Member객체로 Member받기
	
	//로그인
	public Member loginMember(Member member);
	
	//회원정보수정
	public void updateMember(Member member);
	
	//전체회원정보조회
	public List<Member> selectAllMember();
}
