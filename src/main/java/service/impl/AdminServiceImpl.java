package service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AdminRepository;
import service.AdminService;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
}
