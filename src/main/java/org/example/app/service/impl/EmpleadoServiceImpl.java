package org.example.app.service.impl;

import org.example.app.service.IService;

public class EmpleadoServiceImpl implements IService {


    @Override
    public void insertar(String nombre, String apellido) {
        System.out.println("Se insertó el empleado " + nombre + " " + apellido);
    }

    @Override
    public void borrar(Integer id) {
        System.out.println("Se borró el empleado ID: " + id);
    }

    @Override
    public String modificar(String nombre, String apellido) {

        return "Se modificó el empleado " + nombre + " " + apellido;
    }

    @Override
    public String listarTodos() {
        return "Mostrando todos los empleados";
    }
}
