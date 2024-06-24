package sys.service;

import sys.entity.Expert;

public interface ExpertService {
    Expert saveExpert(Expert expert);

    Expert getExpertById(Long expertId);

    void deleteExpert(Long expertId);
}
