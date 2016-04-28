package com.javalec.spring_mybatis.dto;

import java.sql.Timestamp;

public class ContentFileDto {
	
	private String fId;
	private String bId;
	private String originalFname;
	private String storedFname;
	private long fSize;
	private Timestamp fDate;
	
	public ContentFileDto() {
		
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getOriginalFname() {
		return originalFname;
	}

	public void setOriginalFname(String originalFname) {
		this.originalFname = originalFname;
	}

	public String getStoredFname() {
		return storedFname;
	}

	public void setStoredFname(String storedFname) {
		this.storedFname = storedFname;
	}

	public long getfSize() {
		return fSize;
	}

	public void setfSize(long fSize) {
		this.fSize = fSize;
	}

	public Timestamp getfDate() {
		return fDate;
	}

	public void setfDate(Timestamp fDate) {
		this.fDate = fDate;
	}

	
}
