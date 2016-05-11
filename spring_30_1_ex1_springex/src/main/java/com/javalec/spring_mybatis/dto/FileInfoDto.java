package com.javalec.spring_mybatis.dto;

import java.sql.Timestamp;

public class FileInfoDto {

	private String fNum;
	private String bId;
	private String fOriginal_Name;
	private String fStored_Name;
	private int fSize;
	private Timestamp fDate;


	public FileInfoDto() {

	}

	public String getfNum() {
		return fNum;
	}



	public void setfNum(String fNum) {
		this.fNum = fNum;
	}



	public String getbId() {
		return bId;
	}



	public void setbId(String bId) {
		this.bId = bId;
	}



	public String getfOriginal_Name() {
		return fOriginal_Name;
	}



	public void setfOriginal_Name(String fOriginal_Name) {
		this.fOriginal_Name = fOriginal_Name;
	}



	public String getfStored_Name() {
		return fStored_Name;
	}



	public void setfStored_Name(String fStored_Name) {
		this.fStored_Name = fStored_Name;
	}



	public int getfSize() {
		return fSize;
	}



	public void setfSize(int fSize) {
		this.fSize = fSize;
	}



	public Timestamp getfDate() {
		return fDate;
	}



	public void setfDate(Timestamp fDate) {
		this.fDate = fDate;
	}
	
	
	
	
}
