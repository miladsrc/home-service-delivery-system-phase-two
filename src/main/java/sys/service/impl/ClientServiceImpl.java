package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.ClientRepository;
import sys.service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
}
