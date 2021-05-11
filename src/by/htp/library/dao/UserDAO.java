package by.htp.library.dao;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOException;

public interface UserDAO {
	
	public String signIn(String login, String password) throws DAOException;
	public void registration(User user);

}
 