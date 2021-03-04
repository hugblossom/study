package com.myapp.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.myapp.domain.Member;
import com.myapp.service.MemberService;
import com.myapp.util.MyappUtil;

@WebServlet("/api/v1/check/*")
public class CheckApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckApiServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // http://www.example.co.kr/myapp/api/v1/check/method
		String path = request.getContextPath(); // http://www.example.co.kr/myapp
		String cmd = uri.substring(path.length() + "/api/v1/check/".length()); // method
		PrintWriter out = response.getWriter();
		String result = "null"; // 화면에 출력헐 결과

		if ("idDuplicationCheck".equals(cmd)) {
			MemberService service = new MemberService();
			
			try {
				String mem_id = request.getParameter("id");
				Member member = service.selectById(mem_id);
				
				if ( member == null ) {
					result = "true";
				}
				
			} catch ( Exception e ) {
				
			}
			
			out.print(result);
		}
	}

	
}
