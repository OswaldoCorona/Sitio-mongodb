package com.itat.persona.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personas") // Esto crea la colección en Mongo
public class Persona {
    @Id
    private String id; // Mongo prefiere String para generar IDs automáticos
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(){}

    public Persona (String nombre, String apellido, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }

    //Getters y setters (necesarios para Thymeleaf)
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido (String apellido){
        this.apellido = apellido;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad (int edad){
        this.edad = edad;
    }
}
