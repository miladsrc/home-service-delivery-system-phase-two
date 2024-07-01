package sys.service;

import sys.entity.Admin;
import sys.exceptions.NotFoundException;


public interface AdminService {

    Admin loadUserByPhone(String phone) throws NotFoundException;
    void confirmExpert(Long id);
}
