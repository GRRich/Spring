package com.simple.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.conmmand.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 bean으로 생성한다.
@RequestMapping("/request")
public class RequestController {
	
//	@RequestMapping("/test")
//	public void test() {
//		
//		System.out.println("실행됨");
//		
//	}
	
	//void형 메서드는 들어오는 경로를 그대로 리졸버뷰에 반환
	@RequestMapping("/ex01")
	public void ex01() {
		
	}
	
	//string형 메서드는 들어가는경로, 나가는경로를 각각 지정합니다.
//	@RequestMapping("/ex01")
//	public String ex01() {
//		return "request/ex01";
//	}
	
	//get요청만 받는다
	@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1번 실행");
	}
	
	//post요청만 받는다
	@RequestMapping(value = "/basic2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2번 실행");
	}
	
	//get,post상관없이 둘다 받아줌
	@RequestMapping("/basic3")
	public void basic3() {
		System.out.println("basic3번 실행");
	}
	
	//동일한 요청을 하나로 매핑할때는 배열{경로...} 로 표기할수있다
//	@RequestMapping(value = {"/basic1", "/basic2", "/basic3"})
//	public void basic4() {
//		System.out.println("basic4번 실행");
//	}
	
	
	//========================파라미터값 처리===================================
	//ex02화면 처리하는 메서드
	
	@RequestMapping("/ex02")
	public String ex02() {
		return "request/ex02";
	}
	
	//폼태그받기
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		String age = request.getParameter("age");
//		String[] inter = request.getParameterValues("inter");
//		
//		System.out.println(id);
//		System.out.println(age);
//		System.out.println( Arrays.toString(inter) );
//		
//		return "request/ex02_result";
//	}
	
	//2nd - requestparam(이름) - 필수값이 넘어와야 함
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id, 
//						@RequestParam("age") int age,
//						@RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> list) {
//		
//		//필수가 아닌 파라미터는 required = false속성을 지정하면됩니다
//		//필수가 아닌 파라미터일 경우 null값을 지정하게되는데 디폴트벨류로 기본값을 지정할수있다.
//		
//		System.out.println(id);
//		System.out.println(age);
//		System.out.println(list);
//		
//		return "request/ex02_result";
//	}
	
	//3nd - 커맨드객체
	@RequestMapping("/param")
	public String param( ReqVO vo ) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		return "request/ex02_result";
	}
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		
		return "request/req_quiz01";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw) {
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "request/req_quiz01_ok";
		} else {
			return "request/req_quiz01_no";
		}
		
	}
	
	
	
	
	

}
