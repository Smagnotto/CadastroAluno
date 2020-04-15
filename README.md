# CadastroAluno
Sistema desenvolvimento para gerenciamento de alunos no novo cartão de crédito da Fiap. (Trabalho de Spring Framework)

## Inicio
Estas instruções irão lhe ensinar como executar uma versão local para densenvolvimento.

### Pré-requisitos
IDE Java (Eclipse, IntelliJ, etc.).


### Installing
Copiar a versão mais recente do repositório:
```
https://github.com/Smagnotto/CadastroAluno
```

Utilizar ela em sua IDE.

## Executando os testes

Utilizar os testes unitários já disponíveis com o código.  

Para testes integrados, utilizar a biblioteca do Postman dentro do projeto:
```
https://github.com/Smagnotto/CadastroAluno/tree/master/postman
```
Ou utilizar a interface do swagger:
```
http://localhost:8080/swagger-ui.html
```

## Implantação

Para implantação em ambiente produtivo, é necessária a troca do banco de dados de H2 para o de sua preferência.
Além da inibição da opção ddl-auto do hibertane, pois não é ma boa prática para produção.


## Construído com
* [Maven](https://maven.apache.org/) - Gerenciador de dependências
* [Spring](https://spring.io) - Java Framework
* [H2 Database Engine](https://www.h2database.com) - Banco de dados

## Autores
Nome                  | RM
--------------------- | ------
Bruno Gea             | 333475
Diego Smagnotto       | 333886
Eduardo Matoso        | 333906
Felipe da Costa Silva | 333862
Tiago Langoni         | 333947