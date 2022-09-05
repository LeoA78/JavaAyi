package org.example;

import org.example.app.controller.*;
import org.example.app.entity.Empleado;
import org.example.app.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class DispatcherApp {
    public static void main(String[] args) {

        PersonaController personaController = new PersonaController();
        List<Persona> personas = new ArrayList<>();
        personas = personaController.listarPersonas();

        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

        System.out.println("---------------");

        Persona persona = new Persona("Marcos","Diaz","Dallinger",46);
        personaController.agregarPersona(persona);


        System.out.println("------- EMPLEADO --------");

        EmpleadoController empleadoController = new EmpleadoController();
        List<Empleado> empleados = new ArrayList<>();
        empleados= empleadoController.listarEmpleados();

        empleados.forEach(empleado-> {
            System.out.println("empleado = " + empleado);
        });

        System.out.println("---------------");

        Empleado empleado = new Empleado("Leg5122", "Vendedor",1);
        empleadoController.agregarEmpleado(empleado);

    }
}