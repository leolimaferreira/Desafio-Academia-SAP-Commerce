# Plataforma de Cursos Online

Esta aplicação Java gerencia uma plataforma de cursos online utilizando Hibernate para o mapeamento objeto-relacional (ORM) com três tabelas principais:

## Tabelas

### 1. Tabela Aluno
Representa os alunos cadastrados no sistema. Contém os seguintes campos:
- `id`: Chave primária, auto-gerado
- `nome`: Nome do aluno (String)
- `email`: E-mail do aluno (String)
- `dataCadastro`: Data de cadastro do aluno (Date)

### 2. Tabela Curso
Representa os cursos disponíveis na plataforma. Contém os seguintes campos:
- `id`: Chave primária, auto-gerado
- `nome`: Nome do curso (String)
- `descricao`: Descrição do curso (String)
- `dataCriacao`: Data de criação do curso (Date)

### 3. Tabela Inscrição
Representa as inscrições dos alunos nos cursos. Contém os seguintes campos:
- `id`: Chave primária, auto-gerado
- `aluno_id`: Chave estrangeira para a tabela `Aluno`
- `curso_id`: Chave estrangeira para a tabela `Curso`
- `dataInscricao`: Data da inscrição do aluno (Date)

## Relacionamento entre as tabelas
- **Aluno e Curso**: Relação muitos-para-muitos, mapeada por meio da tabela `Inscricao`.

## Requisitos de Implementação

### 1. Controller e Endpoints
Foi implementado controladores Spring MVC com os seguintes endpoints REST:
- **Cadastrar alunos**: Endpoint para cadastrar alunos no sistema.
- **Cadastrar cursos**: Endpoint para cadastrar cursos na plataforma.
- **Inscrever um aluno em um curso**: Endpoint para inscrever um aluno em um curso.
- **Listar todos os cursos em que um aluno está inscrito**: Endpoint para listar todos os cursos aos quais um aluno está inscrito.
- **Listar todos os alunos inscritos em um determinado curso**: Endpoint para listar todos os alunos que estão inscritos em um curso específico.

### 2. Populator e DTO
- **InscricaoPopulator**: Responsável por converter as entidades `Aluno` e `Curso` para DTOs (`AlunoDTO`, `CursoDTO`).
- **DTOs**: Utilização de DTOs no Controller, evitando expor as entidades diretamente nas respostas da API.

### 3. Banco de Dados
- Utilização do banco de dados **H2** configurado com Hibernate, permitindo um banco de dados em memória para testes e desenvolvimento.
