package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.SubServiceService;

@Service
@RequiredArgsConstructor
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceService subServiceService;
}
