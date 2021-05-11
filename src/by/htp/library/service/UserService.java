package by.htp.library.service;

import by.htp.library.bean.User;
import by.rdtc.library.bean.UserRole;
import by.htp.library.service.exception.ServiceException;

public interface UserService {
	
	UserRole signIn(String login, String password) throws ServiceException;
	void singOut(String login) throws ServiceException;
	void registration(User user) throws ServiceException;
	

}
