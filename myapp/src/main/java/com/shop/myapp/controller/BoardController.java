package com.shop.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.dto.ResponseDTO;
import com.shop.myapp.service.BoardService;

@Controller
@RequestMapping(value = "/board/")
public class BoardController {

    @Autowired
    BoardService boardService;

    //JSON의 ResultCode를 붙여서 보내는 경우
    @ResponseBody	//localhost:8095/board/test
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(boardService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping("test2")	//localhost:8095/board/test2
    public List<BoardDTO> boardTest() {
        return boardService.findAll();
    }
           
    
    @GetMapping("list")	//localhost:8095/board/list
    public String getBoardList(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
    
    @GetMapping("detail")
    public String getBoardDetail(@RequestParam long id, Model model) {
    	BoardDTO board = boardService.getBoard(id);
    	model.addAttribute("board", board);
    	return "board/detail";
    }
    
    @GetMapping("add")
    public String addBoardForm(Model model, BoardDTO board) {
    	model.addAttribute("board", board);
    	return "board/add";
    }
    
    @PostMapping("add")
    public String addBoard(@ModelAttribute("board") BoardDTO board) {
    	board.setWriter("관리자");
    	boardService.addBoard(board);
    	return "redirect:/board/list";
    }

    @GetMapping("update")
    public String updateBoardForm(@RequestParam long id, Model model) {
    	BoardDTO board = boardService.getBoard(id);
    	model.addAttribute("board", board);
    	return "board/update";
    }
    
    @PostMapping("update")
    public String updateBoard(@ModelAttribute("board") BoardDTO board, Model model) {
    	board.setWriter("관리자");
    	boardService.updateBoard(board);
    	return "redirect:/board/list";
    }
    
    @GetMapping("del")
    public String delBoard(@RequestParam long id, Model model) {
    	boardService.delBoard(id);
    	return "redirect:/board/list";
    }
}
