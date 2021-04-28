package com.artlier.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artlier.web.domain.Member;
import com.artlier.web.dto.JoinDTO;
import com.artlier.web.dto.LoginDTO;
import com.artlier.web.dto.LoginHistoryDTO;
import com.artlier.web.mapper.MemberMapper;
import com.artlier.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@GetMapping("/list")
	public String getList(Model model) {
		
		List<Member> memberList = memberService.memberList();
		
		model.addAttribute("memberList", memberList);
	
		return "/member/list";
	}
	
	@GetMapping("/join")
	public String getJoin() {
		
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String postJoin(JoinDTO dto, Model model) {
		
		memberService.memberJoin(dto);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String postLogin(LoginDTO dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String ip		= request.getRemoteAddr();
		String id		= dto.getId();
		String pw		= dto.getPw();
		String rsMsg	= "로그인 성공";
		int result		= 0;
		Member member	= null;
		LoginHistoryDTO ldto = null;
		
		String direction = "redirect:/";
		
		try {
			// 아이디 null check
			if ( !StringUtils.hasText(id) ) {
				rsMsg = "아이디 입력 안함";
				throw new RuntimeException("아이디 입력 안함");
			}
			
			// 패스워드 null check
			if ( !StringUtils.hasText(pw) ) {
				rsMsg = "패스워드 입력 안함";
				throw new RuntimeException("패스워드 입력 안함");
			}
			
			// 아이디가 존재하는지
			int cnt = memberMapper.idExist(dto.getId());
			
			if (cnt != 1) {
				rsMsg = "가입한 아이디가 아님";
				throw new RuntimeException("가입한 아이디가 아님");
			}
			
			// 로그인 시도
			member = memberMapper.memberLogin(dto);
			
			if (member == null) {
				rsMsg = "패스워드 불일치";
				throw new RuntimeException("패스워드 불일치");
			}

			result	= 1;
			session.setAttribute("member_id", member.getId());
			session.setAttribute("member_nick", member.getNick());
			
			String returnTarget = (String) session.getAttribute("return_target");
			
			
			if ( StringUtils.hasText(returnTarget) ) {
				direction = "redirect:" + returnTarget;
				
				session.removeAttribute("return_target");
			}
			
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 히스토리 남김
		if ( !ObjectUtils.isEmpty(member) ) {
			ldto  = LoginHistoryDTO.builder().uid(member.getUid()).id(member.getId()).succeed(result).ip(ip).build();
		} else {
			ldto  = LoginHistoryDTO.builder().uid(0).id(dto.getId()).succeed(result).ip(ip).build();
		}
		
		
		try {
			if ( !ObjectUtils.isEmpty(ldto) ) {
				memberMapper.loginHistory(ldto);
			}
		} catch ( SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return direction;
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("member_id");
		session.removeAttribute("member_nick");
		
		return "redirect:/";
	}
}
