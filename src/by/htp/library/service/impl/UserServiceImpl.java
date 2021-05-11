package by.htp.library.service.impl;

import by.htp.library.bean.User;
import by.rdtc.library.bean.UserRole;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.factory.DAOFactory;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public UserRole signIn(String login, String password) throws ServiceException {
		
		UserRole role = null;

		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrect login");
		}

		if (password == null || password.isEmpty()) {
			throw new ServiceException("Incorrect password");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			role = userDAO.signIn(login, password);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return role;
	}

	@Override
	public void singOut(String login) throws ServiceException {

	}

	@Override
	public void registration(User user) throws ServiceException {

	}

}
