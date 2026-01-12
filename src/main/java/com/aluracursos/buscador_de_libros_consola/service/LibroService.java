package com.aluracursos.buscador_de_libros_consola.service;

import com.aluracursos.buscador_de_libros_consola.model.Autor;
import com.aluracursos.buscador_de_libros_consola.model.DatosAutor;
import com.aluracursos.buscador_de_libros_consola.model.DatosLibro;
import com.aluracursos.buscador_de_libros_consola.model.Libro;
import com.aluracursos.buscador_de_libros_consola.repository.AutorRepository;
import com.aluracursos.buscador_de_libros_consola.repository.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    private final LibroRepository libroRepo;
    private final AutorRepository autorRepo;

    public LibroService(LibroRepository libroRepo, AutorRepository autorRepo) {
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
    }

    public void guardarLibro(DatosLibro datos) {

        if (libroRepo.findByTituloIgnoreCase(datos.titulo()).isPresent()) {
            System.out.println("⚠️ El libro ya está registrado");
            return;
        }

        DatosAutor datosAutor = datos.autores().get(0);

        Autor autor = autorRepo.findByNombre(datosAutor.nombre())
                .orElseGet(() -> {
                    Autor nuevo = new Autor();
                    nuevo.setNombre(datosAutor.nombre());
                    nuevo.setFechaNacimiento(Math.toIntExact(datosAutor.anioNacimiento()));
                    nuevo.setFechaFallecimiento(Math.toIntExact(datosAutor.anioMuerte()));
                    return autorRepo.save(nuevo);
                });

        Libro libro = new Libro(datos, autor);
        libroRepo.save(libro);

        System.out.println("""
            📘 LIBRO GUARDADO
            Título: %s
            Autor: %s
            Idioma: %s
            Descargas: %.0f
            """.formatted(
                libro.getTitulo(),
                autor.getNombre(),
                libro.getIdioma(),
                libro.getNumeroDescargas()
        ));
    }
}

