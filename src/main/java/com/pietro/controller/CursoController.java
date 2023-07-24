package com.pietro.controller;

import com.pietro.model.Curso;
import com.pietro.repository.CursoRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
public class CursoController {

    private final CursoRepository cursoRepository;



    @GetMapping
    public @ResponseBody List<Curso> list(){
        return cursoRepository.findAll();
    }
}
