package by.htp.task01.view;

import by.htp.task01.controller.Controller;

public final class View {
	private static final Controller CONTROLLER = new Controller();
	public static void main(String [] args){
		String response = null;
		
//		##Initialization DB connection##
		response = CONTROLLER.executeAction("initialization_source ");
		PrintRespnse.out(response);
		
		
//		##Sign up user
/*		response = CONTROLLER.executeAction("sign_up Василий_Пупкин 12345678");
		PrintRespnse.out(response);
*/
		
// 		##Sign in user
/*		response = CONTROLLER.executeAction("sign_in Василий_Пупкин 12345678");
		PrintRespnse.out(response);
*/		

// 		##Add new book
//		Example: add_new_book Title Genre Author Year Quantity
/*		response = CONTROLLER.executeAction("add_new_book MyBook Action Vasya_Pupkin 2017 2");
		PrintRespnse.out(response);
*/
		
// 		##Add edit book
//		Example: add_edit_book Title Genre Author Year Quantity idBook
/*		response = CONTROLLER.executeAction("add_edit_book MyBook Action Petya_Pupkin 2017 2 15");
		PrintRespnse.out(response);
*/
		
//		##Get booklist
/*		CONTROLLER.executeAction("get_booklist ");
		PrintRespnse.out(response);
*/
		
// 		##Remove book
//		Example: remove_book idBook
/*		response = CONTROLLER.executeAction("remove_book 10");
		PrintRespnse.out(response);
*/		
		
//		##Destroy DB connection##
		response = CONTROLLER.executeAction("destroy_source ");
		PrintRespnse.out(response);
	}
}
