package com.javaex.vo;

public class BoardVo {

	//필드
	private int no;
	private String title;
	private String name;
	private String content;
	private String hit;
	private String regDate;
	private String userNo;
	
	//생성자
	public BoardVo() {}
	
	public BoardVo(int no, String title, String content, String hit, String regDate, String userNo) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
	}

	public BoardVo(int no, String title, String name, String content, String hit, String regDate, String userNo) {
		super();
		this.no = no;
		this.title = title;
		this.name = name;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userNo = userNo;
	}

	//GS

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	//일반
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", name=" + name + ", content=" + content + ", hit=" + hit
				+ ", regDate=" + regDate + ", userNo=" + userNo + "]";
	}
	
}
