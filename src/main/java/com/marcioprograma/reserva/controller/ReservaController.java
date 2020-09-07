package com.marcioprograma.reserva.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcioprograma.reserva.entity.Reserva;
import com.marcioprograma.reserva.entity.ReservaPrograma;
import com.marcioprograma.reserva.model.ProgramaModel;
import com.marcioprograma.reserva.model.ReservarModel;
import com.marcioprograma.reserva.repository.ReservaProgramaRepository;
import com.marcioprograma.reserva.repository.ReservaRepository;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	private ReservaProgramaRepository reservaProgramaRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;

	
	@PostMapping("/reservar")
	public ResponseEntity<String> createTutorial(@RequestBody ReservarModel reservar) {
		try {
			Reserva r = new Reserva();
			
			r.setDataReserva(LocalDate.now());
			r.setRequestId(reservar.getRequestID());
			reservaRepository.save(r);
			for (ProgramaModel item : reservar.getProgramas()) {
				ReservaPrograma rp = new ReservaPrograma();
				rp.setDataExibicao(item.getDataExibicao());
				rp.setIdPrograma(item.getID());
				rp.setQuantidade(item.getQuantidade());
				rp.setTempo(item.getTempo());
				rp.setIdReserva(r.getId());
				
				reservaProgramaRepository.save(rp);
			}
			r.setCodigoReserva(String.valueOf(r.getId()));
			reservaRepository.save(r);
			
			
			return new ResponseEntity<>(r.getCodigoReserva(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
