# 📚 Biblioteca UFPI

Sistema de **gestão de biblioteca** em Java, desenvolvido na disciplina de Programação Orientada a Objetos (UFPI). Controla acervo, locatários, empréstimos e reservas, com interface gráfica em **JavaFX** e uma versão em linha de comando.

## Funcionalidades

- Cadastro e consulta de livros (acervo) com persistência via DAO + JDBC (MySQL)
- Locatários, empréstimos e reservas
- Regras configuráveis de empréstimo (`Configuracao`)
- Interface JavaFX (`Main.fxml` + CSS) e versão CLI (`MainCLI`)

## Modelo

`Biblioteca` · `Livro` · `Locatario` · `Emprestimo` · `Reserva` · `Configuracao`

## Tecnologias

Java · JavaFX · JDBC · MySQL

## Como rodar

1. Crie o banco `biblioteca_ufpi` no MySQL local (usuário/senha em `src/Connections/ConnectionFactory.java`)
2. Abra o projeto no IntelliJ IDEA (JavaFX e o conector MySQL nas dependências)
3. Execute `Main` (GUI) ou `MainCLI` (terminal)

## Autor

Feito por [Amós Magalhães](https://github.com/amslimaa).
