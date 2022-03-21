package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.command.ScoreVO;
import com.simple.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class) //스프링과 JUnit의 테스트환경을 잡아준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //root-context를 스프링 설정파일로 참조
public class MybatisBasic {

	@Autowired
	TestMapper testMapper;
	
//	@Test
//	public void test() {
//		
//		String result = testMapper.getTime();
//		System.out.println(result);
//	}
	
//	@Test
//	public void test2() {
//		ArrayList<ScoreVO> list = testMapper.getScore();
//		System.out.println(list.toString());
//	}
	
	//insert방법
//	@Test
//	public void insertOne() {
//		
//		//단일값 - 
//		int result = testMapper.insertOne("홍자자");
//		System.out.println("성공실패결과:" + result );
//		
//	}
	
	//insert 방법 - 다중값(vo나 맵)
//	@Test
//	public void insertTwo() {
//		
//		ScoreVO vo = new ScoreVO(0, "신사임", 99, 98, 97);
//		
//		int result = testMapper.insertTwo(vo);
//		System.out.println("성공실패결과:" + result);
//		
//	}
	
//	@Test
//	public void insertThree() {
//		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("name", "홍길공");
//		map.put("kor", "70");
//		map.put("eng", "80");
//		map.put("math", "90");
//		
//		int result = testMapper.insertThree(map);
//		System.out.println("성공실패결과:" + result);
//		
//	}
	
//	@Test
//	public void insertFour() {
//		
//		int result = testMapper.insertFour("홍길송", 99);
//		System.out.println("성공실패결과:" + result);
//		
//	}
	
	//select방법
//	@Test
//	public void selectOne() {
//		
//		ScoreVO vo = testMapper.selectOne(10);
//		System.out.println(vo.toString());
//		
//	}
	
	//select방법 - map을 통한 단일조회
//	@Test
//	public void selectTwo() {
//		
//		HashMap<String, Object> map = testMapper.selectTwo(9);
//		System.out.println(map.toString());
//		
//	}
	
	//select방법 - map을 통한 다중조회
//	@Test
//	public void selectThree() {
//		ArrayList<HashMap<String, Object>> list = testMapper.selectThree();
//		System.out.println(list.toString());
//	}
	
	//update실습 - vo통해 전달하고 #번 게시글 업데이트하고 성공실패 결과반환
//	@Test
//	public void updateOne() {
//		
//		ScoreVO vo = new ScoreVO(10, "haru", 90, 80, 80);
//		boolean result = testMapper.updateOne(vo);
//		
//		System.out.println("성공실패결과:" + result);
//		
//	}
	
	//delete실습 - 키값을 전달해서 삭제하고 성공실패 반환
	@Test
	public void deleteOne() {
		
		boolean result = testMapper.deleteOne(9);
		System.out.println("성공실패결과:" + result);
		
	}
	
	
	
	
	
	
	
	
}
