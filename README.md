Questão 1
Implemente uma aplicação Java para o gerenciamento de uma plataforma de cursos online. A aplicação deve utilizar Hibernate para fazer o mapeamento objeto-relacional (ORM) com três tabelas:
  1.	Tabela Aluno: Representa os alunos cadastrados no sistema. A tabela deve conter os seguintes campos:
    o	id (Chave primária, auto-gerado)
    o	nome (String)
    o	email (String)
    o	dataCadastro (Data)
  2.	Tabela Curso: Representa os cursos disponíveis na plataforma. A tabela deve conter os seguintes campos:
    o	id (Chave primária, auto-gerado)
    o	nome (String)
    o	descricao (String)
    o	dataCriacao (Data)
  3.	Tabela Inscrição: Representa a inscrição dos alunos nos cursos. A tabela deve conter os seguintes campos:
    o	id (Chave primária, auto-gerado)
    o	aluno_id (Chave estrangeira para a tabela Aluno)
    o	curso_id (Chave estrangeira para a tabela Curso)
    o	dataInscricao (Data)
  A relação entre as tabelas deve ser:
    o	Aluno e Curso: Relação muitos-para-muitos, mapeada por meio da tabela Inscricao.
  Requisitos da Implementação:
    1.	Controller e Endpoints:
    o	Implemente controladores Spring MVC para expor os endpoints REST que possibilitem:
      .	Cadastrar alunos e cursos.
      .	Inscrever um aluno em um curso.
      .	Listar todos os cursos em que um aluno está inscrito.
      .	Listar todos os alunos inscritos em um determinado curso.
    2.	Populator e DTO:
      o	Crie um InscricaoPopulator para converter as entidades Aluno e Curso para DTOs (AlunoDTO, CursoDTO).
      o	Utilize os DTOs no Controller, evitando expor as entidades diretamente.
    3.	Banco de Dados:
      o	Utilize o banco H2 configurado com Hibernate.
