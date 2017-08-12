package by.htp.task01.view;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.task01.controller.RequestExecutorController;

public final class View {

	public static void main(String[] args) {
		String response = null;
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		RequestExecutorController controller = context.getBean("requestExecutorController",
				RequestExecutorController.class);
		context.close();

		// ##Initialization DB connection##
		response = controller.executeAction("initialize_source ");
		PrintResponse.out(response);

		// ##Sign up user
		response = controller.executeAction("sign_up Василий_Пупкин 12345678");
		PrintResponse.out(response);

		// ##Sign in user
		response = controller.executeAction("sign_in Василий_Пупкин 12345678");
		PrintResponse.out(response);

		// ##Add new book
		// Example: add_new_book Title Genre Author Year Quantity
		response = controller.executeAction("add_new_book MyBook Action Vasya_Pupkin 2017 2");
		PrintResponse.out(response);

		// ##Add edit book
		// Example: add_edited_book Title Genre Author Year Quantity idBook
		response = controller.executeAction("add_edited_book MyBook Action Petya_Pupkin 2017 2 15");
		PrintResponse.out(response);

		// ##Get booklist
		response = controller.executeAction("get_booklist ");
		PrintResponse.out(response);

		// ##Remove book
		// Example: remove_book idBook
		response = controller.executeAction("remove_book 10");
		PrintResponse.out(response);

		// ##Destroy DB connection##
		response = controller.executeAction("destroy_source ");
		PrintResponse.out(response);
	}
}
