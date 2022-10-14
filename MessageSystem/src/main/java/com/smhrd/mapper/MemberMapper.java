package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.model.WebMember;

//mapper interface지정
@Mapper
public interface MemberMapper {
	
	//회원가입
	public void joinMember(WebMember member);
	
	
	//로그인
		//sql문을 mapper에 쓰지 않고 골뱅이를 활용하여 쓰는 법!
	@Select("select * from webmember where email=#{email} and pw=#{pw}")
	public WebMember loginMember(WebMember member);
	
	
	//회원정보 수정
	@Update("update webmember set pw=#{pw}, tel=#{tel}, address=#{address} where email=#{email}")
	public void updateMember(WebMember member);
	
	//전체회원 조회
	@Select("select * from webmember")
	public List<WebMember> selectAllMember();
	
	//특정회원 삭제
	@Delete("delete from webmember where email=#{email}")
	public void deleteMember(String email);
	
}
