package com.marcioprograma.reserva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcioprograma.reserva.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {}