package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

@Service("xxx") //bean의 id를 xxx로 생성
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	ScoreMapper scoreMapper;
	
	@Override
	public void regist(ScoreVO vo) {
		scoreMapper.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}
	
	

//	@Autowired
//	@Qualifier("bbb")
//	ScoreDAO scoreDao;
//		
//	@Override
//	public void regist(ScoreVO vo) {
//		scoreDao.regist(vo);
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		return scoreDao.getList();
//	}
//
//	@Override
//	public void delete(int num) {
//		scoreDao.delete(num);
//		
//	}
	

	
	
}
