package com.aluracursos.buscador_de_libros_consola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscadorDeLibrosConsolaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuscadorDeLibrosConsolaApplication.class, args);
	}

    private final Principal principal;

    public BuscadorDeLibrosConsolaApplication(Principal principal) {
        this.principal = principal;
    }

    @Override
    public void run(String... args) {
        principal.muestraElMenu();
    }

}
