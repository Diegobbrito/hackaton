# Pos Tech Hackaton

Projeto desenvolvido para o Hackaton da Pos Tech FIAP+Alura.

Aplicação para criação e gerenciamento de ponto eletrônico.

## Link da projeto no SonarCloud
-  [SonarCloud - Hackaton](https://sonarcloud.io/project/overview?id=Diegobbrito_hackaton)


## Como testar a aplicação com docker compose

Faça download do projeto, crie/atualize o arquivo de variaveis e na pasta principal rode o comando no terminal:

```bash
   docker-compose --env-file *.env up -d
```
No navegador, abra a pagina do Swagger da aplicação:
http://localhost:8080/swagger-ui/index.html#/

O Swagger está documentado com exemplos de request.

## Como testar a aplicação com kubernetes

Faça download do projeto e na pasta principal rode os comandos no terminal para cada arquivo, seguindo a ordem:

Banco de dados:
```bash
   kubectl apply -f ./kubernetes/db/<file>.yaml 
```
Arquivos para banco de dados:

    1. secret.yaml
    2. pvc.yaml
    3. service.yaml
    4. deployment.yaml
Aplicação:
```bash
   kubectl apply -f ./kubernetes/app/<file>.yaml 
```
Arquivos para aplicação:

    5. service.yaml
    6. deployment.yaml

## Stack utilizada

**Banco de dados:** Mysql

**Back-end:** Java, Springboot

**Messageria:** RabbitMQ


## Autores

- [Diego B Brito](https://github.com/Diegobbrito)
- [Gustavo Joia](https://github.com/GustavoJoiaP)
