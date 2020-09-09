package com.marcio.programareserva.service;
import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcio.programareserva.entity.Estoque;
import com.marcio.programareserva.entity.ReservaPrograma;
import com.marcio.programareserva.model.Programa;
import com.marcio.programareserva.model.ProgramaModel;
import com.marcio.programareserva.model.ReservarModel;
import com.marcio.programareserva.repository.EstoqueRepository;
import com.marcio.programareserva.repository.ReservaProgramaRepository;
import com.marcio.programareserva.repository.ReservaRepository;

@Service
@Transactional
public class ReservarServiceImpl implements ReservaService {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProgramaService programaService;
	
	@Override
	public void ValidarPrograma(ReservarModel reservar) {
		// TODO Auto-generated method stub
		for (ProgramaModel item : reservar.getProgramas()) {
			Programa programa = programaService.findByProgramaid(item.getID());
			 if(programa == null) {
				 throw new RuntimeException("“Programa "+ item.getID()+"' não encontrado.");
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
