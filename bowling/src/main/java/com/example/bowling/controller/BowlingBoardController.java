package com.example.bowling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bowling.vo.Comment;
import com.example.bowling.service.BowlingBoardService;
import com.example.bowling.vo.Board;

@RestController
public class BowlingBoardController { 
	@Autowired
	private BowlingBoardService bowlingBoardService;

	//댓글 삭제
	@PostMapping("/removeComment")
	public String removeComment(Comment comment) {
		System.out.println("comment: "+comment);
		int row = bowlingBoardService.removeComment(comment);
		if(row == 0) {
			return "fail";
		}else {
			return "success";
		}
		
	}
	
	// 댓글 목록 출력
	@PostMapping("/getCommentList")
	public List<Comment> getCommentList(@RequestParam(value="boardNo") int boardNo){
		System.out.println("/getCommentList: "+boardNo);
		List<Comment> list = bowlingBoardService.getCommentList(boardNo);
		System.out.println("list: "+list);
		return list;
	}
	
	
	 // 댓글 추가
	@PostMapping("/addComment")
	public String addComment(Comment comment) {
		System.out.println("-----addComment-----");
		System.out.println(comment);
		int row = bowlingBoardService.addComment(comment);
		//service interface 호출
		if(row == 0) {
			return "fail";
		}
		
		return "success";
	}
	 
	 @PostMapping("/updateBoard")
	 public int updateBoard(Board board) {
		 System.out.println("post selectBoard controller-----------------------------");
		 System.out.println("Board: "+board);
		 return bowlingBoardService.updateBoard(board); 
	 }
	 
	 // removeBoard
	 
	 @PostMapping("/removeBoard") 
	 public int removeBoard(Board board) {
	 System.out.println("post remove controller-------------------------------------------");
	 System.out.println("Board: "+board);
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
