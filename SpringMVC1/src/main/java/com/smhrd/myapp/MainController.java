package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//컨트롤러 지정하는 역할, Model 객체(데이터 저장) 만드는 역할 + View 반환(String)
//spring의 컨트롤러는 골뱅이Controller를 붙여줘야 함!
@Controller
public class MainController {
	
	// '/main'으로 요청이 오면 main페이지를 실행하겠다라는 뜻, method는 get방식 요청이 왔을 때
	//요청과 특정메서드를 맵핑하는 역할!
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainPage() {
		//String으로 어떤 페이지로 이동할 것인지 return에 적어주기
		return "main";
	}
	
	//join페이지
	//5버전 이하일 때 사용 => 골뱅이RequestMapping
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinPage() {
		return "join";
	}
	
	//login페이지
		//5버전부터 사용 가능(스프링 버전을 5로 바꿔줘야 함) =>골뱅이GetMapping
		//get방식으로 가져올 때
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	//회원정보 수정
	@GetMapping("/update")
	public String updatePage() {
		return "update";
	}

	//전체회원정보
	@GetMapping("/select")
	public String selectPage() {
		return "select";
	}
	
	
}
