package com.plataforma.cursos.populator;

import org.springframework.stereotype.Component;

import com.plataforma.cursos.dto.AlunoDTO;
import com.plataforma.cursos.dto.CursoDTO;
import com.plataforma.cursos.entity.Aluno;
import com.plataforma.cursos.entity.Curso;


@Component
public class InscricaoPopulator {

	public AlunoDTO toAlunoDTO(Aluno aluno) {
		AlunoDTO dto = new AlunoDTO();
		dto.setId(aluno.getId());
		dto.setNome(aluno.getNome());
		dto.setEmail(aluno.getEmail());
		dto.setDataCadastro(aluno.getDataCadastro());
		return dto;
	}
	
	public CursoDTO toCursoDTO(Curso curso) {
		CursoDTO dto = new CursoDTO();
		dto.setId(curso.getId());
		dto.setNome(curso.getNome());
		dto.setDescricao(curso.getDescricao());
		dto.setDataCriacao(curso.getDataCriacao());
		return dto;
	}
}
