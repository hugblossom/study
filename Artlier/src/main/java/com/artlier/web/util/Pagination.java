package com.artlier.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pagination {

	int totalCount = 0;
	int articleLimit = 0;
	int pageLimit = 0;
	int thisPage = 1;
	int thisPageSet = 0;
	String uri= "";
	
	public Pagination(int totalCount, int articleLimit, int pageLimit, int thisPage, String uri) {
		this.totalCount = totalCount;
		this.articleLimit = articleLimit;
		this.pageLimit = pageLimit;
		this.thisPage = thisPage;
		this.uri = uri;
	}
	
	public int getTotalCount() {
		return this.totalCount;
	}
	
	public int getArticleLimit() {
		return this.articleLimit;
	}
	
	public int getPageLimit() {
		return this.pageLimit;
	}
	
	public int getThisPage() {
		return this.thisPage;
	}
	
	public int thisPageSet() {
		
		this.thisPageSet = (int) Math.floor(this.thisPage/ this.pageLimit);
			
		return this.thisPageSet;
	}
	
	

	public String buildPagination() {
		
		List<String> pageList = new ArrayList<>();
		String tag = "<a href='" + this.uri + "?page=" + 1;
		
		for ( int i = this.thisPageSet * thisPage + 1; i < this.this )
		
		String result = Arrays.toString(pageList.toArray()).replace("[","").replace("]","");
		
		return result;
	}
	
	
}
