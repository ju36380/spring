package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.AddVO;
import com.example.mapper.AddMapper;

@RunWith(SpringJUnit4ClassRunner.class) //���� SpringJUnit4ClassRunner.class import�Ѵ�.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class AddTest {
	@Autowired
	private AddMapper mapper;
	
	@Test
	public void list() {
		mapper.list();
	}
	
	@Test
	public void insert(){
		AddVO vo = new AddVO();
		vo.setName("��!");
		vo.setTel("070-331-1597");
		vo.setAddr("����!");
		mapper.insert(vo);
	}
	
	@Test
	public void read(){
		mapper.read(2);
	}
	
	@Test
	public void update(){
		AddVO vo = new AddVO();
		vo.setName("��!");
		vo.setTel("070-331-1599");
		vo.setAddr("����!");
		vo.setAno(7);
		mapper.update(vo);
	}
	
	@Test
	public void delete(){
		mapper.delete(7);
	}
}
