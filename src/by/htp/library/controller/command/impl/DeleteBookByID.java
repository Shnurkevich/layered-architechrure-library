package by.htp.library.controller.command.impl;

import by.rdtc.library.bean.UserRole;
import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.exception.ServiceException;
import by.htp.library.service.factory.ServiceFactory;

public class DeleteBookByID implements Command {

	@Override
	public String execute(String request) {

		long idBook = 0;
		String response = null;
		boolean success = false;
		UserRole role = null;

		String[] parameters = null;

		try {
			parameters = request.split(";");
			idBook = Long.parseLong(parameters[1]);
			role = UserRole.valueOf(parameters[2].toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
			response = "Wrong request";
			return response;
		}

		if (!role.equals(UserRole.ADMIN)) {
			response = "Not enough permissions to delete book";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();

		try {
			success = bookService.deleteBook(idBook);
			if (success) {
				response = "Book with ID = " + idBook + " deleted ";
			} else {
				response = "Book with id=" + idBook + " is not deleted. It doesn't exist";
			}

		} catch (ServiceException e) {
			e.printStackTrace();
			response = "Error: book was not deleted4";
		}

		return response;
	}

}
