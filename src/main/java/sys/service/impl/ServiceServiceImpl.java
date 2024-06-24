package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.exceptions.DuplicateException;
import sys.exceptions.NotFoundException;
import sys.repository.ServiceRepository;
import sys.service.ServiceService;


@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public sys.entity.Service saveService(sys.entity.Service service) {
        if (serviceRepository.findByServiceName(service.getServiceName())!=null) {
            throw new DuplicateException(
                    "A service with the same name already exists in the database!"
            );
        }
        return serviceRepository.save(service);
    }

    @Override
    public sys.entity.Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId)
                .orElseThrow(() -> new NotFoundException("Service not found with ID: " + serviceId));
    }

    @Override
    public void deleteService(Long serviceId) {
        if (serviceRepository.findById(serviceId).isEmpty()) {
            throw new NotFoundException("Service not found with ID: " + serviceId);
        }
        serviceRepository.deleteById(serviceId);
    }

}
