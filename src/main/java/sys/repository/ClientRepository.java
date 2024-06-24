package sys.repository;

import org.springframework.data.jpa.repository.Query;
import sys.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Optional<Client> findByFirstNameaAndPhoneNumber(String firstName, String phoneNumber);
}
