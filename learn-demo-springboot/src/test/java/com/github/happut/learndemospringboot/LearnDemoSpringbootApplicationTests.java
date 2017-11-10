package com.github.happut.learndemospringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootConfiguration(classes = MockServletConfig.class)
@SpringBootTest
public class LearnDemoSpringbootApplicationTests {

	@Test
	public void contextLoads() {
	}

}
