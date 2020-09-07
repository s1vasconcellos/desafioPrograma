package com.marcioprograma.reserva.repository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.marcioprograma.reserva.entity.Programa;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ProgramaRepository programaRepository;

    public void run(ApplicationArguments args) {
    	
    	Programa _programa = new Programa();
		_programa.setAtivo(true);
		_programa.setDataCadastro(LocalDate.now());
		_programa.setId("MAVO");
		_programa.setNome("MAIS VOCE");
		programaRepository.save(_programa);

    	 _programa = new Programa();
		_programa.setAtivo(true);
		_programa.setDataCadastro(LocalDate.now());
		_programa.setId("N19H");
		_programa.setNome("NOVELA 1");
		programaRepository.save(_programa);

    	 _programa = new Programa();
		_programa.setAtivo(true);
		_programa.setDataCadastro(LocalDate.now());
		_programa.setId("HUCK");
		_programa.setNome("CALDEIRAO DO HUCK");
		programaRepository.save(_programa);

    	 _programa = new Programa();
		_programa.setAtivo(true);
		_programa.setDataCadastro(LocalDate.now());
		_programa.setId("DFAU");
		_programa.setNome("DOMINGAO DO FAUSTAO");
		programaRepository.save(_programa);

    }
}
