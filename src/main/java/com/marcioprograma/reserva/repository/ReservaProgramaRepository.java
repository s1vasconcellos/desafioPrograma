package com.marcioprograma.reserva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcioprograma.reserva.entity.ReservaPrograma;

@Repository
public interface ReservaProgramaRepository extends CrudRepository<ReservaPrograma, Long> {}


/// Select Count(*) from RESERVA_PROGRAMA group by id_programa order by 1 desc; 