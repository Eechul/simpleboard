package com.javalec.spring_mybatis.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javalec.spring_mybatis.dto.CommentDto;
import com.javalec.spring_mybatis.dto.ContentDto;
import com.javalec.spring_mybatis.dto.FileInfoDto;

public class ContentDao implements IDao{

	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public ContentDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<ContentDto> listDao() {
		System.out.println("listDao()");
		return null;
	}
	
	
	@Override
	public int boardWriteDao(ContentDto contentDto) {
		System.out.println("writeDao()");
		return 0;
		
	}

	
	@Override
	public ContentDto contentViewDao(String strID) {
		System.out.println("viewDao()");
		return null;
	}

	
	@Override
	public void deleteDao(final String bId) {
		System.out.println("deleteDao()");
	}


	@Override
	public void HitUp(String bId) {
		System.out.println("HitUp()");
	}

	@Override
	public ArrayList<ContentDto> searchListDao(String searchType, String searchStr) {
		System.out.println("searchListDao()");
		return null;
	}

	@Override
	public void modifyDao(ContentDto contentDto) {
		System.out.println("modifyDao()");
		
	}

	@Override
	public void insertFileInfoDao(FileInfoDto FileInfoDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commentWriteDao(String bId, String cmPassword, String cmName,
			String cmContent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CommentDto> commentViewDao(String bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commentReplyWriteDao(CommentDto commentDto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void commentReplyUpdateDao(CommentDto commentDto) {
		
	}

	@Override
	public int commentReplyFlagDao(int cmGroup, int cmStep, int cmIntent) {
		return 0;
		
	}




}
