package by.htp.task01.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.task01.service.BookService;
import by.htp.task01.service.exception.ServiceException;

public class TestBookServiceImpl {
	private BookService bookService;
	
	@Before
	public void instantiateService() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		bookService = context.getBean("bookService", BookService.class);
		context.close();
	}
	
	@Test  (expected = ServiceException.class)
	public void testAddNewBook() throws ServiceException{ 
		bookService.addNewBook(null, null, null, null, null);
	}

	@Test
	public void testAddEditBook(){
		try {
			bookService.addEditBook(null, "MyAuthor", "MyGenre", "2017", "10", "1");
		} catch (ServiceException e) {
			Assert.assertEquals("Incorrect data about book", e.getMessage());
		}
	}
	
}
