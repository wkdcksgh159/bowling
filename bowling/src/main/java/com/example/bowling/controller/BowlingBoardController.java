package com.example.bowling.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.service.BowlingBoardService;
import com.example.bowling.vo.Board;

@RestController
public class BowlingBoardController {
	@Autowired
	private BowlingBoardService bowlingBoardService;

	 // 댓글
	 
//	 @GetMapping("/modifyBoard")
//	 public String modify(Model model, @RequestParam("boardNo")int boardNo) {
//		 System.out.println("get selectBoard controller---------------------------");
//		 //Board board = bowlingBoardService.selectBoard(boardNo);
//		 model.addAttribute("board", board); 
//	 return "modifyBoard"; }
//	 
	 @PostMapping("/updateBoard")
	 public int updateBoard(Board board) {
		 System.out.println("post selectBoard controller-----------------------------");
		 System.out.println("Board: "+board);
		 return bowlingBoardService.updateBoard(board); 
	 }
	 
	 // removeBoard
	 
	 @GetMapping("/removeBoard")
	 public String removeBoard(@RequestParam("boardNo")int boardNo) { 
		 System.out.println("get remove controller---------------------------------------------"); 
		 return "removeBoard"; 
	}
	 
	 @PostMapping("/removeBoard") 
	 public int removeBoard(Board board) {
	 System.out.println("post remove controller-------------------------------------------");
	 int row = bowlingBoardService.removeBoard(board); 
	 return row; 
	 }

	
	// getboard
	@PostMapping("/getBoardOne")
	public Board getBoard(Board board) {
		System.out.println("post getBoard controller---------------------------------------------");
		System.out.println("boardNo"+board.getBoardNo());
		return bowlingBoardService.selectBoard(board);
	}
	//list
	@PostMapping("/selectBoardList")
	public List<Board> gettListOrder() {
		System.out.println("controller list");
		List<Board> list = bowlingBoardService.selectBoardList();
		System.out.println("Controller List: "+list);
		return list;
	}
	
	  // addboard
	  
	 @PostMapping("/addBoard")
	 public int boardAdd(Board board) {
		 System.out.println(board);
		 int row = bowlingBoardService.addBoard(board);
		 System.out.printf("BoardController.boardAdd : %d 행 입력성공", row);
		 return row; 
	 }
	 
}
