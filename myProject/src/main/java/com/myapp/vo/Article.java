package com.myapp.vo;

public class Article {
	private int idx;
	private String title;
	private String contents;
	private String writer;
	private String date;
	
	public Article() {};
	
	public Article(int idx, String title, String writer, String date) {
		super();
		this.idx = idx;
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public Article(int idx, String title, String contents, String writer, String date) {
		super();
		this.idx = idx;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.date = date;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
