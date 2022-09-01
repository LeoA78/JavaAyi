package org.example;

import org.example.app.controller.*;
import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Empleado;
import org.example.app.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class DispatcherApp {
    public static void main(String[] args) {
/*
        PersonaController personaController = new PersonaController();
        EmpleadoController empleadoController = new EmpleadoController();
        ClienteController clienteController = new ClienteController();

        Persona persona = new Persona();
        PersonaDTO personaDTO = new PersonaDTO("Carlos","Perez","12345657");
        PersonaResponseDTO personaResponseDTO;

        ClienteDTO clienteDTO = new ClienteDTO(2,"VIP");
        ClienteResponseDTO clienteResponseDTO = clienteController.modificarCliente(clienteDTO,2);

        String nombre = "Carlos";
        String apellido = "Perez";
        Integer id = 10;

        String nombre1 = "Sabrina";
        String apellido1 = "Lami";
        Integer id1 = 10;

        String nombre2 = "Victoria";
        String apellido2 = "Ruiz";
        Integer id2 = 11;



        personaResponseDTO = personaController.modificarPersona(personaDTO,id);
        System.out.println(personaResponseDTO);

        personaController.agregarPersona(persona);
        personaController.borrarPersona(id);



        System.out.println("---------------");
        */
        PersonaController personaController = new PersonaController();
        List<Persona> personas = new ArrayList<>();
        personas = personaController.listarPersonas();

        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

        System.out.println("---------------");

        Persona persona = new Persona("Carlos","Arturo","Av Belgrano",41);
        personaController.agregarPersona(persona);
    }
}