package com.simple.service;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreService {

	public void regist(ScoreVO vo);	//등록
	public ArrayList<ScoreVO> getList(); //조회
	public void delete(int num); //삭제 
	
	
}
