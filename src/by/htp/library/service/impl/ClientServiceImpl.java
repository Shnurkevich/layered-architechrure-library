package by.htp.library.service.impl;

import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.ClientService;
import by.htp.library.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    DAOFactory daoObjectFactory = DAOFactory.getInstance();
    UserDAO userDAO = daoObjectFactory.getUserDAO();

    @Override
    public String signIn(String login, String password) throws ServiceException {

        final String wrongSymbols = "[^\\#\\&\\?\\$\\% ]";

        if (!login.matches(wrongSymbols)) {
            throw new ServiceException("wrong login symbols");
        }


        if (!password.matches(wrongSymbols)) {
            throw new ServiceException("wrong password symbols");
        }

        String role = "undefined";

        try {

            role = userDAO.signIn(login, password);

        } catch (DAOException e) {

            throw new ServiceException(e);
        }

        return role;

    }
}
