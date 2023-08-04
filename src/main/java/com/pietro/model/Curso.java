package com.pietro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pietro.enums.Categoria;
import com.pietro.enums.Status;
import com.pietro.enums.conversores.CategoriaConversor;
import com.pietro.enums.conversores.StatusConversor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@SQLDelete(sql = "UPDATE Curso SET status = 'INATIVO' WHERE id = ?")
@Data
@Entity
@Where(clause = "status = 'Ativo'")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5,max = 100)
    @Column(length = 100 , nullable = false)
    private String nome;


    @NotNull
    @Column(length = 10 , nullable = false)
    @Convert(converter = CategoriaConversor.class)
    private Categoria categoria;


    @NotNull
    @Column(length = 10 , nullable = false)
    @Convert(converter = StatusConversor.class)
    private Status status = Status.ATIVO;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "curso")
    private List<Aula> aulas = new ArrayList<>();

}
