package sys.repository;

import sys.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {

    Optional<Object> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
