package com.myapp.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.web.domain.Monster;
import com.myapp.web.dto.MonsterInsertDTO;

@Mapper
public interface MonsterMapper {
	List<Monster> selectAll();
	int insert(MonsterInsertDTO dto);
}
