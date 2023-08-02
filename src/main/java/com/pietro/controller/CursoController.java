package com.pietro.controller;

import com.pietro.model.Curso;


import com.pietro.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




@Validated
@RestController
@RequestMapping("/api/cursos")
public class CursoController {


    private final CursoService cursoService;

    public CursoController( CursoService cursoService) {

        this.cursoService = cursoService;
    }

    @GetMapping
    public @ResponseBody List<Curso> list() {
        return cursoService.list();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable @NotNull @Positive Long id) {
        return cursoService.findById(id);

    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Curso  create(@RequestBody @Valid Curso curso) {
        return cursoService.create(curso);
   }
   @PutMapping("/{id}")
   public Curso update(@PathVariable @NotNull @Positive Long id,
                       @RequestBody @Valid Curso curso){
       return cursoService.update(id, curso);

   }

   @DeleteMapping("/{id}")
   @ResponseStatus(code = HttpStatus.NO_CONTENT)
   public void delete(@PathVariable @NotNull @Positive Long id){
       cursoService.delete(id);
   }

}
