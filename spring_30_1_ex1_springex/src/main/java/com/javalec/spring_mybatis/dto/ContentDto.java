package com.javalec.spring_mybatis.dto;

import java.sql.Timestamp;

public class ContentDto extends CommentDto{

	private String bId;
	private String bName;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private int bHit;
	
	
	public ContentDto() {
		// TODO Auto-generated constructor stub
		
	}
	

	public String getbId() {
		return bId;
	}

	

	public void setbId(String bId) {
		this.bId = bId;
	}



	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

//	public int getbGroup() {
//		return bGroup;
//	}
//
//	public void setbGroup(int bGroup) {
//		this.bGroup = bGroup;
//	}
//
//	public int getbStep() {
//		return bStep;
//	}
//
//	public void setbStep(int bStep) {
//		this.bStep = bStep;
//	}
//
//	public int getbIndent() {
//		return bIndent;
//	}
//
//	public void setbIndent(int bIndent) {
//		this.bIndent = bIndent;
//	}
//
//
//	public MultipartFile getbFile() {
//		return bFile;
//	}
//
//
//	public void setbFile(MultipartFile bFile) {
//		this.bFile = bFile;
//	}
//	
//	
}
