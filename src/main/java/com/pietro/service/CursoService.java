package com.pietro.service;

import com.pietro.dto.CursoDTO;
import com.pietro.dto.mapper.CursoMapper;
import com.pietro.exception.RegistroNaoEncontrado;
import com.pietro.repository.CursoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;



import java.util.ArrayList;
import java.util.List;


@Validated
@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    public List<CursoDTO> list(){

        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toDTO)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public CursoDTO findById( @NotNull @Positive Long id){
        return cursoRepository.findById(id).map(cursoMapper::toDTO)
                .orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public CursoDTO  create(@Valid @NotNull CursoDTO curso) {
        return cursoMapper.toDTO(cursoRepository.save(cursoMapper.toEntity(curso)));
    }

    public CursoDTO update(@NotNull @Positive Long id, @Valid @NotNull CursoDTO curso){
        return cursoRepository.findById(id)
                .map(recordFound -> {
                recordFound.setNome(curso.nome());
                recordFound.setCategoria(this.cursoMapper.convertCategoriaValue(curso.categoria()));
                return cursoMapper.toDTO(cursoRepository.save(recordFound));
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void delete( @NotNull @Positive Long id){

        cursoRepository.delete(cursoRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
