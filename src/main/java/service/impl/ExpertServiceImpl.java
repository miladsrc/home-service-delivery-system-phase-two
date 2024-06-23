package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ExpertRepository;
import service.ExpertService;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;
}
