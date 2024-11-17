package com.plataforma.cursos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataforma.cursos.dto.AlunoDTO;
import com.plataforma.cursos.entity.Aluno;
import com.plataforma.cursos.populator.InscricaoPopulator;
import com.plataforma.cursos.repository.AlunoRepository;

@RestController
@RequestMapping("/api")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private InscricaoPopulator populator;
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		Aluno novoAluno = alunoRepository.save(aluno);
		return ResponseEntity.ok(novoAluno);
	}
	
	@PostMapping("/alunos/multiple")
    public ResponseEntity<List<Aluno>> cadastrarAlunos(@RequestBody List<Aluno> alunos) {
        List<Aluno> novosAlunos = alunoRepository.saveAll(alunos);
        return ResponseEntity.ok(novosAlunos);
    }
}
