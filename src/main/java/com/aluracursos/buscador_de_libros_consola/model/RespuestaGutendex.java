package com.aluracursos.buscador_de_libros_consola.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaGutendex(
        @JsonAlias("results") List<DatosLibro> resultados
) {
}
