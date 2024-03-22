package com.example.demo;

import com.example.demo.maper.userMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private userMapper um;
	@Test
	void contextLoads() {
		System.out.println(um.selectAll());
	}

}
