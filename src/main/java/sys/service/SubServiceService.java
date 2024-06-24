package sys.service;

import sys.entity.SubService;

public interface SubServiceService {
    SubService saveSubService(SubService subService);

    SubService getSubServiceById(Long subServiceId);

    void deleteSubService(Long subServiceId);
}
