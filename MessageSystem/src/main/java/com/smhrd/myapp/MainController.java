package com.smhrd.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smhrd.common.Criteria;
import com.smhrd.common.Page;
import com.smhrd.model.WebMember;
import com.smhrd.model.WebMessage;
import com.smhrd.service.MailService;

@Controller
public class MainController {//경로 이동 다뤄주는 컨트롤러
	
	//메일에 접근해야 하니까 만들어줌
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage(HttpSession sesstion, Model model, Criteria cri) {
		
		
		//로그인 했을 때 메세지 확인할 수 있는 작업을 하기 위해 세션 불러오기
		WebMember loginM=(WebMember)sesstion.getAttribute("loginM");
		
		if(loginM!=null) {
			//paging 전 버전
//			List<WebMessage> messageList=mailService.selectMail(loginM.getEmail());
//			model.addAttribute("messageList", messageList);
				
			//paging 추가 버전
			//고른 페이지에서 보여줘야하는 메세지 리스트
			List<WebMessage> messageList=mailService.selectMailPaging(loginM.getEmail(), cri);
//			System.out.println(messageList.size());
			int total=mailService.countMail(loginM.getEmail());//현재 로그인한 사용자의 메일 토탈
			//paging page 개수 -> Page에서 작업이 됨
			Page page=new Page(cri, total);
			
			model.addAttribute("messageList", messageList);
			model.addAttribute("pagination", page);			
		}
		
		
		return "main";
	}
	
	//업데이트 페이지
	@GetMapping("/update")
	public String updatePage() {
		return "update";
	}
	
//	//전체회원조회
//	@GetMapping("/selectmember")
//	public String selectPage() {
//		return "selectMember";
//	}
	

}
