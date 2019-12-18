package com.example.bowling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.bowling.mapper.BowlingBoardMapper;
import com.example.bowling.vo.Board;
import com.example.bowling.vo.Comment;

@Service
@Repository
public class BowlingBoardServiceImpl implements BowlingBoardService{
	@Autowired
	private BowlingBoardMapper bowlingBoardMapper;
	
	@Override
	public int removeComment(Comment comment) {
		
		return bowlingBoardMapper.deleteComment(comment);
	}
	
	@Override
	public List<Comment> getCommentList(int boardNo) {
		// TODO Auto-generated method stub
		return bowlingBoardMapper.selectCommentList(boardNo);
	}
	
	// 게시판 댓글 추가
	@Override
	public int addComment(Comment comment) {
		System.out.println("Service comment: "+comment);
		int row = bowlingBoardMapper.insertComment(comment);
		return row;
	}
	
	// 상세보기
	@Override
	public Board selectBoard(Board board) {
		System.out.println("selectBoard---------------------------------------");
		System.out.println("boardNo: "+board);
		return bowlingBoardMapper.selectBoard(board);
				
	}
	// 게시물 입력
	@Override
	public int addBoard(Board board) {
		System.out.println("게시판 입력 serviceimpl----------------------------------------");
		return bowlingBoardMapper.insertBoard(board);
	}
	// 게시물 수정
	@Override
	public int updateBoard(Board board) {
		System.out.println("게시글 수정 serviceImpl -------------------------------------------");
		return bowlingBoardMapper.updateBoard(board);
	}
	// 게시글 삭제
	@Override
	public int removeBoard(Board board) {
		System.out.println("게시글 삭제 serviceimpl---------------------------------------------");
		int row = bowlingBoardMapper.deleteBoard(board);
		System.out.println("Remove Row: "+row);
		return row;
	}
	// 게시판 리스트
	@Override
	public List<Board> selectBoardList(){
		System.out.println("리스트 출력 serviceImpl------------------------------------------");
		List<Board> list = bowlingBoardMapper.selectBoardList();
		System.out.println("Service List: "+list);
		return list;
	}

}
