package com.pietro.dto.mapper;

import com.pietro.dto.CursoDTO;
import com.pietro.enums.Categoria;
import com.pietro.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {



    public CursoDTO toDTO(Curso curso){
        if (curso == null) {
            return null;
        }
        return new CursoDTO(curso.getId(), curso.getNome(),curso.getCategoria().getValue(),
                curso.getAulas());

    }

    public Curso toEntity(CursoDTO cursoDTO){

        if (cursoDTO == null) {
            return null;
        }

        Curso curso = new Curso();
        if(cursoDTO.id() != null){
            curso.setId(cursoDTO.id());
        }
        curso.setNome(cursoDTO.nome());
        curso.setCategoria(convertCategoriaValue(cursoDTO.categoria()));
        return curso;
    }

    public Categoria convertCategoriaValue(String value){
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Front-end" -> Categoria.FRONT_END;
            case "Back-end" -> Categoria.BACK_END;
            default -> throw new IllegalArgumentException("Categoria invalida : " + value);
        };
    }
}
