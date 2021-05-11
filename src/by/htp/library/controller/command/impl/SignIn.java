package by.htp.library.controller.command.impl;

import by.htp.library.controller.command.Command;
import by.htp.library.service.UserService;
import by.htp.library.service.exception.ServiceException;
import by.htp.library.service.factory.ServiceFactory;

public class SignIn implements Command {

	@Override
	public String execute(String request) {

		String login = null;
		String password = null;
		String response = null;


		login = request.substring(request.indexOf("login"));
		password = request.substring(request.indexOf("password"));

		if (login == null || login.isEmpty()) {
			return "Login cann't be null";
		}

		if (password == null || password.isEmpty()) {
			return "Password cann't be null";
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService clientService = serviceFactory.getUserService();

		try {

			response = "Welcome " + clientService.signIn(
					, password) + "!";

		} catch (ServiceException e) {

			response = "Error";
		}
		return response;
	}
}
