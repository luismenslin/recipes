<div align="center" width="500px" background-color="white">
  
  ![recipes-logo](https://github.com/juliacapanema/recipes/assets/102003309/b1398843-01d0-4a67-8e19-f7c056727db9)
  
</div>

## Sobre o projeto

O Recipes é um projeto desenvolvido utilizando o framework Vaadin, para praticar os principais conceitos de Programação Orientada a Objetos e integração com banco de dados utilizando o Java JDBC.

Dessa forma, o projeto é uma pequena aplicação que permite aos usuários registrar suas receitas, efetuar edições nas criações existentes, eliminar registros e marcar suas preferidas para acesso facilitado.

## Rodando a aplicação

O Recipes trata-se de uma aplicação Maven padrão. Para executá-lo é necessário estar rodando um [servidor de banco de dados MySQL](https://dev.mysql.com/downloads/mysql/) e criar um database com o nome de 'recipes':

```
CREATE DATABASE recipes;
```

Com o banco de dados criado, já é possível compilar e rodar o projeto, a partir da linha de comando, digitando `mvnw` (Windows) ou `./mvnw` (Mac e Linux) e, em seguida, ou então a partir de alguma IDE, para o guia de como rodar o projeto em cada IDE, acesse: [como importar projetos Vaadin para diferentes IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans e VS Code).

Após esse procedimento, basta acessar a URL [http://localhost:8080](http://localhost:8080/) em seu navegador e navegar no sistema.
