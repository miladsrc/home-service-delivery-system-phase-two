package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.ServiceRepository;
import sys.service.ServiceService;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
}
