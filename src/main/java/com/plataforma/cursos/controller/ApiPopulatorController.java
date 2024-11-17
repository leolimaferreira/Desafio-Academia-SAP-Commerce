package com.plataforma.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataforma.cursos.service.ApiPopulatorService;

@RestController
@RequestMapping("/api")
public class ApiPopulatorController {

	@Autowired
	private ApiPopulatorService apiPopulatorService;
	
	@PostMapping("/popular/alunos")
	public ResponseEntity<String> popularAlunos() {
		try {
			apiPopulatorService.popularAlunos();
			return ResponseEntity.ok("Alunos populados com sucesso");
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("Erro ao popular os alunos");
		}
	}
}
