package org.example;

import org.example.app.controller.*;
import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Empleado;
import org.example.app.entity.Persona;

public class DispatcherApp {
    public static void main(String[] args) {

        PersonaController personaController = new PersonaController();
        EmpleadoController empleadoController = new EmpleadoController();
        ClienteController clienteController = new ClienteController();

        Persona persona = new Persona("Carlos","Perez","12345657");
        PersonaDTO personaDTO = new PersonaDTO("Carlos","Perez","12345657");
        PersonaResponseDTO personaResponseDTO;

        String nombre = "Carlos";
        String apellido = "Perez";
        Integer id = 10;

        String nombre1 = "Sabrina";
        String apellido1 = "Lami";
        Integer id1 = 10;

        String nombre2 = "Victoria";
        String apellido2 = "Ruiz";
        Integer id2 = 11;

        System.out.println("Lista de personas -> " + personaController.listarPersonas());
        
        personaResponseDTO = personaController.modificarPersona(personaDTO,id);
        System.out.println(personaResponseDTO);

        personaController.agregarPersona(persona);
        personaController.borrarPersona(id);

        System.out.println("---------------");

        System.out.println(empleadoController.listarEmpleados());
        System.out.println(empleadoController.modificarEmpleado(nombre1,apellido1));
        empleadoController.agregarEmpleado(nombre1,apellido1);
        empleadoController.borrarEmpleado(id1);

        System.out.println("---------------");

        System.out.println(clienteController.listarClientes());
        System.out.println(clienteController.modificarCliente(nombre2,apellido2));
        clienteController.agregarCliente(nombre2,apellido2);
        clienteController.borrarCliente(id2);

        System.out.println("---------------");
    }
}