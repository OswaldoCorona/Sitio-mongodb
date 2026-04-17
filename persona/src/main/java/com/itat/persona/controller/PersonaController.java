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
    
    @Autowired
    private PersonaRepository personaRepository;

    /**
     * Carga la página de inicio (Landing Page) del sistema.
     * @return El nombre de la plantilla HTML "home".
     */
    @GetMapping("/")
    public String home() {
        return "home"; 
    }

    /**
     * Prepara el modelo con la lista de personas y un objeto vacío para el formulario.
     * @param model Objeto de Spring UI para enviar datos a la vista.
     * @return El nombre de la plantilla HTML "crud-persona".
     */
    @GetMapping("/personas")
    public String mostrarFormularioYLista(Model model) {
        model.addAttribute("persona", new Persona()); 
        model.addAttribute("personas", personaRepository.findAll());
        return "crud-persona";
    }

    /**
     * Procesa el envío del formulario para registrar una nueva persona en MongoDB.
     * @param persona El objeto con los datos capturados en el formulario.
     * @return Una redirección a la ruta de la lista de personas.
     */
    @PostMapping("/guardar")
    public String guardarPersona(Persona persona) {
        personaRepository.save(persona); 
        return "redirect:/personas";
    }

    /**
     * Elimina un registro de la base de datos basado en su identificador único.
     * @param id El identificador (String) de la persona a eliminar.
     * @return Una redirección a la ruta de la lista de personas.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable String id) {
        personaRepository.deleteById(id);
        return "redirect:/personas";
    }

    /**
     * Busca los datos de una persona para cargarlos en el formulario de edición.
     * @param id El identificador de la persona a editar.
     * @param model Objeto para pasar los datos de la persona encontrada a la vista.
     * @return El nombre de la plantilla "edit-persona" o redirección si no existe.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Persona persona = personaRepository.findById(id).orElse(null);

        if (persona != null) {
            model.addAttribute("persona", persona);
            return "edit-persona"; 
        }
        return "redirect:/personas";
    }

    /**
     * Sobrescribe los datos de una persona existente con la nueva información.
     * @param id El identificador de la persona que se va a actualizar.
     * @param personaActualizada El objeto con los nuevos datos cargados.
     * @return Una redirección a la lista de personas actualizada.
     */
    @PostMapping("/actualizar/{id}")
    public String actualizarPersona (@PathVariable String id, Persona personaActualizada) {
        personaActualizada.setId(id); 
        personaRepository.save(personaActualizada);
        return "redirect:/personas";
    }
}