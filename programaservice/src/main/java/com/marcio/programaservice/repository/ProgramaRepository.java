package com.marcio.programaservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcio.programaservice.entity.Programa;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, String> {}