package com.marcioprograma.reserva.service;

import com.marcioprograma.reserva.model.ProgramaModel;
import com.marcioprograma.reserva.model.ReservarModel;

public interface ReservaService {
	
	void ValidarPrograma(ReservarModel reservar);
	void ValidarReseva(ReservarModel reservar);
	void ReduzirEstoque(ProgramaModel reservar);
}
