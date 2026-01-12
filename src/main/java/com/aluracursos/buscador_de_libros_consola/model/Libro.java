package com.aluracursos.buscador_de_libros_consola.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "libros",
        uniqueConstraints = @UniqueConstraint(columnNames = "titulo")
)
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    private String idioma;

    private Double numeroDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    // constructor desde DatosLibro
    public Libro(DatosLibro datos, Autor autor) {
        this.titulo = datos.titulo();
        this.idioma = datos.idiomas().get(0);
        this.numeroDescargas = datos.descargas().doubleValue();
        this.autor = autor;
    }
    public Libro(){}//Constructor personalizado para entidades

    public Libro(DatosLibro datosLibro) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "[" + "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", Nombre Autor=" + autor +
                ", Idioma=" + idioma +
                ", Número descargas='" + numeroDescargas + '\'' +
                ", Idioma='" + idioma +
                ']';
    }
}
