package by.htp.library.controller;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.command.CommandName;
import by.htp.library.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.FIND_BOOK_BY_AUTHOR, new FindBookByAuthor());
        repository.put(CommandName.DELETE_BOOK_BY_ID, new DeleteBookByID());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
