package com.smhrd.myapp;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMessage;
import com.smhrd.service.MailService;


@Controller
public class MailController {
	
	//1. controller 메서드 작성
	//2. mailservice메서드 작성
	//3. mailmapper 메서드 작성 - annotation
	@Autowired
	MailService mailService;
	
	//메일 보내기
	@PostMapping("/mail/sendMail")
	public String sendMail(@ModelAttribute WebMessage webMessage) {
		mailService.sendMail(webMessage);
//		, Model model
//		model.addAttribute("sendM", webMessage);
		
		//mainCon에서 main을 보기 위한 작업을 해놨기 때문에 main으로만 적어줘도 main으로 갈 수 있음
		return "redirect:/main";
	}
		
	
	//특정 메일 삭제
	@GetMapping("/mail/selectDeleteMail/{num}")
	public String selectDeleteMail(@PathVariable("num") int num) {
		mailService.selectDeleteMail(num);
		return "redirect:/main";//메인컨트롤러에 요청을 해서 현재 로그인되어 있는 사용자의 
								//메일 리스트를 불러와야함(메인에 조건문으로 로그인 한 사용자의 메일 리스트를 불러오는 작업이 있음)
	}
	
	//전체 메일 삭제
	@GetMapping("/mail/deleteAllMail")
	public String deleteAllMail(HttpSession session) {
		WebMember loginM=(WebMember)session.getAttribute("loginM");
		mailService.deleteAllMail(loginM.getEmail());
		
		return "redirect:/main";//메인컨트롤러에 요청을 해서 현재 로그인되어 있는 사용자의
								//메일 리스트를 불러와야함(메인에 조건문으로 로그인 한 사용자의 메일 리스트를 불러오는 작업이 있음)
		
	}
	

}
