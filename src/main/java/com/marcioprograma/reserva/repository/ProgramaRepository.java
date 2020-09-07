package com.marcioprograma.reserva.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcioprograma.reserva.entity.Programa;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, String> {}