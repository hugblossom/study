package com.myapp.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myapp.web.domain.Todo;
import com.myapp.web.dto.TodoDeleteDTO;
import com.myapp.web.dto.TodoInsertDTO;
import com.myapp.web.dto.TodoUpdateDTO;

@Repository
public interface TodoImpl {
	int insert(TodoInsertDTO dto);
	
	List<Todo> selectAll(String id);
	Todo selectByUidAndId(Todo todo);
	Todo selectBySeqAndId(Todo todo);
	
	int update(TodoUpdateDTO dto);
	int updateForGt(TodoDeleteDTO dto);
	
	int delete(TodoDeleteDTO dto);
}
