package in.tp.lts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.lts.entity.LoanTypeEntity;

@Repository
public interface LoanTypeRepo extends JpaRepository<LoanTypeEntity,Long>{

}
