package com.desafiobackvotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votacao_resultado")
public class VotacaoResultado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String pauta;
	
	@Column(name = "qtd_votos_sim")
	private long quantidadeVotosSim;
	
	@Column(name = "qtd_votos_nao")
	private long quantidadeVotosNao;
	
	/* 
	 * poderia ser utilizado Lombok para não precisar de gerar os gettes e setters
	 * mas como temos poucos atributos não houve a necessidade. 
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public long getQuantidadeVotosSim() {
		return quantidadeVotosSim;
	}

	public void setQuantidadeVotosSim(long quantidadeVotosSim) {
		this.quantidadeVotosSim = quantidadeVotosSim;
	}

	public long getQuantidadeVotosNao() {
		return quantidadeVotosNao;
	}

	public void setQuantidadeVotosNao(long quantidadeVotosNao) {
		this.quantidadeVotosNao = quantidadeVotosNao;
	}

}
