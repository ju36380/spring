package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class) //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BoardTest {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void list() { 
		mapper.list();
	}
	
	@Test
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("게시글을 추가합니다.");
		vo.setContent("추가 내용입니다.");
		vo.setWriter("user07");
		mapper.insert(vo);
	}
	
	@Test
	public void read(){
		mapper.read(8);
	}
	
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setTitle("게시글을 추가합니다. 수정");
		vo.setContent("추가 내용입니다. 수정");
		vo.setWriter("user07");
		vo.setBno(7);
		mapper.update(vo);
	}
	
	@Test
	public void delete(){
		mapper.delete(9);
	}
}
