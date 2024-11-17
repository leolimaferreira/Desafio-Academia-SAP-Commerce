package com.plataforma.cursos.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.plataforma.cursos.entity.Aluno;
import com.plataforma.cursos.repository.AlunoRepository;

@Service
public class ApiPopulatorService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AlunoRepository alunoRepository;

    public void popularAlunos() {
        String apiUrl = "http://localhost:8080/api/alunos";

        ResponseEntity<Aluno[]> response = restTemplate.getForEntity(apiUrl, Aluno[].class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<Aluno> alunos = Arrays.asList(response.getBody());
            alunoRepository.saveAll(alunos);
        }
    }
}
