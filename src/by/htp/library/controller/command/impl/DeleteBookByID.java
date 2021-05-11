package by.htp.library.controller.command.impl;

import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.exception.ServiceException;


public class DeleteBookByID implements Command {

	@Override
	public String execute(String request) {

		long idBook = 0;
		String response;
		boolean success;
		String role;

		String[] parameters = null;

		try {
			parameters = request.split("/");
			idBook = Long.parseLong(parameters[1]);
			role = parameters[2].toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			response = "Wrong request";
			return response;
		}

		if (!role.equals("admin")) {
			response = "Not enough permissions to delete book";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();

		try {
			success = bookService.deleteBook(idBook);
			if (success) {
				response = "Book deleted ";
			} else {
				response = "Book not deleted.";
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error: Book not deleted.";
		}

		return response;
	}

}
