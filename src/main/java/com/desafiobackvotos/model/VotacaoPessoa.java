package com.desafiobackvotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votacao_pessoa")
public class VotacaoPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "id_associado")
	private long idAssociado;
	private String pauta;
	private char resposta;

	public VotacaoPessoa() {
	}

//	 construtor recebe um Associado se exixtir associado cadastrado e atribui
//	 seu id ao atributo de instância idAssociado da classe VotacaoPessoa
	public VotacaoPessoa(String pauta, char resposta, long idAssociado) {
		this.pauta = pauta;
		this.resposta = resposta;
		this.idAssociado = idAssociado;
	}

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

	public char getResposta() {
		return resposta;
	}

	public void setResposta(char resposta) {
		this.resposta = resposta;
	}

	public long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(long idAssociado) {
		this.idAssociado = idAssociado;
	}

}
