package com.myapp.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.web.domain.Member;
import com.myapp.web.dto.MemberInsertDTO;
import com.myapp.web.mapper.MemberImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberImpl memberMapper;
	
	@GetMapping("/join")
	public String getJoin() {
		return "/member/join";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String postLogin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String direction = "/member/login";
		Map<String, String> memberMap = new HashMap<>();
		
		try {
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			memberMap.put("id", id);
			memberMap.put("passwd", passwd);
			
			Member member = memberMapper.selectByIdAndPassword(memberMap);
			
			if ( member == null ) {
				throw new RuntimeException("member is not found");
			}
			
			direction = "/todo/list";
			session.setAttribute("session_member_id", member.getId());
			session.setAttribute("session_member_nick", member.getNick());
			session.setAttribute("session_member_email", member.getEmail());
			
		} catch ( Exception e ) {
			System.out.println( e.getMessage() );
			session.removeAttribute("session_member_id");
			session.removeAttribute("session_member_nick");
			session.removeAttribute("session_member_email");
			model.addAttribute("result", "0001");
		}
		
		return "redirect:" + direction;
	}
	
	@PostMapping("/join")
	public String postJoin(MemberInsertDTO dto, Model model) {
		int result = memberMapper.insert(dto);
		
		if ( result > 0 ) {
			model.addAttribute("result", "0000");
		} else {
			model.addAttribute("result", "0001");
		}
		
		return "redirect:/member/join";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Member> memberList = memberMapper.selectAll();
		
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
		
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("session_member_id");
		session.removeAttribute("session_member_nick");
		session.removeAttribute("session_member_email");
		
		return "/";
	}
	
	@GetMapping("/mypage")
	public String getMypage(HttpServletRequest request) {
		return "/member/mypage";
	}
	
	@PostMapping("/mypage")
	public String postMypage(HttpServletRequest request) {
		return "redirect:/member/mypage";
	}
}
