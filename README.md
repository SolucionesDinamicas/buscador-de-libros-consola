📚 #Buscador de Libros – Aplicación de Consola con Spring Boot

Aplicación de consola desarrollada en Java con Spring Boot que permite buscar libros a través de la API pública Gutendex, almacenar la información en una base de datos PostgreSQL y consultar los datos guardados mediante diferentes filtros.

Este proyecto fue desarrollado con fines académicos y de aprendizaje, aplicando buenas prácticas de arquitectura en capas, JPA/Hibernate y consumo de APIs REST.

🚀 Funcionalidades

La aplicación presenta un menú interactivo por consola con las siguientes opciones:

Buscar libro por título

Consulta la API de Gutendex.

Guarda el libro y su autor en la base de datos.

Evita duplicados.

Listar libros registrados

Muestra todos los libros almacenados.

Incluye título, autor, idioma y número de descargas.

Listar autores registrados

Muestra todos los autores guardados en la base de datos.

Listar autores vivos en un año determinado

Permite ingresar un año.

Muestra los autores que estaban vivos en ese periodo.

Listar libros por idioma

Permite filtrar libros por idioma (ES, EN, FR, PT).

🛠️ Tecnologías utilizadas

Java 17

Spring Boot

Spring Data JPA

Hibernate

PostgreSQL

Jackson (JSON parsing)

Maven

API Gutendex (https://gutendex.com
)

🧱 Arquitectura del Proyecto

El proyecto está organizado siguiendo una arquitectura en capas:

├── model          → Entidades JPA y DTOs
├── repository     → Repositorios JPA
├── service        → Lógica de negocio
├── principal      → Interfaz de consola
└── application    → Clase principal (CommandLineRunner)

Capas clave:

DTOs (Records) para mapear la API externa.

Entidades JPA bien normalizadas (Libro ↔ Autor).

Servicios para encapsular la lógica de negocio.

Repositorios para acceso a datos.

🧠 Buenas prácticas aplicadas

✔ Inyección de dependencias por constructor

✔ Separación de responsabilidades

✔ Entidades JPA normalizadas

✔ Uso de Optional para evitar null

✔ Evitar duplicados en base de datos

✔ Manejo correcto de relaciones @ManyToOne y @OneToMany

✔ Constructor vacío obligatorio para JPA

✔ Código limpio y legible

🗄️ Configuración de Base de Datos

La aplicación utiliza PostgreSQL.
Configura las siguientes variables de entorno o edita application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/alura_libros
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true

▶️ Cómo ejecutar el proyecto

Clona el repositorio:

git clone https://github.com/tu-usuario/buscador-de-libros-consola.git


Accede al proyecto:

cd buscador-de-libros-consola


Ejecuta la aplicación:

mvn spring-boot:run


Usa el menú interactivo desde la consola.

📌 Ejemplo de uso
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir

📈 Posibles mejoras futuras

🔹 Top libros más descargados

🔹 Paginación de resultados

🔹 Pruebas unitarias con H2

🔹 Dockerización de PostgreSQL

🔹 Logs con SLF4J en lugar de System.out

👨‍💻 Autor

Martín Londoño
Estudiante de Ingeniería de Software
Proyecto desarrollado como parte de formación académica y práctica en Spring Boot y Java.
