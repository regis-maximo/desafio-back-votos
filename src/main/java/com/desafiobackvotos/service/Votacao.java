package com.desafiobackvotos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiobackvotos.model.VotacaoPessoa;
import com.desafiobackvotos.model.VotacaoResultado;
import com.desafiobackvotos.repository.VotacaoResultadoRepository;

// clase responsável por calcular quantidade de votos
@Service
public class Votacao {

	@Autowired
	private VotacaoResultadoRepository votacaoResultadoRepository;
	
	public VotacaoResultado verificarVotos(String pauta, char resp) {
		
		VotacaoResultado vresultado = new VotacaoResultado();
		List<VotacaoPessoa> vpessoa = votacaoResultadoRepository.findByVotos(pauta, resp);
		
		if(resp == 's') {
			vresultado.setPauta(pauta);
			vresultado.setQuantidadeVotosSim(vpessoa.size());
			
		} 
		if(resp == 'n') {
			vresultado.setPauta(pauta);
			vresultado.setQuantidadeVotosNao(vpessoa.size());
			
		} 
		return vresultado;
	}
}
