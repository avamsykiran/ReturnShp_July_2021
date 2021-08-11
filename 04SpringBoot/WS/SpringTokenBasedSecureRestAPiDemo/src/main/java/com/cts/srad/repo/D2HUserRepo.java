package com.cts.srad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.srad.entity.D2HUser;

@Repository
public interface D2HUserRepo extends JpaRepository<D2HUser, Long>{
	D2HUser findByEmailId(String emailId);
}
