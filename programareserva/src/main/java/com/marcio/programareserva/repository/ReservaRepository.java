package com.marcio.programareserva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcio.programareserva.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {}