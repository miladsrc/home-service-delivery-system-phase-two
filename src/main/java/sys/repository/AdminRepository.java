package sys.repository;

import sys.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByPhoneNumber(String phone);
    Optional<Admin> findAdminByPhoneNumber(String phoneNumber);
}
