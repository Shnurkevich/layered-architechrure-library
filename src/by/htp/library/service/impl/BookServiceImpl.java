package by.htp.library.service.impl;

import java.util.List;

import by.htp.library.bean.Book;
import by.rdtc.library.bean.UserRole;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.dao.impl.FileBookDAO;
import by.htp.library.service.BookService;
import by.htp.library.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public void addBook(Book book) throws ServiceException {

		if (book == null) {
			throw new ServiceException("Error: book can not be added. Book is null");
		}

		BookDAO bookDAO = new FileBookDAO();
		try {
			bookDAO.addBook(book);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deleteBook(long idBook) throws ServiceException {
		if (idBook < 0) {
			throw new ServiceException("Error: book can not be deleted. Incorrect book id");
		}

		BookDAO bookDAO = new FileBookDAO();
		boolean response;
		try {
			response = bookDAO.deleteBook(idBook);
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

		return response;

	}

	@Override
	public List<String> findBookByAuthor(String author, String role) throws ServiceException {
		if (author == null) {
			throw new ServiceException("Error: book can not be found. Author can not be null");
		}
		BookDAO bookDAO = new FileBookDAO();
		List<String> response;
		try {
			response = bookDAO.findBookByAuthor(author, role);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return response;
	}

}
