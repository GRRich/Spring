package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService") //컴포넌트 스캔 확인한다.
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAO")
	BoardDAO boardDAO;

	@Override
	public void boardRegist(BoardVO vo) {
	
		boardDAO.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return boardDAO.getList();
	}

	@Override
	public void boardDelete(int num) {
		
		boardDAO.boardDelete(num);
	}

}
