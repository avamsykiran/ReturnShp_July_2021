package com.cts.sdrad.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cts.sdrad.entity.ToDo;

@RepositoryRestResource
public interface TodoRepo extends JpaRepository<ToDo, Long>{

}
