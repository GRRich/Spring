package com.simple.conmmand;

public class BoardVO {
	
	private String num;
	private String name;
	private String title;
	private String content;
	private String ps;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(String num, String name, String title, String content, String ps) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.content = content;
		this.ps = ps;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}
	
	
	

}
