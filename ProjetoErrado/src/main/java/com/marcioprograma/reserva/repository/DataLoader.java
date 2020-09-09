package com.marcioprograma.reserva.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.marcioprograma.reserva.entity.Estoque;
import com.marcioprograma.reserva.entity.Programa;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private ProgramaRepository programaRepository;

	@Autowired
	private EstoqueRepository estoqueRepository;

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

		// Estoque

		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Estoque estoque = new Estoque();
		estoque.setIdPrograma("MAVO");
		estoque.setTempo_disponivel(100);
		LocalDate parsedDate = LocalDate.parse("04/09/2020", formatters);
		estoque.setDataExibicao(parsedDate);
		estoqueRepository.save(estoque);

		estoque = new Estoque();
		estoque.setIdPrograma("N19H");
		estoque.setTempo_disponivel(100);
		parsedDate = LocalDate.parse("09/09/2020", formatters);
		estoque.setDataExibicao(parsedDate);
		estoqueRepository.save(estoque);

		estoque = new Estoque();
		estoque.setIdPrograma("HUCK");
		estoque.setTempo_disponivel(40);
		parsedDate = LocalDate.parse("05/09/2020", formatters);
		estoque.setDataExibicao(parsedDate);
		estoqueRepository.save(estoque);
		
		
		estoque = new Estoque();
		estoque.setIdPrograma("DFAU");
		estoque.setTempo_disponivel(100);
		parsedDate = LocalDate.parse("06/09/2020", formatters);
		estoque.setDataExibicao(parsedDate);
		estoqueRepository.save(estoque);


	}
}
