package by.htp.library.dao.impl;

import by.htp.library.bean.User;
import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUserDAO implements UserDAO {

	private static final String PATH_TO_USERFILE = "database/users.txt";

	@Override
	public String signIn(String login, String password) throws DAOException {

		String role = "undefined";

		File userDataFile = new File(PATH_TO_USERFILE);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(userDataFile));
			String userData = null;

			while ((userData = reader.readLine()) != null) {

				if (userSearch(userData, login, password)) {
					role = setUserRole(userData);
					return role;

				}
			}
		}

		catch (IOException e) {
			throw new DAOException(e);
		}

		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}

		return role;
	}



	public boolean userSearch(String userData, String login, String password) {

		String[] userDataSplitted;
		String loginTemp;
		String passwordTemp;

		userDataSplitted = userData.split("/");

		loginTemp = userDataSplitted[1];
		passwordTemp = userDataSplitted[2];

		if (login.equals(loginTemp) && password.equals(passwordTemp)) {
			return true;
		} else {
			return false;
		}

	}

	public String setUserRole(String userData) {

		String[] userDataSplitted = userData.split("/");
		return userDataSplitted[3];

	}

	@Override
	public void registration(User user) {
		//In progress...
	}


}
