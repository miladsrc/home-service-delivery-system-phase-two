package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ServiceRepository;
import service.ServiceService;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
}
