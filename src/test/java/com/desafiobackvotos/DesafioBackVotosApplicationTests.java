package com.desafiobackvotos;

import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.*;

//@SpringBootTest
class DesafioBackVotosApplicationTests {
		
	public DesafioBackVotosApplicationTests() {
		baseURI = "http://localhost:8080/votacao";
	}
	@Test
	void naoTemAssociador() {
		// testa se há um associador cadastrado para poder votar
		long idAssociado = 4;
		String pauta = "P_4";
		char resp = 's';
		
		given().contentType("application/json")
		.when().get(baseURI+"/"+pauta+"/"+idAssociado+"/"+resp)
		.then().statusCode(404);
	}
	
	@Test
	void deveMostrarResultado() {
		String pauta = "P_4";
		
		given().contentType("application/json")
		.when().get(baseURI+"/resultado?pauta="+pauta)
		.then().statusCode(200);
	}
	
}
