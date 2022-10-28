package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MemberMapper;
import com.example.demo.model.Member;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	public int join(Member member) {
		return memberMapper.join(member);
	}
	
	public Member login(Member member) {
		return  memberMapper.login(member);
	}
}
