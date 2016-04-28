package com.javalec.spring_mybatis.dao;

import java.util.ArrayList;

import com.javalec.spring_mybatis.dto.CommentDto;
import com.javalec.spring_mybatis.dto.ContentDto;
import com.javalec.spring_mybatis.dto.ContentFileDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public ArrayList<ContentDto> searchListDao(String searchType, String searchStr);
	
	public void boardWriteDao(String bName, String bTitle, String bContent);
	public void commentWriteDao(String bId, String cmPassword, String cmName, String cmContent);
	
	public void fileDao(ContentFileDto contentFileDto);
	
	public ContentDto contentViewDao(String bId);
	public ArrayList<CommentDto> commentViewDao(String bId);
	
	public void HitUp(String bId);
	
	public void deleteDao(String bId);
	
	public void modifyDao(ContentDto contentDto);
	
	public void commentReplyWriteDao(CommentDto commentDto);

	public void commentReplyUpdateDao(int cmGroup, int cmStep);
}
