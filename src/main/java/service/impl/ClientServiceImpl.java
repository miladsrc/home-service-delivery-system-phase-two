package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ClientRepository;
import service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
}
