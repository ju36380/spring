package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class) //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BoardTest {
	@Autowired
	private BoardMapper mapper;
	
	
	@Test
	public void list() {
	//	mapper.totalCount();
	}
	
	@Test
	public void read() {
		mapper.read(7);
	}
	
	@Test
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("�űԱ�");
		vo.setContent("�ű� ����");
		vo.setWriter("��");
		mapper.insert(vo);
		//mapper.list();
	}
	
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setTitle("������");
		vo.setContent("���� ����");
		vo.setWriter("������");
		vo.setBno(8);
		mapper.update(vo);
		mapper.read(8);
	}
	
	@Test
	public void delete() {
		mapper.delete(7);
		//mapper.list();
	}
}
