package com.desafiobackvotos.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobackvotos.model.Associado;
import com.desafiobackvotos.model.VotacaoDisplay;
import com.desafiobackvotos.model.VotacaoPessoa;
import com.desafiobackvotos.model.VotacaoResultado;
import com.desafiobackvotos.repository.AssociadoRepository;
import com.desafiobackvotos.repository.VotacaoPessoaRepository;
import com.desafiobackvotos.service.Votacao;

@RestController
@RequestMapping(value = "/votacao")
public class VotacaoController {

	@Autowired
	private VotacaoPessoaRepository votacaoPessoaRepository;

	@Autowired
	private AssociadoRepository associadoRepository;

	@Autowired
	private Votacao votacao;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<VotacaoPessoa> votar(@RequestParam("pauta") String pauta,
			@RequestParam("idAssociado") long idAssociado, @RequestParam("resp") char resp) {

		try { // procura associado para saber se está cadastrado no banco de dados
			Optional<Associado> associado = associadoRepository.findById(idAssociado);

			try { // procura se a pessoa já voto
				Optional<VotacaoPessoa> vpessoa = votacaoPessoaRepository.findById(idAssociado);
				if (vpessoa.get().getPauta().equals(pauta)) { // se voto não autoriza o voto
					throw new Unauthorized("Não Autorizado para votação.");
				}
				// caso contrário vota
				vpessoa.get().setIdAssociado(associado.get().getId());
				vpessoa.get().setPauta(pauta);
				vpessoa.get().setResposta(resp);

				votacaoPessoaRepository.save(vpessoa.get()); 

				return new ResponseEntity<VotacaoPessoa>(vpessoa.get(), HttpStatus.OK);

			} catch (NoSuchElementException e) { // caso não tenha votado em nenhuma pauta, cria uma votação
				VotacaoPessoa votacao = new VotacaoPessoa(pauta, resp, associado.get().getId());
				votacaoPessoaRepository.save(votacao);
				return new ResponseEntity<VotacaoPessoa>(votacao, HttpStatus.OK);
			}

		} catch (NoSuchElementException e) { // senão encontrar associado informa com uma mensagem
			throw new BeanNotFoundException("associado com id: " + idAssociado + " não encontrado.");

		}
	}
	@GetMapping(value = "/resultado")
	public ResponseEntity<VotacaoDisplay> quantidadeVotos(@RequestParam("pauta") String pauta) {
		VotacaoDisplay vresponse = new VotacaoDisplay();
		// busca votos com resultado sim
		VotacaoResultado vresultadoSim = votacao.verificarVotos(pauta, 's');
		// busca votos com resultado nao
		VotacaoResultado vresultadoNao = votacao.verificarVotos(pauta, 'n');
		// configura o objeto para ser enviado como Json
		vresponse.setPauta(pauta);
		vresponse.setVotosSim(vresultadoSim.getQuantidadeVotosSim());
		vresponse.setVotosNao(vresultadoNao.getQuantidadeVotosNao());
		return new ResponseEntity<VotacaoDisplay>(vresponse, HttpStatus.OK);
	}

	// classe interna para tratamento de exceções
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class BeanNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public BeanNotFoundException(String message) {
			super(message);
		}
	}

	// classe interna para tratamento de exceções
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public class Unauthorized extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public Unauthorized(String message) {
			super(message);
		}
	}

}
