<div align="center" width="500px" background-color="white">
  
  ![Comida caseira Logo laranja](https://github.com/juliacapanema/recipes/assets/102003309/d2ac05e5-f2f9-4cb6-9669-0f2438766731)
  
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

## Diagrama de classe UML

Abaixo, diagrama de classe UML para a entidade Recipe, utilizada no projeto

```
+--------------------------------+
|           Recipe               |
+--------------------------------+
| - id: Long                     |
| - title: String                |
| - description: String          |
| - image: String                |
| - ingredients: String          |
| - steps: String                |
| - favorite: Boolean            |
+--------------------------------+
| + Recipe()                     |
| + Recipe(TextField, TextArea,  |
|           TextArea, TextField, |
|           TextArea)            |
| + getId(): Long                |
| + getTitle(): String           |
| + setTitle(String): void       |
| + getDescription(): String     |
| + setDescription(String): void |
| + getImage(): String           |
| + setImage(String): void       |
| + getIngredients(): String     |
| + setIngredients(String): void |
| + getSteps(): String           |
| + setSteps(String): void       |
| + isFavorite(): Boolean        |
| + setFavorite(Boolean): void   |
+--------------------------------+
```
## User History
O projeto Recipes possui a User History (História do Usuário) para as funcionalidades implementadas no sistema:

- Como usuário eu quero cadastrar Minhas Receitas
- Como usuário eu quero consultar Minhas Receitas previamente criadas
- Como usuário eu quero alterar os dados das Minhas Receitas previamente criadas individualmente
- Como usuário eu quero deletar uma Receita previamente criada
- Como usuário eu quero favoritar Minhas Receitas criadas, individualmente
- Como usuário eu quero filtrar Minhas Receitas classificadas como Favoritas
