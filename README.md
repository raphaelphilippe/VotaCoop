# VotaCoop
Desenvolvimento de um projeto baseado em um desafio proposto pela CWI Software. Trata-se da implementação backend, em Java com Spring Boot, de um programa capaz de gerenciar Pautas e Sessões de votação de uma cooperativa.

Informações sobre a aplicação: Vota Coop

- O projeto está sendo desenvolvido com o compilador JavaSE-11.
- A aplicação está configurada para rodar na porta 8081.
- O banco de dados H2 está sendo utilizado para persistir os dados e neste momento está configurado para que a base de dados seja recriada a cada restart da aplicação.
- Os seguintes fluxos foram implementados:
	Criação, update e pesquisa de Usuários;
	Criação, update e pesquisa de Pautas;
	Criação e pesquisa de Sessões de Votação;
	Criação e pesquisa de Votos;

- As regras de negócio necessárias para uma possível implementação de deleções de dados estão sendo avaliadas.
- O processamento dos status das Sessões de Votação e das respectivas Pautas (relacionamento um para um) é dinâmico e realizado na requisição da pesquisa, onde a quantidade de votos SIM e NÃO são exibidos no corpo da Sessão e o resultado do calculo que mostra o voto vencedor é exibido no corpo da Pauta (SIM, NAO ou EMPATE).
- Foram implementadas validações para garantir a integridados dos dados à serem salvos no banco.
- Tarefa boonus 1, validação de CPF via API externa, implementada.

- Implementações no road map:
	Versionamento das APIs;
	Implementação de testes unitários;
	E eventualmente as demais tarefas bonus do desafio;


Criação de pautas (POST) - /pautas | Edição de Pautas (PUT) /pautas/{id} :

	Corpo da requisição:

		{
			"descricao" : "Descrição da Pauta à ser votada, a pergunta que deverá ser respondida por SIM ou NÂO conforme votação."
		}

	Resultado esperado:

		{
       			"id": 3,
        		"descricao": "Descrição da Pauta à ser votada, a pergunta que deverá ser respondida por SIM ou NÂO conforme votação.",
        		"statusPauta": "ABERTA",
        		"dataCriacaoPauta": "31/07/2021 12:32",
       			"resultadoVotacao": null,
        		"sessaoVotacao": null
		}

Criação de Sessões de Votação (POST) - /sessao :

	Parametros da requisição:
	
		/sessao?idPauta=3&prazoSessao=00:00 , onde:

		idPauta=3: É a pauta à qual esta Sessão deverá ser relacionada no banco de dados;

		prazoSessao=00:00: É a string no formato HH:mm que estabelecerá o tempo que a sessão deverá possuir. Caso este parâmetro seja nulo ou "00:00", a Sessão automaticamente permanecerá aberta para votações por 1 minuto (00:01).

	Resultado esperado
		
		{
        		"id": 3,
        		"dataHoraInicioSessao": "31/07/2021 13:14",
        		"tempoPrazo": "01:00",
        		"dataHoraFinalSessao": "31/07/2021 14:14",
        		"statusSessao": "VOTACAO_ABERTA",
        		"qtdSim": 0,
        		"qtdNao": 0
    		}
        
 
A documentação está disponível via Swagger em:
  http://localhost:8081/swagger-ui.html
 
 
 
 
 
