package com.smhrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.WebMember;

//데이터를 전달받아서 가공하는 역할(POJO형태로 전달)
@Service
public class MemberService {
	
	//controller -> service -> mapper
	@Autowired
	MemberMapper memberMapper;
	
	//회원가입 service
		//membercon에 반환해야 하는 값에 따라서 반환 타입 정할 수 있음
	public void joinMember(WebMember member) {
		//memcon에서 받아온 데이터 DB에 넘겨줄 수 있게 mapper에 전달
			//위에 mapper 객체 생성
		memberMapper.joinMember(member);
		
	}
	
	//로그인 service
	public WebMember loginMember(WebMember member) {
		//memcon에서 받아온 데이터를 DB에 넘겨줄 수 있게 mapper에 전달하고 loginM으로 받음
		WebMember loginM=memberMapper.loginMember(member);
		
		return loginM;
	}
	
	//회원정보 수정 service
	public void updateMember(WebMember member) {
		memberMapper.updateMember(member);
		
	}
	
	//전체회원 조회
	public List<WebMember> selectAllMember(){//List import는 자바 유틸
		List<WebMember> memberList=memberMapper.selectAllMember();
		return memberList;
	}
	
	//특정회원 삭제
	public void deleteMember(String email) {
		memberMapper.deleteMember(email);
	}
	
}
