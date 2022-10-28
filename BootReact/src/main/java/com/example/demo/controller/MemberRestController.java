package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.MemberMapper;
import com.example.demo.config.auth.Auth;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.model.Member;
import com.example.demo.model.MemberDetail;
import com.example.demo.service.MemberService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("member")
@RestController
public class MemberRestController {

	  private final PasswordEncoder passwordEncoder;
	  private final JwtTokenProvider jwtTokenProvider;
	  private final MemberMapper memberMapper;
	    
	  Gson gson=new Gson();

	  @Autowired
	  MemberService memberService;
		


		//회원가입
		@RequestMapping(value="/join",method = RequestMethod.POST)
		public String joinPOST(@RequestBody Member user){
			
			System.out.println(user.toString());
			try {		
				String rawPassword=user.getPw();
				String encPassword=passwordEncoder.encode(rawPassword);
				user.setPw(encPassword);
				user.setRole("USER");
				System.out.println(user); 
				memberService.join(user);
				return "success";		
				}
			catch(Exception e) {
				e.printStackTrace();
				return "fail";
				
			}

		}

	    // 로그인
	    @PostMapping("/login")
	    public String login(@RequestBody Map<String, String> param) throws Exception{

	    	String jsonStr=gson.toJson(param);
	    	
	    	Member user=gson.fromJson(jsonStr,Member.class);
	        System.out.println(user.toString());

	        MemberDetail member = memberMapper.findByUserId(user.getId());
	  
	        if(member == null) {
	        	throw new UsernameNotFoundException("유효하지 않는 로그인 정보입니다.");
	        }
	        
	        if (!passwordEncoder.matches(user.getPw(), member.getPw())) {
	            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
	        }
	    	
	        String token=jwtTokenProvider.createToken(member.getId(), member.getName());
	        String user_name=member.getName();
	        String user_id=member.getId();
	        Auth auth=new Auth(token,user_id,user_name);
	        
	        //그냥 리액트로 넘기고 싶으면 json형태로 바꿔서 리턴해줘야 함!(Gson활용)
	        
	        String result = gson.toJson(auth);
	        System.out.println(result);
	        return result;
	    }

	    //토큰이 가지고 있는 값에 따라 권한 확인할 수 있음
	    @GetMapping("/user/test")
	    public Map ResponseTest() {
	        Map<String, String> result = new HashMap<>();
	        result.put("result","user ok");
	        return result;
	    }
	    
	    @GetMapping("/admin/test")
	    public Map adminResponseTest() {
	        Map<String, String> result = new HashMap<>();
	        result.put("result","admin ok");
	        return result;
	    }


}



