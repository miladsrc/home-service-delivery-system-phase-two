package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Client;
import sys.entity.Expert;
import sys.entity.Offer;
import sys.entity.Rate;
import sys.exceptions.NotFoundException;
import sys.repository.ClientRepository;
import sys.repository.ExpertRepository;
import sys.repository.OfferRepository;
import sys.service.ClientService;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final OfferRepository offerRepository;
    private final ExpertRepository expertRepository;

    @Override
    public Client saveClient(Client client) {
        Client savedClient = clientRepository.findByFirstNameAndPhoneNumber(client.getFirstName(), client.getPhoneNumber())
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + client.getId()));
        return clientRepository.save(savedClient);
    }


    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));
        clientRepository.delete(client);
    }


    @Override
    public void changePasswords(Long id, String OldPasswords, String NewPasswords) throws NotFoundException {
        Client client = clientRepository.updatePassword(id, OldPasswords, NewPasswords)
                .orElseThrow(() -> new NotFoundException("user not found with ID: " + id));
    }


    // TODO: 7/1/2024

    @Override
    public boolean confirmOffer(Long offerId) {
        Offer offer = offerRepository.findOfferById(offerId)
                .orElseThrow(() -> new NotFoundException("offer not found" + offerId));
        offer.setConfirmed(true);
        offerRepository.save(offer);
        return true;
    }


    @Override
    public boolean registerScoreForExpert(Long expertId, Rate expertRate){

        Expert expert = expertRepository.findById(expertId)
                .orElseThrow(() -> new NotFoundException("No such expert found !"));

        int oldRate = expert.getRate().ordinal();
        int newRate = expertRate.ordinal();
        int averageRate = (oldRate + newRate)/2 ;
        expert.setRate(Rate.values()[averageRate]);
        Expert savedExpert = expertRepository.save(expert);

        return savedExpert.getId() != null;
    }


}
