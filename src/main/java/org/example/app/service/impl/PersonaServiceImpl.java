package org.example.app.service.impl;

import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Persona;
import org.example.app.mapper.PersonaMapperImpl;
import org.example.app.service.IPersonaService;
import org.example.app.service.IService;

import java.util.ArrayList;
import java.util.List;

public class PersonaServiceImpl implements IPersonaService {
     private PersonaMapperImpl personaMapperImplement = new PersonaMapperImpl();

    @Override
    public void insertarPersona(Persona persona) {
        Persona persona1 = new Persona();
        persona1 = persona;

        System.out.println("Se inserta a " + persona1.toString());
    }

    @Override
    public void borrarPersona(Integer id) {
        System.out.println("Se borró una Persona id: " + id);
    }

    @Override
    public List<Persona> listarPersonas() {

        Persona persona1 = new Persona();
        persona1.setNombre("Lionel");
        persona1.setApellido("Messi");

        Persona persona2 = new Persona();
        persona2.setNombre("Cristiano");
        persona2.setApellido("Ronaldo");

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(persona1);
        lista.add(persona2);
        return lista;
    }

   /* @Override
    public Persona actualizarPersona(Persona persona, Integer id) {
        Persona personaModificada = new Persona();

        personaModificada.setNombre(persona.getNombre());
        personaModificada.setApellido(persona.getApellido());


        return personaModificada;
    } */

    public PersonaResponseDTO actualizarPersona(PersonaDTO personaDTO, Integer id) {
        Persona personaModificada = new Persona();

        personaModificada.setNombre(personaDTO.getNombre());
        personaModificada.setApellido(personaDTO.getApellido());

        return personaMapperImplement.toEntityToDto(personaModificada);

    }

/*
    @Override
    public void insertar(String nombre, String apellido) {
        System.out.println("Se insertó una Persona");
    }

    @Override
    public void borrar(Integer id) {
        System.out.println("Se borró una persona");
    }

    @Override
    public String modificar(String nombre, String apellido) {
        return "Se modificó la Persona " + nombre + " " + apellido;
    }

    @Override
    public String listarTodos() {
        return "Mostrando todas las personas";
    }
    */

}