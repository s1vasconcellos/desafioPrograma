package com.marcio.programareserva.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.marcio.programareserva.model.Programa;


public interface ProgramaService {
	
	@GetMapping(value = "/programas/{id}")
	Programa findByProgramaid (@PathVariable("id") String programaId);
	
}
