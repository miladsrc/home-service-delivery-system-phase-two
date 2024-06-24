package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Expert;
import sys.exceptions.DuplicateException;
import sys.exceptions.NotFoundException;
import sys.repository.ExpertRepository;
import sys.service.ExpertService;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;

    @Override
    public Expert saveExpert(Expert expert) {
        if (expertRepository.findByPhoneNumberAndPassword(expert.getPhoneNumber(), expert.getPassword()).isPresent()) {
            throw new DuplicateException(
                    expert.getFirstName() + " has already been registered in the database!"
            );
        }
        return expertRepository.save(expert);
    }

    @Override
    public Expert getExpertById(Long expertId) {
        return expertRepository.findById(expertId)
                .orElseThrow(() -> new NotFoundException("Expert not found with ID: " + expertId));
    }

    @Override
    public void deleteExpert(Long expertId) {
        if (!expertRepository.findById(expertId).isPresent()) {
            throw new NotFoundException("Expert not found with ID: " + expertId);
        }
        expertRepository.deleteById(expertId);
    }

}

