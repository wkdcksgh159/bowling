package com.example.bowling.service;

import java.util.List;

import com.example.bowling.vo.Comment;
import com.example.bowling.vo.Board;

public interface BowlingBoardService {
	// 상세보기
	public Board selectBoard(Board board);
	// 게시물 입력
	public int addBoard(Board board);
	// 게시물 수정
	public int updateBoard(Board board);
	// 게시글 삭제
	public int removeBoard(Board board);
	// 게시판 리스트
	public List<Board> selectBoardList();
	// 게시판 댓글 추가
	public int addComment(Comment comment);
	// 게시판 댓글 리스트 출력
	public List<Comment> getCommentList(int boardNo);
	// 게시판 댓글 삭제
	public int removeComment(Comment comment);
	
}
