package com.aluracursos.buscador_de_libros_consola.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Long anioNacimiento,
        @JsonAlias("death_year") Long anioMuerte
) {
}

