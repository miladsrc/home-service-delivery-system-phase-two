package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Client;
import sys.exceptions.DuplicateException;
import sys.exceptions.NotFoundException;
import sys.repository.ClientRepository;
import sys.service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        if (clientRepository.findByFirstNameaAndPhoneNumber(client.getFirstName(), client.getPhoneNumber()).isPresent())
            throw new DuplicateException(
                    client.getFirstName() + " has already been registered in database!"
            );
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));
    }

    @Override
    public void deleteClient(Long clientId) {
        if (!clientRepository.findById(clientId).isPresent()) {
            throw new NotFoundException("Client not found with ID: " + clientId);
        }
        clientRepository.deleteById(clientId);
    }

}
