package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.config.auth.CustomUserDetailService;
import com.example.demo.model.Member;
import com.example.demo.model.MemberDetail;

@Mapper
public interface MemberMapper {
	
	public MemberDetail findByUserId(String id);
	
	public int join(Member member);
	
	public Member login(Member member);
}
