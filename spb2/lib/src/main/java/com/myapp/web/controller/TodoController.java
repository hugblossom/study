package com.myapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.web.annotation.LoginCheck;
import com.myapp.web.domain.Todo;
import com.myapp.web.dto.TodoDeleteDTO;
import com.myapp.web.dto.TodoInsertDTO;
import com.myapp.web.dto.TodoUpdateDTO;
import com.myapp.web.mapper.TodoImpl;
import com.myapp.web.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoImpl todoMapper;
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/list")
	@LoginCheck
	public String getList(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String session_member_id = (String) session.getAttribute("session_member_id");
		
		List<Todo> todoList = todoMapper.selectAll(session_member_id);
		
		model.addAttribute("todoList", todoList);
		
		return "/todo/list";
	}
	
	@GetMapping("/regist")
	@LoginCheck
	public String getRegist() {
		return "/todo/regist";
	}
	
	@PostMapping("/regist")
	@LoginCheck
	public String postRegist(HttpServletRequest request, @RequestParam("imp") String imp_in, @RequestParam("contents") String contents_in, @RequestParam("d_day") String dDay_in, Model model) {
		String direction = "redirect:/todo/list";
		String resultCode = "0000";
		HttpSession session = request.getSession();
		String session_member_id = (String) session.getAttribute("session_member_id");
		
		try {
			if ( StringUtils.isEmpty(imp_in)) {
				resultCode = "0001";
				throw new RuntimeException("imp is empty");
			}
			
			int imp = Integer.valueOf(imp_in);
			if ( imp != 0 && imp != 1 ) {
				resultCode = "0001";
				throw new RuntimeException("imp is invalid from data");
			}
			
			if ( StringUtils.isEmpty(contents_in) || contents_in.length() > 100 ) {
				resultCode = "0002";
				throw new RuntimeException("contents is invalid form data");
			}
			
			if ( StringUtils.isEmpty(dDay_in) || dDay_in.length() != 8 ) {
				resultCode = "0003";
				throw new RuntimeException("dDay is invalid form data");
			}
			
			TodoInsertDTO dto = TodoInsertDTO.builder()
					.imp(imp)
					.contents(contents_in)
					.id(session_member_id)
					.dDay(dDay_in)
					.build();
			
			int result = todoMapper.insert(dto);
			
			if ( result < 1 ) {
				resultCode = "9999";
				throw new RuntimeException("todo insert failed");
			}
			
		} catch ( Exception e ) {
			model.addAttribute("imp", imp_in);
			model.addAttribute("contents", contents_in);
			model.addAttribute("dDay", dDay_in);
			
			direction = "/todo/regist";
			System.out.println(e.getMessage());
		}
		model.addAttribute("result", resultCode);
		
		return direction;
	}
	
	@PostMapping("/delete")
	@LoginCheck
	public String getDelete(HttpServletRequest request, @RequestParam("uid") int uid, @RequestParam("seq") int seq) {
		String id = (String) request.getSession().getAttribute("session_member_id");
		
		todoService.delete(new TodoDeleteDTO(uid, seq, id));
		
		return "redirect:/todo/list";
	}
	
	@PostMapping("/modify")
	@LoginCheck
	public String postModify(HttpServletRequest request, TodoUpdateDTO dto) {
		String id = (String) request.getSession().getAttribute("session_member_id");
		dto.setId(id);
		
		todoService.update(dto);
		
		return "redirect:/todo/list";
	}
}
