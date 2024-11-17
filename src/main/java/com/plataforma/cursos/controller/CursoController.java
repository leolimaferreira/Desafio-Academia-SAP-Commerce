package com.plataforma.cursos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataforma.cursos.dto.CursoDTO;
import com.plataforma.cursos.entity.Curso;
import com.plataforma.cursos.populator.InscricaoPopulator;
import com.plataforma.cursos.repository.CursoRepository;

@RestController
@RequestMapping("/api")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private InscricaoPopulator populator;
	
	@PostMapping("/cursos")
	public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
		Curso novoCurso = cursoRepository.save(curso);
		return ResponseEntity.ok(novoCurso);
	}
	
	 @PostMapping("/cursos/multiple")
	    public ResponseEntity<List<Curso>> cadastrarCursos(@RequestBody List<Curso> cursos) {
	        List<Curso> novosCursos = cursoRepository.saveAll(cursos);
	        return ResponseEntity.ok(novosCursos);
	    }
}
