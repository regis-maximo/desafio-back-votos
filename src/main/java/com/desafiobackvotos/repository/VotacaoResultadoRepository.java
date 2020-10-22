package com.desafiobackvotos.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.desafiobackvotos.model.VotacaoPessoa;
import com.desafiobackvotos.model.VotacaoResultado;

public interface VotacaoResultadoRepository extends JpaRepository<VotacaoResultado, Long> {

	@Transactional
	@Modifying
	@Query("select v from VotacaoPessoa v where v.pauta = ?1 and v.resposta = ?2")
	List<VotacaoPessoa> findByVotos(String pauta, char resp);
}
