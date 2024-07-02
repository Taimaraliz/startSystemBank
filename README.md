## Start System Bank

📌 Versão
1.0

### 🚀 Informações Gerais:
 
O projeto tem como objetivo criar uma API de micro serviço de uma agência bancario 
implementada em Java com Spring Boot.
Criado como projeto final do bootcamp Afrocódigos, realizado pela Olabi. Trilha Back-End.

-------------------------------------------------------------------------------------
### 🛠️ Construido com:

A API foi criada com java e sprig boot, utilizando o padrão de projeto MVC - Model View e 
Controller.

 * Java 17
 * spring Boot
 * Maven

🔧 Instalação

 * IDE de sua preferencia, usei intellij
 * Postgres
 * Insomnia

⌨️ Como Rodar o Projeto
O projeto é gerenciado pelo Maven, para usa-lo basta importa-lo para uma IDE.

Configurações do banco de dados
Você pode criar um banco de dados PostgreSQL com o nome o nome de sua preferência, porém
é necessario adequar o projeto de acordo com as suas configurações.Para isso abra 
o arquivo application.properties, localizado em src/main/resources/application.properties
e altere os seguintes comandos ao arquivo:

spring.datasource.url = jdbc:postgresql://localhost:5432/nome-do-seu-banco-de-dados
spring.datasource.username = seu-usuario
spring.datasource.password = sua-senha

Execute o projeto através do IDE, abra um navegador de sua preferência.

------------------------------------------------------------------------------

⌨️  Endiponts 

Método           |URL	                   | Ações                                     
-----------------|-------------------------|-------------------------------------------
 POST            |  /clientes/cadastrar   | Cadastra um novo cliente.                   
 POST            | /clientes/login        | Realiza login de um cliente.               
 GET             | /clientes/{cpf}        | Obtém os detalhes de um cliente pelo CPF.  
 GET             | /clientes/{id}/saldo   | Consulta o saldo de um cliente específico. 
 GET             | /clientes              | Lista todos os clientes.                   
 PUT             | /clientes/{id}         | Atualiza os dados de um cliente específico.


⌨️ Rotas                   |URL	                                                      
------------------------------|-------------------------
 contas/corrente/pix          |  Realiza pagamento via Pix de uma conta Corrente.                 
 /contas/pagamento/pix         | Realiza pagamento via Pix de uma conta Pagamento.               
 /contas/deposito              | Realiza depósito em uma conta.  
 /contas/pagamento             | Realiza pagamento de uma conta. 
 /contas/transferencia         | Realiza transferência entre contas.                   
 /contas/saque                 | Realiza saque de uma conta.

------------------------------------------------------------------------------------------

⌨️ Exemplo de Requisição - Request

```
 {
  "nome": "Maura Eduarda",
  "cpf": "235968469532"
  "email": "MauraEdu@example.com.br",
  "endereco": "Rua maura maura, 789, São Paulo",
  "rendaSalarial": 9000.00,
  "senha": "senha230"
}
```
⌨️ Exemplo de Requisição - Response

```
{
  "id": 1,
  "nome": "Maura Eduarda",
  "cpf": "235968469532",
  "email": "MauraEdu@example.com.br",
  "endereco": "Rua maura maura, 789, São Paulo",
  "rendaSalarial": 9000.00,
  "senha": "senha230",
  "contas": [
    {
      "id": 01,
      "saldo": 1.200,
      "tipo": "Corrente",
      "chequeEspecial": 6000.00,
      "transacoes": []
    }
  ]
}

```