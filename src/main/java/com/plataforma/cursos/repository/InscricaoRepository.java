package com.plataforma.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataforma.cursos.entity.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{
	List<Inscricao> findByAlunoId(Long alunoId);
	List<Inscricao> findByCursoId(Long cursoId);
}
