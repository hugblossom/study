package com.myapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.service.MemberService;
import com.myapp.vo.Member;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberJoinServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/member/join.jsp");
		rd.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nick = request.getParameter("nick");
		String passwd = request.getParameter("passwd");
		String passwdConfirm = request.getParameter("passwd_confirm");
		String email = request.getParameter("email");
		
		String result = "";
				
		Member member = Member.builder().id(id).nick(nick).passwd(passwd).passwdConfirm(passwdConfirm).email(email).build();
		
		if ( !member.validate() ) {
			result = "0001"; //검증실패
		} else {
			MemberService service = new MemberService();
			if ( service.registMember(member) ) {
				result = "0000";
			} else {
				result = "0002"; //등록실패
			}
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/member/join");
		rd.forward(request, response);
		
	}

}
