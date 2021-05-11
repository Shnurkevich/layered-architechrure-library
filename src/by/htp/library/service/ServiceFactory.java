package by.htp.library.service;

import by.htp.library.service.impl.ClientServiceImpl;
import by.htp.library.service.impl.LibraryServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final BookService libraryService = new LibraryServiceImpl();


    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public BookService getLibraryService() {
        return libraryService;
    }


}
