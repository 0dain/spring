package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.smhrd.model.WebMember;
import com.smhrd.service.MemberService;

@Controller
public class MemberController {//요청, 응답 기능만 할 거임(view반환)/자바로직이 필요하다면?! service라는 클래스에서 처리할 것
	
	//외부에서 생성된 거 주입
	@Autowired
	MemberService memberService;
	
	//회원가입
	@PostMapping("/member/join")
	public String join(@ModelAttribute WebMember member, Model model) {
		//model에서 받은 데이터 service로 전달
		memberService.joinMember(member);
		model.addAttribute("joinM", member);
		return "joinSuccess";
	}
	
	//로그인
	@PostMapping("/member/login")
	public String login(@ModelAttribute WebMember member, HttpSession session) {
		//서비스에 보낸 정보를 다시 받아와서 loginM에 저장
		WebMember loginM=memberService.loginMember(member);
		//세션에 로그인 정보 저장
		//("키 값", 키에 저장될 데이터)
		session.setAttribute("loginM", loginM);
		return "redirect:/main";
	}
	
	//로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		return "redirect:/main";
	}
	
	//회원정보 수정
	@PostMapping("/member/update")
	public String update(@ModelAttribute WebMember member, HttpSession session) {
//		String email=(String)session.getAttribute(member.getEmail());
		
		//업데이트 페이지에서 넘어오는 값엔 이메일이 비워져 있기 때문에 세션에서 이메일 값을 받아와서 비어있는 이메일 값을 채워 줘야 함
		
		WebMember loginM=(WebMember)session.getAttribute("loginM");
		String email=loginM.getEmail();//현재 로그인한 사용자의 이메일 -> 현재 이 사용자의 정보만 수정
		
		member.setEmail(email);//비어진 email 넣어주기
		
		memberService.updateMember(member);
		
		session.setAttribute("loginM", member);
		
		return "redirect:/main";
	}
	
	
	//전체회원조회
	@GetMapping("/member/selectAllMember")
	public String selectAllMember(Model model) {
		List<WebMember> memberList=memberService.selectAllMember();
		
		//memberList 값을 저장해서 넘겨줘야 함
			//model활용해서 값 저장해서 넘겨주기
		model.addAttribute("memberList", memberList);
		
		return "selectMember";
	}
	
	
	//특정회원삭제
		//{}:계속 변화하는 변수를 나타낼 때(url에 파라미터 값을 받아와야 할 때 사용)
		//{email}: 어떤 값이 들어오는지 안에 key 값 적어주기
	//골뱅이PathVariable("key값"): restAPI에서 URI에 변수가 들어가 있을 때 처리
		//(골뱅이PathVariable("email") String email(앞에서 받아준 값을 담아줄 변수))
	@GetMapping("/member/deleteMember/{email:.+}")
	public String delete(@PathVariable("email") String email) {
		memberService.deleteMember(email);
		return "redirect:/member/selectAllMember";
	}
	
	
	
	
}
