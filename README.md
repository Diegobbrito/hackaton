# Pos Tech Hackaton

Projeto desenvolvido para o Hackaton da Pos Tech FIAP+Alura.

Aplicação para criação e gerenciamento de ponto eletrônico.

## Link da projeto no SonarCloud
-  [SonarCloud - Hackaton](https://sonarcloud.io/project/overview?id=Diegobbrito_hackaton)

## OWASP ZAP
- Foram realizados testes de segurança na aplicação
- O relatorio se encontra na pasta [docs](https://github.com/Diegobbrito/hackaton/tree/main/docs)

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

Arquivos para scale:

    7. cronjob.yaml
    8. hpa.yaml

## Stack utilizada

**Banco de dados:** Mysql

**Back-end:** Java, Springboot

## Arquitetura monolitica
Optamos pela arquitetura monolitica para este projeto por causa de:
- Número pequeno de endpoints requisitados para mvp
- Manutenção e controle de codigo
- Deploy de apenas uma peça
- Facilidade no controle de scale e monitoração no mvp

Entendemos que para a criação da segunda fase, uma arquitetura com microsserviços seria mais adequada:
- Maior quantidade de devs trabalhando
- Deploys de funcionalidades independentes
- Controle e manutenção de código de serviços menores
- Utilização de filas para comunicação assincrona na geração de relatórios

### Calculo do uso de dados

![DB](https://github.com/Diegobbrito/hackaton/blob/main/docs/storage.jpg)

## Infra usada com OpenShift
#### Deployment
![deploy](https://github.com/Diegobbrito/hackaton/blob/main/docs/deploy.jpg)
#### Rota segura
![deploy](https://github.com/Diegobbrito/hackaton/blob/main/docs/rota.jpg)
#### Hpa - AutoScale
- Utilizado minimo de 2 e maximo de 10
- Ideal avaliar por meio de Stress Test a quantidade real minima e máxima necessária
![deploy](https://github.com/Diegobbrito/hackaton/blob/main/docs/hpa.jpg)
#### CronJobs 
- Utilizado para scale no ínicio e final dos horários de pico da aplicação.
- Ideal avaliar por meio de Stress Test a quantidade minima necessária nos horários de pico e pós
![deploy](https://github.com/Diegobbrito/hackaton/blob/main/docs/cronjobs.jpg)

## Autores

- [Diego B Brito](https://github.com/Diegobbrito)
- [Gustavo Joia](https://github.com/GustavoJoiaP)
