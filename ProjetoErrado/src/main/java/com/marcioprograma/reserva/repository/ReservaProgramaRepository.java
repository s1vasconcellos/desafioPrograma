package com.marcioprograma.reserva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcioprograma.reserva.entity.ReservaPrograma;

@Repository
public interface ReservaProgramaRepository extends CrudRepository<ReservaPrograma, Long> {}
