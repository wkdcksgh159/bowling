package com.example.bowling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.bowling.vo.Board;
import com.example.bowling.vo.Comment;

@Mapper
public interface BowlingBoardMapper {
	// 상세보기
	public Board selectBoard(Board board);
	// 입력
	public int insertBoard(Board board);
	// 수정
	public int updateBoard(Board board);
	// 삭제
	public int deleteBoard(Board board);
	// 리스트 페이징
	public List<Board> selectBoardList();
	// 개시판 댓글
	public int insertComment(Comment comment);
	// 댓글 출력
	public List<Comment> selectCommentList(int boardNo);
	// 댓글 삭제
	public int deleteComment(Comment comment);
}
