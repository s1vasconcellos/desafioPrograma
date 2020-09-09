package com.marcio.programareserva.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.marcio.programareserva.entity.Estoque;


@Component
public class DataLoader implements ApplicationRunner {

	

	@Autowired
	private EstoqueRepository estoqueRepository;

	public void run(ApplicationArguments args) {

	
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
