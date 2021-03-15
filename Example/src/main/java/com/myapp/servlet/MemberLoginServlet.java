package com.myapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myapp.service.MemberLoginService;
import com.myapp.service.MemberService;
import com.myapp.vo.Member;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberLoginServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = "";
		
		if ( "GET".equalsIgnoreCase(request.getMethod())) {
			destination = "/views/member/login.jsp";
		}
		
		if ( "POST".equalsIgnoreCase(request.getMethod())) {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
						
			Member member = Member.builder().id(id).passwd(passwd).build();
			
			HttpSession session = request.getSession();
			
			try {
				MemberLoginService service = new MemberLoginService();
				Member result = service.login(member);
				
				session.setAttribute("session_mem_uid", result.getUid());
				session.setAttribute("session_mem_id", result.getId());
				session.setAttribute("session_mem_nick", result.getNick());
				session.setAttribute("session_mem_email", result.getEmail());
				session.setAttribute("session_mem_exp", result.getExp());
				session.setAttribute("session_mem_lv", result.getLv());
				session.setAttribute("session_mem_pt", result.getPt());
				session.setAttribute("session_mem_cash", result.getCash());
			} catch (Exception e) {
				session.invalidate(); // session이 갈아엎어짐
			}
			
			destination = "/main";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destination);
		rd.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
			
	}

}
