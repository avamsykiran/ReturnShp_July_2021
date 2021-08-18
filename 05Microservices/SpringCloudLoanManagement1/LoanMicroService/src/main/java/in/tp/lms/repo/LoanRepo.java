package in.tp.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.lms.entity.LoanEntity;

@Repository
public interface LoanRepo extends JpaRepository<LoanEntity,Long>{

}
