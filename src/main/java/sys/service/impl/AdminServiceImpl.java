package sys.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sys.entity.Admin;
import sys.exceptions.NotFoundException;
import sys.repository.AdminRepository;
import sys.service.AdminService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;


    @Override
    public Admin loadUserByPhone(String phone) throws NotFoundException {
        Optional<Admin> user = adminRepository.findAdminByPhoneNumber(phone);
        return user.orElseThrow(() -> new NotFoundException("User not found with phone number: " + phone));
    }

}
