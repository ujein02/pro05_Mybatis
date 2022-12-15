package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findAll();
	public BoardDTO getBoard(long id);
	public void addBoard(BoardDTO board);
	public void updateBoard(BoardDTO board);
	public void delBoard(long id);
}
