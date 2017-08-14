package by.htp.task01.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequestExecutorControllerTest {
	RequestExecutorController controller;

	@Before
	public void initializeSource() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		controller = context.getBean("requestExecutorController", RequestExecutorController.class);
		context.close();

		controller.executeAction("initialize_source ");
	}

	@Test
	public void signUpTest() {
		String response = controller.executeAction("sign_up Vasil_Bykov 12345678 ");

		assertEquals("User was registered Vasil_Bykov", response);
	}

	@Test
	public void signInTest() {
		String response = controller.executeAction("sign_in Vasil_Bykov 12345678 ");

		assertEquals("Welcome Vasil_Bykov", response);
	}

	@Test
	public void addNewBookTest() {
		String response = controller.executeAction("add_new_book MyBook Action Vasil_Bykov 2017 2 ");

		assertEquals("Book successfully was added", response);
	}

	@Test
	public void addEditedBookTest() {
		String response = controller.executeAction("add_edited_book MyBook Action Vasil_Bykov 2017 2 15");

		assertEquals("Book successfully edited", response);
	}

	@Test
	public void wrongRequestTest() {
		String response = controller.executeAction("remove_book 10");

		assertEquals("Wrong request!", response);
	}

	@After
	public void destroySource() {
		
		controller.executeAction("destroy_source ");
	}
}
