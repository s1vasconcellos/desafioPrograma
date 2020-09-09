package com.marcio.programareserva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcio.programareserva.entity.ReservaPrograma;

@Repository
public interface ReservaProgramaRepository extends CrudRepository<ReservaPrograma, Long> {}
