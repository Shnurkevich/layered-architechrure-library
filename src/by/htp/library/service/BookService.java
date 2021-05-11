package by.htp.library.service;

import java.util.List;

import by.htp.library.bean.Book;
import by.rdtc.library.bean.UserRole;
import by.htp.library.service.exception.ServiceException;

public interface BookService {
	void addBook(Book book) throws ServiceException;
	boolean deleteBook(long idBook) throws ServiceException;
	List<String> findBookByAuthor(String author, String role) throws ServiceException;

}
