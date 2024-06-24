package sys.service;

import org.springframework.stereotype.Service;

public interface ServiceService {

    sys.entity.Service saveService(sys.entity.Service service);

    sys.entity.Service getServiceById(Long serviceId);

    void deleteService(Long serviceId);
}
