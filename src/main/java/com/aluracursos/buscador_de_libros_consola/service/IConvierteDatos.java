package com.aluracursos.buscador_de_libros_consola.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
