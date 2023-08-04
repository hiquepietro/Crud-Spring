package com.pietro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pietro.model.Aula;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CursoDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5 , max = 100) String nome,
        @NotNull @Length( max = 10) @Pattern(regexp = "Back-end|Front-end") String categoria,
        List<Aula> aulas) {


}
