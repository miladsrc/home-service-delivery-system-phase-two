package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.repository.ExpertRepository;
import sys.service.ExpertService;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;
}
