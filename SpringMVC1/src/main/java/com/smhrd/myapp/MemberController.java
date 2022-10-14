package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.Member;

//Model(데이터), View(페이지에 보여줄 것) 반환
@Controller
public class MemberController {
	
	//mysql 쓸 거임~
	
//	MemberMapper memberMapper=new MemberMapper(); => 인터페이스는 객체 생성할 수 없음
	
	//이렇게 인터페이스 MemberMapper를 사용할 수 있음
	//Autowired => 의존성 주입(DI) 역할(외부에 생성되어 있는 객체를 사용할 수 있게 함)
	@Autowired
	private MemberMapper memberMapper;
	
	//회원가입
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	//public void join(@RequestParam("id"(인풋태그에 지정해준 네임값 적어주면 됨))String id) =>RequestParam: 하나하나 가져올 때
	public String join(@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("nick")String nick) {
		
		//요청이 들어오면 id,pw,nick을 member 타입으로 묶어줌 => 묶어서 member에 넣어줌 => mybatis는 묶어서 보내고 묶어서 가져오기 때문에~
		
		Member member=new Member(id,pw,nick);//우리가 만든 Member import
		memberMapper.joinMember(member);
		
		return "main";
		
//		System.out.println(id+","+pw+","+nick);
	}
	
	//로그인
	//ModelAttribute: 오브젝트로 파라미터값들을 받아줄 때(한 번에 받아올 때), 어떤 타입으로 묶어서 받을 건지 지정해주기!(ex Member member) => DB의 테이블, 컬럼 이름과 일치시켜주면 편함
	//5버전부터 사용가능 => Post방식으로 가져올 때
	@PostMapping("/member/login")
	public String login(@ModelAttribute Member member, HttpSession session) {
//		System.out.println(member.getId());
		Member loginM=memberMapper.loginMember(member);
		session.setAttribute("loginM", loginM);
		return "main";
	}
	
	//로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		//return "main"; 으로 하면 메인 페이지가 보이지만 주소창이 http://localhost:8087/myapp/member/logout 이렇게 뜸
		return "redirect:/main";
	}

	//회원정보수정
	@PostMapping("/member/update")
	public String update(@ModelAttribute Member member, HttpSession session) {
		memberMapper.updateMember(member);
		session.setAttribute("loginM", member);
		return "main";
	}
	
	
	//Model: 컨트롤러에서 생성한 데이터를 담아서 뷰로 전달할 때 사용하는 객체,request랑 비슷한 역할
	//전체회원정보조회
	@GetMapping("/member/select")
	public String select(Model model) {
		List<Member> memberList=memberMapper.selectAllMember();
		model.addAttribute("memberList", memberList);//model객체에 데이터 저장
		return "select";
	}
	
	//admin계정에서 특정 계정 삭제하기
	//delete()작성
		//쿼리스트링으로 보내준 id 값 받기
		//mapper interface: deleteMember() 호출
		//전체 회원 조회 페이지로 이동 -> 삭제한 회원이 보이지 않게!
	@GetMapping("/member/delete")
	public String delete(@RequestParam("id")String id) {
		memberMapper.deleteMember(id);
		
		return "redirect:select";
	}
	
	//내 코드
//	public String delete(Member member) {
//		memberMapper.deleteMember(member);
//		
//		return "redirect:select";
//	}
	
	
	
}
