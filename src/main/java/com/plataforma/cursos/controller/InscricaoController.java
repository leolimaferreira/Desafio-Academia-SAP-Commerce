package com.plataforma.cursos.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plataforma.cursos.dto.AlunoDTO;
import com.plataforma.cursos.dto.CursoDTO;
import com.plataforma.cursos.entity.Aluno;
import com.plataforma.cursos.entity.Curso;
import com.plataforma.cursos.entity.Inscricao;
import com.plataforma.cursos.repository.AlunoRepository;
import com.plataforma.cursos.repository.CursoRepository;
import com.plataforma.cursos.repository.InscricaoRepository;

@RestController
@RequestMapping("api/inscricoes")
public class InscricaoController {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping
	public ResponseEntity<Inscricao> inscreverAluno(@RequestParam Long alunoId, @RequestParam Long cursoId) {
		Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

		Inscricao inscricao = new Inscricao();
		inscricao.setAluno(aluno);
		inscricao.setCurso(curso);
		inscricao.setDataInscricao(LocalDate.now());
		
		Inscricao novaInscricao = inscricaoRepository.save(inscricao);

		return ResponseEntity.ok(novaInscricao);
	}

	@GetMapping("/aluno/{alunoId}")
	public List<CursoDTO> listarCursosAluno(@PathVariable Long alunoId) {
		List<Inscricao> inscricoes = inscricaoRepository.findByAlunoId(alunoId);
		return inscricoes.stream().map(inscricao -> new CursoDTO(inscricao.getCurso().getId(),
				inscricao.getCurso().getNome(), inscricao.getCurso().getDescricao())).collect(Collectors.toList());
	}

	@GetMapping("/curso/{cursoId}")
	public List<AlunoDTO> listarAlunosCurso(@PathVariable Long cursoId) {
		List<Inscricao> inscricoes = inscricaoRepository.findByAlunoId(cursoId);
		return inscricoes.stream().map(inscricao -> new AlunoDTO(inscricao.getAluno().getId(),
				inscricao.getAluno().getNome(), inscricao.getAluno().getEmail())).collect(Collectors.toList());
	}
}
