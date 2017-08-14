package by.htp.task01.service.impl;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.task01.dao.exception.ConnectionPoolException;
import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

public class TestBookServiceImpl {
	private BookService bookService;
	ClassPathXmlApplicationContext context;
	
	@Before
	public void initializeSource() throws ConnectionPoolException {
		context = new ClassPathXmlApplicationContext("spring-root-context.xml");
		bookService = context.getBean("bookService", BookService.class);
	}
	
	@Test
	public void getBookListTest() throws ServiceException { 
		
		assertFalse(bookService.getBookList() == null);
	}
	
	@After
	public void destroySource() throws IOException {
		
		context.close();
	}
}
