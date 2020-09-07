package com.marcioprograma.reserva.entity;

import javax.persistence.Entity;

@Entity
public class Estoque {
	private long id;
	private String idPrograma;
	private int tempo_disponivel;
	private String dataExibicao;

}
