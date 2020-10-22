package com.desafiobackvotos.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.desafiobackvotos.model.VotacaoPessoa;

public interface VotacaoPessoaRepository extends JpaRepository<VotacaoPessoa, Long> {

	@Transactional
	@Modifying
	@Query("select p from VotacaoPessoa p WHERE p.idAssociado = ?1")
	VotacaoPessoa findByIdAssociado(long id);
}
  