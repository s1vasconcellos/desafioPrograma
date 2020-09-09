package com.marcio.programareserva.service;

import com.marcio.programareserva.model.ProgramaModel;
import com.marcio.programareserva.model.ReservarModel;

public interface ReservaService {
	
	void ValidarPrograma(ReservarModel reservar);
	void ValidarReseva(ReservarModel reservar);
	void ReduzirEstoque(ProgramaModel reservar);
}
