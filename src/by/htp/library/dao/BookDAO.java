package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.exception.DAOException;

public interface BookDAO {

	void addBook(Book book) throws DAOException;

	boolean deleteBook(long idBook) throws DAOException;

	List<String> findBookByAuthor(String author, String role) throws DAOException;

}
