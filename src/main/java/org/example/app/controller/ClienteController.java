package org.example.app.controller;

import org.example.app.service.IService;
import org.example.app.service.impl.ClienteServiceImpl;

public class ClienteController {
    IService iServicios = new ClienteServiceImpl();

    public void agregarCliente(String nombre, String apellido){
        iServicios.insertar(nombre,apellido);
    }

    public void borrarCliente(Integer id){
        iServicios.borrar(id);
    }

    public String listarClientes(){
        return iServicios.listarTodos();
    }

    public String modificarCliente(String nombre, String apellido){
        return iServicios.modificar(nombre,apellido);
    }
}
