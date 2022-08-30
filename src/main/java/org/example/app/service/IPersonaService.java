package org.example.app.service;

import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Persona;

import java.util.List;

public interface IPersonaService {
    void insertarPersona(Persona persona);
    void borrarPersona(Integer id);
    List<Persona> listarPersonas();
    PersonaResponseDTO actualizarPersona(PersonaDTO persona, Integer id);
}
