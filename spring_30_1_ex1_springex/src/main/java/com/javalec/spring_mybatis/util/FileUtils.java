package com.javalec.spring_mybatis.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.javalec.spring_mybatis.dto.ContentFileDto;


public class FileUtils {
	private static final String filePath = "D:\\dev\\file\\";
	File file;
	public FileUtils(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		FileInfo(request);
	}
	public ContentFileDto FileInfo(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		MultipartFile multipartFile = request.getFile("bFile");
		
		ContentFileDto fileDto = new ContentFileDto(); 
		String boardId = request.getParameter("bId");
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		originalFileName = multipartFile.getOriginalFilename();
		originalFileExtension = multipartFile.getOriginalFilename().substring(originalFileName.lastIndexOf("."));
		storedFileName = CommonUtils.getRandomString() + originalFileExtension;
		
		file = new File(filePath + storedFileName);
		multipartFile.transferTo(file);
		
		fileDto.setbId(boardId);
		fileDto.setOriginalFname(originalFileName);
		fileDto.setStoredFname(storedFileName);
		fileDto.setfSize(multipartFile.getSize());

		
		return fileDto;
		
	}
}
