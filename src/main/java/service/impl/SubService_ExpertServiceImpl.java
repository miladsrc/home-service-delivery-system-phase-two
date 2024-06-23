package service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.SubService_ExpertRepository;
import service.SubService_ExpertService;

@Service
@RequiredArgsConstructor
public class SubService_ExpertServiceImpl implements SubService_ExpertService {


    private final SubService_ExpertRepository subServiceExpertRepository;
}
