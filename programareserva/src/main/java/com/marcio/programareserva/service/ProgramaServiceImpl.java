package com.marcio.programareserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.marcio.programareserva.model.Programa;

@Service
public class ProgramaServiceImpl implements ProgramaService  {
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	
	public Programa findByProgramaid(String programasId) {
		return restTemplate.getForObject("http://PROGRAMA-SERVICE/programas/{programasId}", Programa.class, programasId);
	}

	
	
}
