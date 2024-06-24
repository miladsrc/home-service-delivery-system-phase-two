package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sys.entity.SubService;
import sys.exceptions.DuplicateException;
import sys.exceptions.NotFoundException;
import sys.repository.SubServiceRepository;
import sys.service.SubServiceService;

@Service
@RequiredArgsConstructor
@Lazy
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceRepository subServiceRepository;

    @Override
    public SubService saveSubService(SubService subService) {
        if (subServiceRepository.findBySubServiceName(subService.getSubServiceName()).isPresent()) {
            throw new DuplicateException(
                    "A service with the same name already exists in the database!"
            );
        }
        return subServiceRepository.save(subService);
    }

    @Override
    public SubService getSubServiceById(Long subServiceId) {
        return subServiceRepository.findById(subServiceId)
                .orElseThrow(() -> new NotFoundException("Service not found with ID: " + subServiceId));
    }

    @Override
    public void deleteSubService(Long subServiceId) {
        if (subServiceRepository.findById(subServiceId).isEmpty()) {
            throw new NotFoundException("Service not found with ID: " + subServiceId);
        }
        subServiceRepository.deleteById(subServiceId);
    }

}
