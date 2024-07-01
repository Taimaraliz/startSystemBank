## Start System Bank

📌 Versão
1.0


### 🚀 Informações Gerais:
Criado como projeto final do bootcamp Afrocódigos, realizado pela Olabi. Trilha Back-End. 
O projeto tem como objetivo criar uma API de micro serviço de uma agencia bancario implementada em Java com Spring Boot.


### 🛠️ Construido com:
 * Java 17
 * spring Boot




🔧 Instalação




⌨️  Rotas 


|Método           |URL	       | Ações                                 |
|-----------------|---------------------------------------------------------------------|
| POST            |  /clientes/cadastrar	 | Cadastra um novo cliente                   |
| POST            | /clientes/login        | Realiza login de um cliente.               |
| GET             | /clientes/{cpf}        | Obtém os detalhes de um cliente pelo CPF.  |
| GET             | /clientes/{id}/saldo   | Consulta o saldo de um cliente específico. |
| GET             | /clientes              | Lista todos os clientes.                   |
| PUT             | /clientes/{id}         | Atualiza os dados de um cliente específico.|
-----------------------------------------------------------------------------------------


⌨️  Endpoints                       
|------------------------------------------------------------------------------|
|  /contas/corrente/pix	Realiza um pagamento via Pix de uma conta Corrente.    |
|  /contas/pagamento/pix	Realiza um pagamento via Pix de uma conta Pagamento. |
|  /contas/deposito	Realiza um depósito em uma conta.                          |
|  /contas/pagamento	Realiza um pagamento de uma conta.                       |
|  /contas/transferencia	Realiza uma transferência entre contas.              |
| /contas/saque	Realiza um saque de uma conta.                                 |
--------------------------------------------------------------------------------



⌨️ Como Rodar o Projeto

#### Instalação
O projeto é gerenciado pelo Maven, então para usa-lo basta importa-lo para uma IDE.

Configurações do banco de dados
Você pode criar um banco de dados PostgreSQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. 
Para isso abra o arquivo application.properties, localizado em src/main/resources/application.properties e altere os seguintes comandos ao arquivo:

spring.datasource.url = jdbc:postgresql://localhost:5432/nome-do-seu-banco-de-dados
spring.datasource.username = seu-usuario
spring.datasource.password = sua-senha
Execução
Execute o projeto através do IDE, abra um navegador de sua preferência e digite: http://localhost:8080/swagger-ui/#/ para acessar a interface do Swagger para acessar os métodos de requisição



⚙️  Comunicação



