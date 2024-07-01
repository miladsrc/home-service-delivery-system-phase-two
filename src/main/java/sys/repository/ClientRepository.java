package sys.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sys.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Optional<Client> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber);

    @Modifying
    @Query("UPDATE Client c SET c.password = :newPasswords WHERE c.id = :id AND c.password= :oldPasswords")
    Optional<Client> updatePassword(Long id, String oldPasswords, String newPasswords);
}
