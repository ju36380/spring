package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.Criteria;
import com.example.mapper_oracle.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class) // ���� SpringJUnit4ClassRunner.class
										// import�Ѵ�.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class BoardTest {
	@Autowired
	private BoardMapper mapper;

	@Test
	public void list() {
		Criteria cri = new Criteria();
		cri.setSearchType("content");
		cri.setKeyword("�ٽ�");
		cri.setPerPageNum(20);
		cri.setPage(2);
		mapper.totalCount(cri);
		mapper.list(cri);
	}
	
	@Test
	public void read() {
		mapper.read(7);
	}
}
