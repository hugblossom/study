package com.proc;

import java.util.List;

import com.vo.Member;

public class MemberProc {

	public String print(List<Member> memberList) {
		String result = "";
		
		for(int i = 0; i < memberList.size(); i++) {
			result += memberList.get(i).getId() + " / " + memberList.get(i).getEmail() + "<br />";
		}
		
		return result;
	}
}
