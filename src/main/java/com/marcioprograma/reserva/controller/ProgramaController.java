package com.marcioprograma.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.marcioprograma.reserva.entity.Programa;
import com.marcioprograma.reserva.repository.ProgramaRepository;

@RestController
@RequestMapping("/api")
public class ProgramaController {

	@Autowired
	private ProgramaRepository programaRepository;

	@GetMapping("/programas")
	public ResponseEntity<List<Programa>> getAllProgramas() {

		List<Programa> programas = new ArrayList<Programa>();

		programaRepository.findAll().forEach(programas::add);

		return new ResponseEntity<>(programas, HttpStatus.OK);
	}
	
	@GetMapping("/programas/nomeinvertido/{id}")
	public ResponseEntity<String> getProgramaByIdNomeInvertido(@PathVariable("id") String id) {
		Optional<Programa> programaData = programaRepository.findById(id);
		
		if (programaData.isPresent()) {
			StringBuffer sb = new StringBuffer(programaData.get().getNome());
			sb.reverse();
			
			return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/programas/{id}")
	public ResponseEntity<Programa> getProgramaById(@PathVariable("id") String id) {
		Optional<Programa> programaData = programaRepository.findById(id);

		if (programaData.isPresent()) {
			return new ResponseEntity<>(programaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/programas")
	public ResponseEntity<Programa> createTutorial(@RequestBody Programa programa) {
		try {
			Programa _programa = new Programa();
			_programa.setAtivo(true);
			_programa.setDataCadastro(LocalDate.now());
			_programa.setId(programa.getId());
			_programa.setNome(programa.getNome());

			programaRepository.save(_programa);
			return new ResponseEntity<>(_programa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/programas/{id}")
	public ResponseEntity<Programa> updateTutorial(@PathVariable("id") String id, @RequestBody Programa programa) {
		Optional<Programa> programaData = programaRepository.findById(id);

		if (programaData.isPresent()) {
			Programa _programa = programaData.get();
			_programa.setNome(programa.getNome());
			return new ResponseEntity<>(programaRepository.save(_programa), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/programas/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		Optional<Programa> programaData = programaRepository.findById(id);

		if (programaData.isPresent()) {

			try {
				Programa _programa = programaData.get();
				_programa.setAtivo(false);
				_programa.setDataExclusao(LocalDate.now());
				programaRepository.save(_programa);
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
