package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.conmmand.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("xxx") //bean의 id를 xxx로 생성
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("aaa")
	ScoreDAO scoreDao;
	
	@Override
	public void regist(ScoreVO vo) {
		
		System.out.println("서비스 실행됨");
		scoreDao.regist(vo);
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		return scoreDao.getList();
	}

	@Override
	public void delete(int num) {
		scoreDao.delete(num);
		
	}

}
