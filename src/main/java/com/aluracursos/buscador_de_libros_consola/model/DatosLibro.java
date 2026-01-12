package com.aluracursos.buscador_de_libros_consola.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id")
        Long id,

        @JsonAlias("title")
        String titulo,

        @JsonAlias("authors")
        List<DatosAutor> autores,

        @JsonAlias("summaries")
        List<String> descripcion,

        @JsonAlias("languages")
        List<String> idiomas,

        @JsonAlias("download_count")
        Integer descargas
) {
}

