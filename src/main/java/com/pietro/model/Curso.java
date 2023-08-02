package com.pietro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@SQLDelete(sql = "UPDATE Curso SET status = 'INATIVO' WHERE id = ?")
@Data
@Entity
@Where(clause = "status = 'ATIVO'")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100 , nullable = false)
    private String nome;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Back-end| Front-end")
    @Column(length = 10 , nullable = false)
    private String categoria;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Ativo| Inativo")
    @Column(length = 10 , nullable = false)
    private String status = "Ativo";

}
