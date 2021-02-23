package com.myapp.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.myapp.domain.Member;
import com.myapp.service.MemberService;

@WebServlet("/api/v1/members/*")
public class MemberApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberApiServlet() { super(); }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String key =  uri.substring(path.length() + "/api/v1/".length());
		String[] cmds = key.split("/");
		PrintWriter out = response.getWriter();
		String result = "null";
		
		MemberService service = new MemberService();

		
		try {
			
			if ( cmds.length < 2 ) {
				
				List<Member> memberList = service.getMemberList();
				JSONArray jArray = new JSONArray();
				
				for ( Member member : memberList ) {
					JSONObject jObj = new JSONObject();
					
					jObj.put("mem_idx", member.getMem_idx());
					jObj.put("mem_id", member.getMem_id());
					jObj.put("mem_nick", member.getMem_nick());
					jObj.put("mem_email", member.getMem_email());
					jObj.put("mem_st", member.getMem_st());
					jObj.put("mem_auth", member.getMem_auth());
					jObj.put("reg_date", member.getReg_date());
					jObj.put("mod_date", member.getMod_date());
					
					jArray.add(jObj);
				}
				
				result = jArray.toJSONString();
				
			}
			
			
			
			if ( cmds.length == 2 ) {
				int mem_idx = Integer.valueOf(cmds[1]);
				
				Member member = service.getMemberByIdx(mem_idx);
				
				JSONObject jObj = new JSONObject();
				
				jObj.put("mem_idx", member.getMem_idx());
				jObj.put("mem_id", member.getMem_id());
				jObj.put("mem_nick", member.getMem_nick());
				jObj.put("mem_email", member.getMem_email());
				jObj.put("mem_st", member.getMem_st());
				jObj.put("mem_auth", member.getMem_auth());
				jObj.put("reg_date", member.getReg_date());
				jObj.put("mod_date", member.getMod_date());
				
				result = jObj.toJSONString();
			}
		} catch ( Exception e ) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			out.print(result);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
