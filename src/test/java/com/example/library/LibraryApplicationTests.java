package com.example.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class LibraryApplicationTests {
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each");
	}

	@BeforeTestClass
	public void beforeTestClass() {
		System.out.println("Before Test Class");
	}
	
	@AfterTestClass
	public void afterTestClass() {
		System.out.println("After Test Class");
	}
	@Test
	void contextLoads() {
		System.out.println("contextLoads");
		assertEquals('1', '2');
	}
	
	@Test
	void booleanTest() {
		System.out.println("booleanTest");
		assertEquals(true, true,"My Assert Equals Failed");
	}

}
