package sys.service;

import sys.entity.Client;

public interface ClientService {

    Client saveClient(Client client);

    Client getClientById(Long clientId);

    void deleteClient(Long clientId);
}


