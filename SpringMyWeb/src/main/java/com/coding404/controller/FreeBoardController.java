package com.coding404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.service.FreeBoardService;

@Controller //컴포넌트 스캔
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeBoardService")
	FreeBoardService freeBoardService;
	
	//화면처리
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		
		return "freeBoard/freeRegist";
	}
	
	//화면처리(목록)
	@RequestMapping("/freeList")
	public String freeList(Model model) {
		
		//데이터를 가지고나감
		ArrayList<FreeBoardVO> list = freeBoardService.getList();
		model.addAttribute("list", list);
		
		return "freeBoard/freeList";
	}
	
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		
//		/*
//		 * bno키를 받아서 getContent()호출
//		 * 마이바티스에서 bno에 대한 결과를 조외해서 vo에저장(화면에 vo전달)
//		 * 화면에서는 결과값을 띄워주면 됨
//		 */
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno, Model model) {
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeModify";
//	}
	
	//화면처리(상세,변경) 기능이 같다면 합쳐서 사용이 가능
	@RequestMapping({"/freeDetail", "/freeModify"})
	public void getContent(@RequestParam("bno") int bno, Model model) {
		
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);
		
	}
	
	
	
	//등록폼
	@RequestMapping(value = "/registForm",method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		int result = freeBoardService.regist(vo);
		
		//result는 성공 실패 결과
		if(result == 1) {
			RA.addFlashAttribute("msg","게시글이 등록되었습니다");
		} else {
			RA.addFlashAttribute("msg","게시글 등록에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList"; //리다이렉트
	}
	
	//수정폼
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	public String updateForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		/*
		 * 1. 화면에서 넘어오는 데이터를 받습니다. VO
		 * 2. update(vo) 메서드를 통해서 업데이트 작업을 수행
		 * 3. 성공실패 결과 받아서 성공시 성공메세지와 함께 list화면으로 리다이렉트
		 * 	    실패시 실패메세지와 함께 list화면으로 리다이렉트	
		 */
		
		int result = freeBoardService.update(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "글이 수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "글 수정에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList";
		//return "redirect:/freeBoard/freeDetail?bno="+vo.getBno();
	}
	
	@RequestMapping(value = "/deleteForm", method = RequestMethod.POST)
	public String deleteForm(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		/*
		 * 1. bno로 삭제를 진행합니다.
		 * 2. 삭제성공시는 성공메세지와 함께 list화면으로 리다이렉트
		 * 	   삭제실패시는 실패메세지와 함께 modify화면으로 리다이렉트
		 */
		
		int result = freeBoardService.delete(bno);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "글이 삭제되었습니다");
			return "redirect:/freeBoard/freeList";
		} else {
			RA.addFlashAttribute("msg", "글 삭제에 실패했습니다");
			return "redirect:/freeBoard/freeModify";
		}
		
	}
	
	
	
	
	
	
}
