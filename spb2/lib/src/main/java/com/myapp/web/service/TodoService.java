package com.myapp.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.web.domain.Todo;
import com.myapp.web.dto.TodoDeleteDTO;
import com.myapp.web.mapper.TodoImpl;

@Service
public class TodoService {
	
	@Autowired
	private TodoImpl todoMapper;
	
	@Transactional
	public int delete(TodoDeleteDTO dto) {
		int result = 0;
		
		try {
			result += todoMapper.delete(dto); //삭제 실행
			result += todoMapper.updateForGt(dto); // 업데이트 실행
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return result;
	}
	
	public int updateOrder(Todo todo_in) {
		int result = 0;
		
		
		
		return result;
	}
	
}
