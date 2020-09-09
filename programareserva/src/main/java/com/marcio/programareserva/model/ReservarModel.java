package com.marcio.programareserva.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservarModel {

	private UUID requestID;
	private ProgramaModel[] programas;

	@JsonProperty("request_id")
	public UUID getRequestID() {
		return requestID;
	}

	@JsonProperty("request_id")
	public void setRequestID(UUID value) {
		this.requestID = value;
	}

	@JsonProperty("programas")
	public ProgramaModel[] getProgramas() {
		return programas;
	}

	@JsonProperty("programas")
	public void setProgramas(ProgramaModel[] value) {
		this.programas = value;
	}

}
