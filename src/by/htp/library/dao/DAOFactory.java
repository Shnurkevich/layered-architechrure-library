package by.htp.library.dao;

import by.htp.library.dao.impl.FileBookDAO;
import by.htp.library.dao.impl.FileUserDAO;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final BookDAO fileBookImpl = new FileBookDAO();
    private final UserDAO fileUserImpl = new FileUserDAO();


    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public BookDAO getBookDAO() {
        return fileBookImpl;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }



}
