package com.myapp.web.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.web.dto.TodoInsertDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoMapperTest {

	@Autowired
	private TodoImpl mapper;
	
	@Test
	public void 투두가삽입되었으면해() {
		//given
		TodoInsertDTO dto = TodoInsertDTO
				.builder()
				.imp(1)
				.contents("내가 할 일")
				.id("stephy")
				.dDay("20210405")
				.build();
		//when
		int result = mapper.insert(dto);
		
		//then
		Assert.assertEquals(1, result);
	}
	
}
