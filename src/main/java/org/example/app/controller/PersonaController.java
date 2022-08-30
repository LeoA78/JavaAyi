package org.example.app.controller;

import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Persona;
import org.example.app.service.IPersonaService;
import org.example.app.service.IService;
import org.example.app.service.impl.PersonaServiceImpl;

import java.util.List;

public class PersonaController {
    IPersonaService iPersonaServicios = new PersonaServiceImpl();

    public void agregarPersona(Persona persona){
        iPersonaServicios.insertarPersona(persona);
    }

    public void borrarPersona(Integer id){
        iPersonaServicios.borrarPersona(id);
    }

    public List<Persona> listarPersonas(){
        return iPersonaServicios.listarPersonas();
    }

    public PersonaResponseDTO modificarPersona(PersonaDTO persona, Integer id){
        return iPersonaServicios.actualizarPersona(persona,id);
    }

}
