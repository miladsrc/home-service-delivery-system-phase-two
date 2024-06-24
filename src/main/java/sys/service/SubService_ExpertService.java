package sys.service;

import sys.entity.SubService_Expert;
import sys.exceptions.DuplicateException;

public interface SubService_ExpertService {

    SubService_Expert saveSubServiceExpert(SubService_Expert subServiceExpert);

    SubService_Expert getSubServiceExpertById(Long subServiceExpertId);

    void deleteSubServiceExpert(Long subServiceExpertId);
}