<h1 align="center">
  TODO List
</h1>

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [H2 database]

## Práticas adotadas
- SOLID
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
 ./mvnw clean package
```
- Executar a aplicação:
```
java -jar target/dytechnology-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints para Tasks

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta Postman:

- Criar Tarefa (POST)

http://localhost:8080/register-task

corpo da requisição
```
  {
   
  "name": "string",
  "description": "string",
  "done": false,
  "priority": 1

  }

```

- Listar Tarefas(GET)
  
http://localhost:8080/tasks
```
 {
   "id": "string",
  "name": "string",
  "description": "string",
  "done": false,
  "priority": 1

  }
```

- Atualizar Tarefa (PUT)

http://localhost:8080/update-task/{id}

corpo da requisição
```
  {
   "id": "string",
  "name": "string",
  "description": "string",
  "done": false,
  "priority": 1

  }
```

- Deletar Tarefa (DELETE)

http://localhost:8080/delete-task/{id}
```
[]
```

Caso a propriedade done seja alterada para TRUE, a task deixa de ser ativa e passa a ser concluída, saindo da lista principal. 

## API Endpoints para Tasks Done

- Listar Tarefas(GET)

http://localhost:8080/done
```
[
  {
    "id": 1,
    "idTask": 1,
    "name": "string",
    "description": "string",
    "done": true,
    "priority": 0
  }
]
```

- Atualizar Tarefa (PUT)
  
http://localhost:8080/update-task/{id}

corpo da requisição
```
 [
  {
    "id": 1,
    "idTask": 1,
    "name": "string",
    "description": "string",
    "done": false,
    "priority": 0
  }
]
```
Caso a propriedade done seja alterada para FALSE novamente, a task volta para a lista principal. 


