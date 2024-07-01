package sys.service;

import sys.entity.Client;
import sys.entity.Rate;
import sys.exceptions.NotFoundException;

public interface ClientService {

    Client saveClient(Client client);

    Client getClientById(Long clientId);

    void deleteClient(Long clientId);

    void changePasswords(Long id, String OldPasswords, String NewPasswords) throws NotFoundException;

    boolean confirmOffer(Long offerId);


    boolean registerScoreForExpert(Long ExpertId, Rate expertRate);
}


