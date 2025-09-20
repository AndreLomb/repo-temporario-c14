# 📚 Sistema de Biblioteca

Este projeto implementa um **Sistema de Gerenciamento de Biblioteca em Java**, permitindo a administração de **usuários, livros e empréstimos**.

O sistema possibilita **cadastrar, consultar, atualizar e remover registros**, além de controlar **empréstimos ativos e devoluções**.

---

## 🚀 Funcionalidades

### 📖 Livros
- ➕ Adicionar novo livro
- 🔍 Consultar livro por **ISBN**
- 📑 Listar todos os livros cadastrados
- ✏️ Atualizar informações de um livro
- 🗑️ Remover livro do acervo
- 🔎 *(Em Desenvolvimento) Buscar livros por título ou autor*

### 👤 Usuários
- ➕ Cadastrar usuários
- 🔍 Buscar usuários por **ID** ou **nome**
- 📑 Listar todos os usuários
- ✏️ Atualizar dados de usuários
- 🗑️ Remover usuários

### *📦 Empréstimos (EM DESENVOLVIMENTO)*
- ➕ Registrar novo empréstimo
- 🔍 Consultar empréstimo por **ID**
- 📑 Listar todos os empréstimos
- 📌 Listar empréstimos **ativos**
- 👥 Buscar empréstimos por usuário
- 🗑️ Remover empréstimo
- ⚠️ Tratamento de exceções para **usuário ou livro não encontrado**

---

## 🏗️ Arquitetura

O sistema segue uma arquitetura em **camadas**, organizada em pacotes:

- **model** → Entidades principais
  - `Livro`
  - `Usuario`
  - `Emprestimo`

- **implementacao** → Implementações das regras de negócio
  - `LivroIMPL`
  - `UsuarioIMPL`

- **implementacao.interfaces** → Contratos das entidades
  - `LivroRegras`
  - `UsuarioRegras`
  - `EmprestimoRegras`

- **service** → Camada de serviço
  - `BibliotecaService`
  - `BibliotecaServiceImpl`

- **exceptions** → Tratamento de erros específicos
  - `EmprestimoException`
  - `UsuarioNaoEncontradoException`
  - `LivroNaoEncontradoException`

- **Main.java** → Classe principal para execução do programa

---

## 📂 Estrutura de Pastas

## 📂 Estrutura de Pastas

```bash
src/br/c14lab/biblioteca/
 ├── exceptions/
 │   ├── EmprestimoException.java
 │   ├── LivroNaoEncontradoException.java
 │   └── UsuarioNaoEncontradoException.java
 │
 ├── implementacao/
 │   ├── LivroIMPL.java
 │   ├── UsuarioIMPL.java
 │   └── interfaces/
 │       ├── LivroRegras.java
 │       ├── UsuarioRegras.java
 │       └── EmprestimoRegras.java
 │
 ├── model/
 │   ├── Livro.java
 │   ├── Usuario.java
 │   └── Emprestimo.java
 │
 ├── service/
 │   ├── BibliotecaService.java
 │   └── BibliotecaServiceImpl.java
 │
 └── Main.java
````
---
## 🧪 Testes Unitários

Os testes são implementados utilizando **JUnit 5** e **Mockito**, garantindo a qualidade do código.

**Principais testes:**

- ✅ Testes de cadastro, busca, atualização e remoção de livros
- ✅ Testes de exceções personalizadas (`LivroNaoEncontradoException`, `UsuarioNaoEncontradoException`)
- ✅ Testes de busca de usuários por nome e ID
- ✅ Testes de remoção de usuários e tratamento de erros
- ✅ Teste com mock para `buscarPorIsbn`

> **Observação:** há testes que usam a implementação real (`LivroIMPL`, `UsuarioIMPL`) e ao menos um teste demonstrativo com **Mockito** para ensinar/atender ao requisito de mock.

---
## ⚙️ Recursos  Utilizadas

- ☕ **Java 17+**
- 📦 **Maven** para gerenciamento de dependências
- 🧪 **JUnit 5** para testes unitários
- 🛠️ **Mockito** para criação de mocks e testes isolados
- ⚡ **Coleções Java** (`List`, `HashMap`, etc.)
- 🔧 **Exceções personalizadas** para maior clareza no tratamento de erros
---

## ✅ Status do Projeto

- ✔️ Módulo de usuários totalmente implementado
- ✔️ CRUD de livros completo
- ✔️ Testes unitários abrangentes com JUnit e Mockito
- ⏳ Funcionalidades de empréstimo em desenvolvimento

---
