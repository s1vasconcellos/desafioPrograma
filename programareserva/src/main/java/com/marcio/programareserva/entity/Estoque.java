package com.marcio.programareserva.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque {
	private long id;
	private String idPrograma;
	private int tempo_disponivel;
	private LocalDate dataExibicao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "id_programa",length = 10)
	public String getIdPrograma() {
		return idPrograma;
	}
	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}
	
	@Column(name = "tempo_disponivel")
	public int getTempo_disponivel() {
		return tempo_disponivel;
	}
	public void setTempo_disponivel(int tempo_disponivel) {
		this.tempo_disponivel = tempo_disponivel;
	}
	
	@Column(name = "data_exibicao")
	public LocalDate getDataExibicao() {
		return dataExibicao;
	}
	public void setDataExibicao(LocalDate dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
	
	

}
