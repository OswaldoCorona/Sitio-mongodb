package com.itat.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * Esta clase se encarga de configurar e iniciar todo el ecosistema del proyecto ITAT,
 * incluyendo la conexión automática con MongoDB Atlas y el servidor embebido.
 * * @author Oswaldo Corona
 */
@SpringBootApplication
public class PersonaApplication {

    /**
     * Punto de entrada principal (Main) del programa.
     * Ejecuta la aplicación utilizando SpringApplication.run.
     * * @param args Argumentos de línea de comandos que se pueden pasar al iniciar la app.
     */
    public static void main(String[] args) {
        SpringApplication.run(PersonaApplication.class, args);
    }

}