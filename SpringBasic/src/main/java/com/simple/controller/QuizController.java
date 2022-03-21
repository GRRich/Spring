package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//화면처리
	@RequestMapping("/quiz01")
	public void quiz01() {
		
	}
	
	//퀴즈1 폼처리
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		
		System.out.println(vo.getYear() + vo.getMonth() + vo.getDay());
		model.addAttribute("birth", vo); //데이터를 담는다.
		
		
		return "quiz/quiz01_ok"; //경로
	}
	
	//화면처리
	@RequestMapping("/quiz02")
	public void quiz02() {
		
	}
	
	//2번 폼요청 처리
	@RequestMapping("/join")
	public String join(@ModelAttribute("vo") Quiz02VO vo) {
		
		return "quiz/quiz02_ok";
	}
	
	
	
	
	
	//화면처리
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	//3번 폼처리
	@RequestMapping("/join2")
	public String join2(@RequestParam(value = "id", required = false, defaultValue = "") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes RA, 
						Model model ) {
		
		if(id.equals("") ) { //아이디를 적지않은 경우
			
			RA.addFlashAttribute("msg", "아이디를 확인하세요");
			return "redirect:/quiz/quiz03"; //리다이렉트이동
			
		} else if( !pw.equals(pw_check) ) { //체크가 다른경우
			
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03"; //리다렉트이동
			
		} else {
			
			model.addAttribute("msg", id + "님 환영합니다");
			return "quiz/quiz03_ok"; //포워드 이동
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
