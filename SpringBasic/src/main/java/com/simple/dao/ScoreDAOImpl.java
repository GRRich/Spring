package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.conmmand.ScoreVO;

@Repository("aaa") //bean의 id를 aaa로 생성
public class ScoreDAOImpl  implements ScoreDAO{
	
	//리스트(데이터베이스 대체)
	ArrayList<ScoreVO> list = new ArrayList<>();

	@Override
	public void regist(ScoreVO vo) {

		list.add(vo);
		System.out.println("DAO영역실행됨");
		//데이터 연결....
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return list;
	}

	@Override
	public void delete(int num) {
		list.remove(num); //삭제
	}

}
