package by.htp.library.service;

import by.htp.library.bean.Book;
import by.htp.library.service.exception.ServiceException;

import java.util.List;

public interface BookService {
	void addBook(Book book) throws ServiceException;
	boolean deleteBook(long idBook) throws ServiceException;
	List<String> findBookByAuthor(String author, String role) throws ServiceException;

}
