package com.plataforma.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plataforma.cursos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
