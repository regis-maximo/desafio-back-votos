package com.desafiobackvotos.model;
/*
 * classe responsvel em mostrar um display na resposta com o formato Json
 * poderá mostrar uma mensagem caso seja necessário.
 */
public class VotacaoDisplay {

	private String pauta;
	private long votosSim;
	private long votosNao;
	
	public String getPauta() {
		return pauta;
	}
	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
	public long getVotosSim() {
		return votosSim;
	}
	public void setVotosSim(long votosSim) {
		this.votosSim = votosSim;
	}
	public long getVotosNao() {
		return votosNao;
	}
	public void setVotosNao(long votosNao) {
		this.votosNao = votosNao;
	}
	
}
