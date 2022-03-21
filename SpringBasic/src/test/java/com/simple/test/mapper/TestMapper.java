package com.simple.test.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.simple.command.ScoreVO;

public interface TestMapper {

	public String getTime(); //테스트메서드
	public ArrayList<ScoreVO> getScore(); //테스트메서드
	public int insertOne(String name); //단일값 전달
	public int insertTwo(ScoreVO vo); //다중값 전달
	public int insertThree(HashMap<String, String> map);//다중값 전달
	public int insertFour(@Param("aaa") String name, @Param("bbb") int kor); //다중값전달
	
	public ScoreVO selectOne(int num); //#번 키값을 조회 
	public HashMap<String, Object> selectTwo(int num); //#번 키값을조회
	public ArrayList<HashMap<String, Object>> selectThree(); //map을 통한 다중조회
	
	public boolean updateOne(ScoreVO vo); //업데이트
	public boolean deleteOne(int num); //딜리트
	
}
