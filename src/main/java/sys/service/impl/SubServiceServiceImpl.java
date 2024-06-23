package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import sys.service.SubServiceService;

@Service
@RequiredArgsConstructor
@Lazy
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceService subServiceService;
}
