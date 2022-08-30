package org.example.app.service.impl;

import org.example.app.service.IService;

public class ClienteServiceImpl implements IService {

    @Override
    public void insertar(String nombre, String apellido) {
        System.out.println("Se insertó el cliente " + nombre + " " + apellido);
    }

    @Override
    public void borrar(Integer id) {
        System.out.println("Se borró el cliente ID: " + id );
    }

    @Override
    public String modificar(String nombre, String apellido) {
        return "Se modificó el cliente " + nombre + " " + apellido;
    }

    @Override
    public String listarTodos() {
        return "Mostrando todos los clientes";
    }
}
