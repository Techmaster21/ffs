package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.conf.TestApplicationConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestApplicationConfiguration.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
