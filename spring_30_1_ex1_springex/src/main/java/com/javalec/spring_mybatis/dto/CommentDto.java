package com.javalec.spring_mybatis.dto;

import java.sql.Timestamp;

public class CommentDto {

	private String cmId;
	private String bId;
	private String cmPassword;
	private String cmName;
	private String cmContent;
	private Timestamp cmDate;
	private int cmGroup;
	private int cmStep;
	private int cmLevel;
	private	int cmIndent;
	
	public int getCmLevel() {
		return cmLevel;
	}

	public void setCmLevel(int cmLevel) {
		this.cmLevel = cmLevel;
	}

	public CommentDto() {
		/*System.out.println(cmId);
		System.out.println(bId);
		System.out.println(cmPassword);
		System.out.println(cmName);
		System.out.println(cmContent);
		System.out.println(cmDate);
		System.out.println(cmGroup);
		System.out.println(cmStep);
		System.out.println(cmIndent);*/
	}

	public String getCmId() {
		return cmId;
	}

	public void setCmId(String cmId) {
		this.cmId = cmId;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getCmPassword() {
		return cmPassword;
	}

	public void setCmPassword(String cmPassword) {
		this.cmPassword = cmPassword;
	}

	public String getCmName() {
		return cmName;
	}

	public void setCmName(String cmName) {
		this.cmName = cmName;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public Timestamp getCmDate() {
		return cmDate;
	}

	public void setCmDate(Timestamp cmDate) {
		this.cmDate = cmDate;
	}

	public int getCmGroup() {
		return cmGroup;
	}

	public void setCmGroup(int cmGroup) {
		this.cmGroup = cmGroup;
	}

	public int getCmStep() {
		return cmStep;
	}

	public void setCmStep(int cmStep) {
		this.cmStep = cmStep;
	}

	public int getCmIndent() {
		return cmIndent;
	}

	public void setCmIndent(int cmIndent) {
		this.cmIndent = cmIndent;
	}

	
	
	
}
