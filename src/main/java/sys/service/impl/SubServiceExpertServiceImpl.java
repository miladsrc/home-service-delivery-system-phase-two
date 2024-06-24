package sys.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.SubService_Expert;
import sys.exceptions.NotFoundException;
import sys.repository.SubService_ExpertRepository;
import sys.service.SubService_ExpertService;


@Service
@RequiredArgsConstructor
public class SubServiceExpertServiceImpl implements SubService_ExpertService {

    private final SubService_ExpertRepository subServiceExpertRepository;

    @Override
    public SubService_Expert saveSubServiceExpert(SubService_Expert subServiceExpert) {
        return subServiceExpertRepository.save(subServiceExpert);
    }

    @Override
    public SubService_Expert getSubServiceExpertById(Long subServiceExpertId) {
        return subServiceExpertRepository.findById(subServiceExpertId)
                .orElseThrow(() -> new NotFoundException("Service not found with ID: " + subServiceExpertId));
    }

    @Override
    public void deleteSubServiceExpert(Long subServiceExpertId) {
        if (subServiceExpertRepository.findById(subServiceExpertId).isEmpty()) {
            throw new NotFoundException("Service not found with ID: " + subServiceExpertId);
        }
        subServiceExpertRepository.deleteById(subServiceExpertId);
    }

}


