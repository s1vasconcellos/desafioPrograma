package com.marcioprograma.reserva.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marcioprograma.reserva.entity.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long> {
	
	@Query("SELECT e FROM Estoque e WHERE e.idPrograma = :idPrograma")
	List<Estoque> findIdPrograma(@Param("idPrograma") String idPrograma);

	@Query("SELECT e FROM Estoque e WHERE e.idPrograma = :idPrograma and e.dataExibicao = :dataExibicao")
	List<Estoque> findIdProgramaDataExibicao(@Param("idPrograma") String idPrograma,@Param("dataExibicao") LocalDate dataExibicao);
}