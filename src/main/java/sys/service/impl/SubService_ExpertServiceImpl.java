package sys.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.SubService_ExpertRepository;
import sys.service.SubService_ExpertService;

@Service
@RequiredArgsConstructor
public class SubService_ExpertServiceImpl implements SubService_ExpertService {


    private final SubService_ExpertRepository subServiceExpertRepository;
}
