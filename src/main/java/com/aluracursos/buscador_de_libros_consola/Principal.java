package com.aluracursos.buscador_de_libros_consola;

import com.aluracursos.buscador_de_libros_consola.model.DatosLibro;
import com.aluracursos.buscador_de_libros_consola.model.Libro;
import com.aluracursos.buscador_de_libros_consola.model.RespuestaGutendex;
import com.aluracursos.buscador_de_libros_consola.repository.AutorRepository;
import com.aluracursos.buscador_de_libros_consola.repository.LibroRepository;
import com.aluracursos.buscador_de_libros_consola.service.ConsumoAPI;
import com.aluracursos.buscador_de_libros_consola.service.ConvierteDatos;
import com.aluracursos.buscador_de_libros_consola.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    //private final String API_KEY = "noAplica";
    private ConvierteDatos conversor = new ConvierteDatos();    
    List<DatosLibro> datosLibro;

    private final LibroRepository libroRepo;
    private final AutorRepository autorRepo;
    private final LibroService libroService;

    public Principal(LibroRepository libroRepo,
                     AutorRepository autorRepo,
                     LibroService libroService) {
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
        this.libroService = libroService;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;

                case 4:
                    autoresVivosEnAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private RespuestaGutendex getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));
        return conversor.obtenerDatos(json, RespuestaGutendex.class);
    }

    private void buscarLibroWeb() {
        RespuestaGutendex respuesta = getDatosLibro();

        if (respuesta.resultados().isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }

        DatosLibro datosLibro = respuesta.resultados().get(0);

        libroService.guardarLibro(datosLibro);
    }


    private void listarLibros() {
        libroRepo.findAll().forEach(libro ->
                System.out.printf("""
            Título: %s
            Autor: %s
            Idioma: %s
            Descargas: %.0f
            ------------------
            """,
                        libro.getTitulo(),
                        libro.getAutor().getNombre(),
                        libro.getIdioma(),
                        libro.getNumeroDescargas()
                )
        );
    }

    private void listarAutores() {
        autorRepo.findAll().forEach(autor ->
                System.out.printf("""
            Autor: %s
            Nacimiento: %d
            Fallecimiento: %d
            ------------------
            """,
                        autor.getNombre(),
                        autor.getFechaNacimiento(),
                        autor.getFechaFallecimiento()
                )
        );
    }

    private void autoresVivosEnAnio() {
        System.out.print("Ingrese el año: ");
        int anio = teclado.nextInt();
        teclado.nextLine();

        autorRepo.autoresVivosEn(anio)
                .forEach(a -> System.out.println(a.getNombre()));
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese idioma (ES, EN, FR, PT): ");
        String idioma = teclado.nextLine();

        libroRepo.findByIdiomaIgnoreCase(idioma)
                .forEach(l -> System.out.println(l.getTitulo()));
    }


}
