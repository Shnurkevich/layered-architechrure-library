package by.htp.library.service.impl;

import by.htp.library.bean.Book;
import by.htp.library.dao.BookDAO;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.DAOProvider;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.BookService;
import by.htp.library.service.LibraryService;
import by.htp.library.service.exception.ServiceException;

import java.util.List;

public class LibraryServiceImpl implements BookService {

	public static DAOFactory daoProvider = DAOFactory.getInstance();
	public static BookDAO bookDAO = daoProvider.getInstance();

	@Override
	public void returnBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBook(Book book) throws ServiceException {

	}

	@Override
	public boolean deleteBook(long idBook) throws ServiceException {
		return false;
	}

	@Override
	public List<String> findBookByAuthor(String author, String role) throws ServiceException {
		return null;
	}
}
