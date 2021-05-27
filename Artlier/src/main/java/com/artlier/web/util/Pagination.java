package com.artlier.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pagination {

	String code = "";
	int totalCount = 0;
	int articleLimit = 0;
	int pageLimit = 0;
	int pageTotalLimit = 0;
	int thisPage = 2;
	int thisPageSet = 0;
	int pageSetMin = 0;
	int pageSetMax = 0;
	
	public Pagination(String code, int totalCount, int articleLimit, int pageLimit, int thisPage) {
		this.code = code;
		this.totalCount = totalCount;
		this.articleLimit = articleLimit;
		this.pageLimit = pageLimit;
		this.thisPage = thisPage;
		
		getThisPageSet(thisPage);
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
	
	public int getThisPage() {
		return this.thisPage;
	}
	
	public int getThisPageSet(int thisPage) {
		int temp = (int) Math.floor( (double) thisPage / (this.pageLimit + 1) );
		int thisPageSet = temp + 1;
		this.thisPageSet = thisPageSet;
		
		return thisPageSet;
	}
	
	public int getArticleStart(int page) {
		
		//int articleStart = Math.abs(this.totalCount - page * this.articleLimit);
		int articleStart = Math.abs((page - 1) * this.articleLimit);
		
		return articleStart;
		
	}
	
	public int getPageSetMin() {
		
		int pageSetMin = (this.thisPageSet - 1) * this.pageLimit + 1;
		this.pageSetMin = pageSetMin;
		
		return pageSetMin;
	}
	
	public int getPageSetMax() {
		
		int pageSetMax = this.thisPageSet * this.pageLimit;

		this.pageSetMax = pageSetMax;
		
		return pageSetMax;
	}
	
	public int getPageTotalLimit() {
		int pageTotalLimit = 0;
		int temp = (int) Math.ceil( (double) this.totalCount / this.articleLimit );
		if ( temp == 0 ) {
			pageTotalLimit = 1;
		} else {
			pageTotalLimit = temp;
		}
				
		this.pageTotalLimit = pageTotalLimit;
		
		return pageTotalLimit;
	}
	
	public int getPageMin() {
		
		int pageMin = (this.thisPageSet - 1) * this.articleLimit;
		
		return pageMin;
	}
	
	public int getPageMax() {
		
		int pageMax = this.thisPageSet * this.articleLimit;
		
		return pageMax;
	}
	
	public String buildPagination() {
		
		List<String> pageList = new ArrayList<>();
		int pageTotalLimit = getPageTotalLimit();
		String prev = "";
		String resultList = "";
		String next = "";
		String result = "";
		
		for ( int i = this.pageSetMin; i <= this.pageSetMax; i++ ) {

			if ( i <= pageTotalLimit ) {
				
				String temp = "";
				
				if ( i == this.thisPage ) {
					temp = "<a href='/board/common/list?code=" + this.code + "&page=" + i + "' class='on'>" + i + "</a>";
				} else {
					temp = "<a href='/board/common/list?code=" + this.code + "&page=" + i + "'>" + i + "</a>";
				}
				pageList.add(temp);
				resultList = Arrays.toString(pageList.toArray()).replace("[","").replace("]","").replace(",","");
			}
		}
		
		if ( this.thisPage > 1 && this.thisPageSet > 1 ) {
			
			prev = "<a href='/board/common/list?code=" + this.code + "&page=1'>처음</a>";
			
		}
		
		if ( this.thisPageSet > 1 ) {
			
			prev += "<a href='/board/common/list?code=" + this.code + "&page=" + ( (this.thisPageSet - 1) * this.pageLimit) + "'>이전</a>";
			
		}
		
		if ( pageTotalLimit > this.thisPageSet * this.pageLimit ) {
			
			next = "<a href='/board/common/list?code=" + this.code + "&page=" + (this.thisPageSet * this.pageLimit + 1) + "'>다음</a>";
			
		}
		
		if ( this.thisPage < pageTotalLimit && this.thisPageSet <= pageTotalLimit / this.pageLimit ) {
			
			next += "<a href='/board/common/list?code=" + this.code + "&page=" + pageTotalLimit + "'>마지막</a>";
		}
		
		result = prev + resultList + next;
		
		return result;
	}
	
	
}
