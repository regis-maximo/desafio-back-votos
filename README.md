# API REST
## Resumo
Essa API foi feita com Java em sua verão 8 junto com Spring Boot, banco de dados postgreSQL e com uso
das tecnologias abaixo: 

- Spring Boot DevTolls = para não ter que reiniciar o servidor toda vez que fizer alguma alteração no código.
- Spring Data JPA = para fazer pesistência dos dados.
- PostgreSQL Driver = para poder se conectar ao banco de dados postgres.
- Spring Web = para poder trabalhar com as requisições Web.
- Spring Boot = para poder dá o boot inicial do sistema sem precisar fazer muitas configurações, pois essa responsabilidade fica com o Spring Boot.
- RestAssured = para poder fazer os testes dos endpoints.
- Junit = testes.
- Postman = testes.
Essas tecnologias listadas acima foi minha escolha por ser tecnologias altamente competentes para a craição de API's e com poucas configurações você já
o ambiente de produção está preparado para o que é mais importe que é a regra de negócio do projeto. 

um exemplo de resposta de voto [Heroku- back-votos](https://back-votos.herokuapp.com/votacao/resultado?pauta=P_1)

### Objetivo 
A API tem dois endpoints de url e essas endpoints tem o objetivo de fazer uma simulção de uma votação de associados. Por exemplo: 
a url **https://back-votos.herokuapp.com/votacao?pauta=P_1&idAssociado=1&resp=s** 
faz uma votação e para valer uma votação o associado tem que já estar cadastrado no banco de dados caso contrário não será permida a votação.
Já com a url **https://back-votos.herokuapp.com/votacao/resultado?pauta=<pauta>** mostra o resultado parcial dos votos.

### banco de dados
banco de dados(postgreSQL) = votacao
votacao_pessoa, ex:
id  pauta  resposta  id_associado
1   P_1		S	1
2   P_1		N       2
3   P_2		S       1
4   P_1		S       3

associados obs: já terá associados cadastrados
1	João
2	Maria
3	José
4	Paulo
5	Julia
6	Marcos
7	Renata

votacao_resultado
id  pauta  qtd_votos

obs: tabela votacao_resultado está servindo apenas de modelo como nesse
projeto não está deletando(resetando) resultados de votação.

### URL
endpoints:
https://back-votos.herokuapp.com/votacao?pauta=<pauta>&idAssociado=<idAssociado>&resp=<s/n>
informar as chaves e seu valor:
KEY			value
pauta			<pauta>
idAssociado		<1-4>
resp			<s/n>

https://back-votos.herokuapp.com/votacao/resultado?pauta=<pauta>
retorno:
{
    "pauta": "P_1",
    "votosSim": 3,
    "votosNao": 1
}

### hospedagem
A api está hospedada no heroku e está disponivel em [Heroku- back-votos](https://back-votos.herokuapp.com/votacao/resultado?pauta=P_1).
