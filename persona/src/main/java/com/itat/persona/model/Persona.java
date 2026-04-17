package com.itat.persona.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa la entidad Persona que se almacena en MongoDB Atlas.
 * Esta clase mapea los datos a la colección "personas".
 */
@Document(collection = "personas")
public class Persona {

    @Id
    private String id; 
    private String nombre;
    private String apellido;
    private int edad;

    /**
     * Constructor vacío requerido por Spring y MongoDB para la instanciación de objetos.
     */
    public Persona(){}

    /**
     * Constructor con parámetros para inicializar una nueva persona.
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param edad La edad de la persona.
     */
    public Persona (String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // --- Getters y Setters ---

    /**
     * Obtiene el identificador único de la persona.
     * @return El ID generado por MongoDB.
     */
    public String getId(){
        return id;
    }

    /**
     * Asigna el identificador único de la persona.
     * @param id El ID único de la base de datos.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre almacenado.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Asigna un nombre a la persona.
     * @param nombre El nombre a establecer.
     */
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * @return El apellido almacenado.
     */
    public String getApellido(){
        return apellido;
    }

    /**
     * Asigna un apellido a la persona.
     * @param apellido El apellido a establecer.
     */
    public void setApellido (String apellido){
        this.apellido = apellido;
    }

    /**
     * Obtiene la edad de la persona.
     * @return La edad actual.
     */
    public int getEdad(){
        return edad;
    }

    /**
     * Asigna la edad a la persona.
     * @param edad La edad a establecer.
     */
    public void setEdad (int edad){
        this.edad = edad;
    }
}