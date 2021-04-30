package com.artlier.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pagination {

	int totalCount = 0;
	int articleLimit = 0;
	int pageLimit = 0;
	int pageTotalLimit = 0;
	int thisPage = 1;
	int thisPageSet = 0;
	int pageSetMin = 0;
	int pageSetMax = 0;
	
	String uri= "";
	
	public Pagination(int totalCount, int articleLimit, int pageLimit, int thisPage, String uri) {
		this.totalCount = totalCount;
		this.articleLimit = articleLimit;
		this.pageLimit = pageLimit;
		this.thisPage = thisPage;
		this.uri = uri;
		
		getThisPageSet();
		getPageSetMin();
		getPageSetMax();
		getPageTotalLimit();
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
	
	public void getThisPageSet() {
		
		this.thisPageSet = (int) Math.floor(this.thisPage/ this.pageLimit);
			
	}
	
	public int getPageSetMin() {
		
		int pageSetMin = this.thisPageSet * this.pageLimit + 1;
		
		this.pageSetMin = pageSetMin;
		
		return pageSetMin;
	}
	
	public int getPageSetMax() {
		
		int pageSetMax = (this.thisPageSet + 1) * this.pageLimit;

		this.pageSetMax = pageSetMax;
		
		return pageSetMax;
	}
	
	public int getPageTotalLimit() {
		int pageTotalLimit = 0;
		int temp = (int) Math.ceil(this.totalCount / this.articleLimit);
		
		if ( temp == 0 ) {
			pageTotalLimit = 1;
		} else {
			pageTotalLimit = temp;
		}
				
		this.pageTotalLimit = pageTotalLimit;
		
		return pageTotalLimit;
	}
	
	public int getPageMin() {
		
		int pageMin = (this.thisPage - 1) * this.articleLimit;
		
		return pageMin;
	}
	
	public int getPageMax() {
		
		int pageMax = (this.thisPage * this.articleLimit) + 1;
		
		return pageMax;
	}
	
	public String buildPagination() {
		
		List<String> pageList = new ArrayList<>();
		System.out.println(pageSetMin);
		System.out.println(pageSetMax);
		System.out.println(pageTotalLimit);
		for ( int i = this.pageSetMin; i < this.pageSetMax; i++ ) {

			if ( i <= getPageTotalLimit() ) {
				
				String temp = "<a href='/board/common/list?page=" + i + "'>" + i + "</a>";
			
				pageList.add(temp);
			}
		}
		
		String result = Arrays.toString(pageList.toArray()).replace("[","").replace("]","");
		
		return result;
	}
	
	
}
