package sys.repository;

import sys.entity.SubService_Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubService_ExpertRepository extends JpaRepository<SubService_Expert, Long> {

}
