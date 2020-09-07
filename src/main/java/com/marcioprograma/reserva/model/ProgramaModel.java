package com.marcioprograma.reserva.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramaModel {
	private String id;
	private String dataExibicao;
	private int quantidade;
	private int tempo;

	@JsonProperty("id")
	public String getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(String value) {
		this.id = value;
	}

	@JsonProperty("data_exibicao")
	public String getDataExibicao() {
		return dataExibicao;
	}

	@JsonProperty("data_exibicao")
	public void setDataExibicao(String value) {
		this.dataExibicao = value;
	}

	@JsonProperty("quantidade")
	public int getQuantidade() {
		return quantidade;
	}

	@JsonProperty("quantidade")
	public void setQuantidade(int value) {
		this.quantidade = value;
	}

	@JsonProperty("tempo")
	public int getTempo() {
		return tempo;
	}

	@JsonProperty("tempo")
	public void setTempo(int value) {
		this.tempo = value;
	}

}
