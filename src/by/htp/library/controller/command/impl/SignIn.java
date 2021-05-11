package by.htp.library.controller.command.impl;

import by.htp.library.controller.command.Command;
import by.htp.library.service.ClientService;
import by.htp.library.service.ServiceFactory;
import by.htp.library.service.exception.ServiceException;

public class SignIn implements Command {

    @Override
    public String execute(String request) {

        String login = null;
        String password = null;
        String response = null;


        login = request.substring(request.indexOf("login"), request.indexOf(' ', request.indexOf("login")));
        password = request.substring(request.indexOf("password"));

        if (login == null || login.isEmpty()) {
            return "Login cann't be null";
        }

        if (password == null || password.isEmpty()) {
            return "Password cann't be null";
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();

        try {

            response = "Welcome ";

        } catch (ServiceException e) {

            response = "Error";
        }
        return response;
    }
}
