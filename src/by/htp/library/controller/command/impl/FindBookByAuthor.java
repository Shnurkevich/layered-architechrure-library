package by.htp.library.controller.command.impl;

import java.util.List;

import by.rdtc.library.bean.UserRole;
import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.exception.ServiceException;
import by.htp.library.service.factory.ServiceFactory;

public class FindBookByAuthor implements Command {

	@Override
	public String execute(String request) {

		String author = null;
		List<String> response = null;
		String role = null;

		String[] parameters = null;

		try {
			parameters = request.split(";");
			author = parameters[1];
			role = parameters[2].toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return "Wrong request";
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();

		try {
			response = bookService.findBookByAuthor(author, role);
		} catch (ServiceException e) {
			e.printStackTrace();
			return "Book was not found";
		}

		if (response.isEmpty() || response == null) {
			return "Book was not found";
		} else {
			return response.toString();
		}
	}
}
