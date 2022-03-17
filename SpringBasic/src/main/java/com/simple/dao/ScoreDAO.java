package com.simple.dao;

import java.util.ArrayList;

import com.simple.conmmand.ScoreVO;

public interface ScoreDAO {

	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList(); 
	public void delete(int num);
	
}
