package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	//화면처리
	@RequestMapping("/ex01")
	public void ex01() {
		
	}
	
	//ex02 - 데이터를 담아 보낸다.
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		
		model.addAttribute("serverTime", new Date()); //(키, 값)
		model.addAttribute("name", "홍길동");
		model.addAttribute("id", "aaa123");
		return "response/ex02";
	}
	
	//ex03 - 모델엔뷰 방식
	@RequestMapping("/ex03")
	public ModelAndView ex03() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("serverTime", new Date()); //데이터 저장
		mv.addObject("name", "이순신");			//데이터 저장
		
		mv.setViewName("response/ex03"); //뷰의 경로
				
		return mv;
	}
	
	//ex04 - 모델어노테이션
	//모델어노테이션은 = 리퀘스트 + 모델
	//다음 화면에 받은 값을 그대로 넘겨줍니다.
	@RequestMapping("/ex04")
	public String ex04(@ModelAttribute("id") String id ) {
		
		System.out.println("화면에서 넘어온값:" + id);
		
		return "response/ex04";
	}
	
	//ex05 - 모델어노테이션 객체 처리
	//VO에 값을 자동맵핑 시키고 info이름으로 데이터를 넘긴다.
	@RequestMapping("/ex05")
	public String ex05(@ModelAttribute("info") ReqVO vo ) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getAge());
		
		return "response/ex05";
	}
	
	//=======================리다이렉트 and 리다이렉트어트리뷰트==========================
	
	//로그인 페이지
	@RequestMapping("/redirect_login")
	public void redirect_login() {
		
	}
	
	//로그인 성공페이지
	@RequestMapping("/redirect_login_ok")
	public void redirect_login_ok() {
		System.out.println("탓어");
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes RA ) {
		
		if(id.equals(pw)) { //로그인 성공이라 가정
			
			//redirect:/절대경로 - 다시 컨트롤러를 타게함.
			//리다이렉트 시에는 모델객체를 사용할 수 없습니다.
			//RA의 객체의 addFlashAttribute는 1회성으로 데이터를 전달할 수 있습니다
			RA.addFlashAttribute("msg", "로그인 성공했습니다");		
			return "redirect:/response/redirect_login_ok"; //성공페이지
		} else {
			
			return "response/redirect_login"; //실패페이지
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
