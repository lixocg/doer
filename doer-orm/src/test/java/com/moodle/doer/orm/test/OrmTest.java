package com.moodle.doer.orm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.moodle.doer.entity.TbContent;
import com.moodle.doer.orm.mapper.TbContentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class OrmTest {
	@Autowired
	private TbContentMapper tbContentMapper;
	
	private static Gson gson = new Gson();
	
	@Test
	public void test01(){
		TbContent content = tbContentMapper.selectByPrimaryKey(43L);
		System.out.println("------------------"+gson.toJson(content));
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02(){
		TbContent content = tbContentMapper.selectByPrimaryKey(43L);
		System.out.println("------------------"+gson.toJson(content));
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
