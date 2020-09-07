package com.marcioprograma.reserva.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservaPrograma {
	private long id;
	private String idPrograma;
	private long idReserva;
	private int quantidade;
	private int tempo;
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
	
	@Column
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Column
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	@Column(name = "data_exibicao",length = 10)
	public LocalDate getDataExibicao() {
		return dataExibicao;
	}
	public void setDataExibicao(LocalDate dataExibicao) {
		this.dataExibicao = dataExibicao;
	}
	
	@Column(name = "id_reserva")
	public long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}
	
}
