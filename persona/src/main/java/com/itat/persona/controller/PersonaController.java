package com.itat.persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.itat.persona.model.Persona;
import com.itat.persona.repository.PersonaRepository;

@Controller
public class PersonaController {
    
    // Inyectamos el repositorio para interactuar con MongoDB Atlas
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/")
    public String home() {
        return "home"; 
    }

    // Listar todas las personas desde la base de datos
    @GetMapping("/personas")
    public String mostrarFormularioYLista(Model model) {
        model.addAttribute("persona", new Persona()); 
        model.addAttribute("personas", personaRepository.findAll()); // Trae todo de MongoDB
        return "crud-persona";
    }

    // Guardar una nueva persona
    @PostMapping("/guardar")
    public String guardarPersona(Persona persona) {
        // No necesitamos setear ID, MongoDB lo genera automáticamente
        personaRepository.save(persona); 
        return "redirect:/personas";
    }

    // Eliminar por ID (ahora el ID es String)
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable String id) {
        personaRepository.deleteById(id);
        return "redirect:/personas";
    }

    // Mostrar formulario de edición buscando en la base de datos
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        // Buscamos a la persona por su ID en Mongo
        Persona persona = personaRepository.findById(id).orElse(null);

        if (persona != null) {
            model.addAttribute("persona", persona);
            return "edit-persona"; 
        }
        return "redirect:/personas";
    }

    // Actualizar persona
    @PostMapping("/actualizar/{id}")
    public String actualizarPersona (@PathVariable String id, Persona personaActualizada) {
        // Aseguramos que el objeto tenga el ID correcto antes de guardar
        personaActualizada.setId(id); 
        // .save() en Spring Data funciona como "insert" si el ID es nuevo 
        // o como "update" si el ID ya existe en la base de datos
        personaRepository.save(personaActualizada);
        return "redirect:/personas";
    }
}