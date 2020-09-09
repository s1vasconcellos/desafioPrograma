package com.marcio.programareserva.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.programareserva.entity.Reserva;
import com.marcio.programareserva.entity.ReservaPrograma;
import com.marcio.programareserva.model.ProgramaModel;
import com.marcio.programareserva.model.ReservarModel;
import com.marcio.programareserva.repository.ReservaProgramaRepository;
import com.marcio.programareserva.repository.ReservaRepository;
import com.marcio.programareserva.service.ReservaService;

@RestController
public class ReservaController {

	@Autowired
	private ReservaProgramaRepository reservaProgramaRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private ReservaService reservarService;

	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> getAllProgramas() {

		List<Reserva> reservas = new ArrayList<Reserva>();

		reservaRepository.findAll().forEach(reservas::add);

		return new ResponseEntity<>(reservas, HttpStatus.OK);
	}

	@PostMapping("/reservar")
	public ResponseEntity<String> createTutorial(@RequestBody ReservarModel reservar) {
		try {
			reservarService.ValidarPrograma(reservar);
			reservarService.ValidarReseva(reservar);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
				
				reservarService.ReduzirEstoque(item);
			}
			r.setCodigoReserva(String.valueOf(r.getId()));
			reservaRepository.save(r);
			
			
			

			return new ResponseEntity<>(r.getCodigoReserva(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
