package org.example.app.controller;

import org.example.app.service.IService;
import org.example.app.service.impl.EmpleadoServiceImpl;

public class EmpleadoController {
    IService iServicios = new EmpleadoServiceImpl();

    public void agregarEmpleado(String nombre, String apellido){
        iServicios.insertar(nombre,apellido);
    }

    public void borrarEmpleado(Integer id){
        iServicios.borrar(id);
    }

    public String listarEmpleados(){
        return iServicios.listarTodos();
    }

    public String modificarEmpleado(String nombre, String apellido){
        return iServicios.modificar(nombre,apellido);
    }
}
