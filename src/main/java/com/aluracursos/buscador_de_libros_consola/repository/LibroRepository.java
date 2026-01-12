package com.aluracursos.buscador_de_libros_consola.repository;

import com.aluracursos.buscador_de_libros_consola.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloIgnoreCase(String titulo);

    List<Libro> findByIdiomaIgnoreCase(String idioma);
}

