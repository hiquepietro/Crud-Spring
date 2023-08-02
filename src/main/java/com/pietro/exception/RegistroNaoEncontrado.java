package com.pietro.exception;

public class RegistroNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegistroNaoEncontrado(Long id) {
        super("Registro não encontrado com o id: " + id);

    }

}
