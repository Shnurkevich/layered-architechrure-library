package by.htp.library.controller.command.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.command.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.exception.ServiceException;



import java.util.Date;

public class AddBook implements Command {

	@Override
	public String execute(String request) {

		long idBook = 0;
		String bookName = null;
		String author = null;
		int numberOfPages = 0;
		int year = 0;
		String response = null;
		String role = null;

		String[] parameters = null;

		try {
			parameters = request.split(";");
			idBook = generateUniqueID();
			bookName = parameters[1];
			author = parameters[2];
			numberOfPages = Integer.parseInt(parameters[3]);
			year = Integer.parseInt(parameters[4]);
			role = parameters[6].toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			response = "Wrong request";
			return response;
		}

		if (!role.equals("admin")) {
			response = "Not enough permissions to add book";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getLibraryService();

		Book newBook = new Book(idBook, bookName, author, numberOfPages, year);

		try {
			bookService.addBook(newBook);
			response = "Book added";
		} catch (ServiceException e) {
			e.printStackTrace();
			response = "No book added";
		}

		return response;
	}

	private long generateUniqueID() {

		Date now = new Date();
		long time = now.getTime();

		return time;
	}

}
