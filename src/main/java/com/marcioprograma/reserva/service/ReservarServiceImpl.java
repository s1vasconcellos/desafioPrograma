package com.marcioprograma.reserva.service;
import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcioprograma.reserva.entity.Estoque;
import com.marcioprograma.reserva.entity.ReservaPrograma;
import com.marcioprograma.reserva.model.ProgramaModel;
import com.marcioprograma.reserva.model.ReservarModel;
import com.marcioprograma.reserva.repository.EstoqueRepository;
import com.marcioprograma.reserva.repository.ReservaProgramaRepository;
import com.marcioprograma.reserva.repository.ReservaRepository;

@Service
@Transactional
public class ReservarServiceImpl implements ReservaService {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Override
	public void ValidarPrograma(ReservarModel reservar) {
		// TODO Auto-generated method stub
		for (ProgramaModel item : reservar.getProgramas()) {
			List<Estoque> estoques = estoqueRepository.findIdProgramaDataExibicao(item.getID(),item.getDataExibicao());
			 if(estoques.isEmpty()) {
				 throw new RuntimeException("“Programa "+ item.getID()+"' não existente. Reserva não pode ser efetuada.");
			 }
		}
	}

	
	@Override
	public void ValidarReseva(ReservarModel reservar) {
		// TODO Auto-generated method stub
		for (ProgramaModel item : reservar.getProgramas()) {
			List<Estoque> estoques = estoqueRepository.findIdProgramaDataExibicao(item.getID(),item.getDataExibicao());
			 if(estoques.isEmpty()) {
				 throw new RuntimeException("“Não existe estoque disponível para o programa "+ item.getID()+" e nem para data solicitada"+item.getDataExibicao());
			 }
			 else {
				 
				 for (Estoque estoque : estoques) {
						
						int total =  estoque.getTempo_disponivel() - (item.getQuantidade() * item.getTempo());
						
						if(total < 0) {
							throw new RuntimeException("Não existe estoque disponível para o programa "+ item.getID());
						}
						
					}
				 
			 }
			 
		}
	}

	@Override
	public void ReduzirEstoque(ProgramaModel programa) {
		// TODO Auto-generated method stub
		List<Estoque> estoques = estoqueRepository.findIdProgramaDataExibicao(programa.getID(),programa.getDataExibicao());
		
		for (Estoque estoque : estoques) {
		
			int total =  estoque.getTempo_disponivel() - (programa.getQuantidade() * programa.getTempo());
			
			estoque.setTempo_disponivel(total);
			
			estoqueRepository.save(estoque);
			
		}
		
		
	}
}
