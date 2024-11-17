package com.plataforma.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataforma.cursos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
