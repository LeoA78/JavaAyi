package org.example.app.controller;

import org.example.app.dto.request.EmpleadoDTO;
import org.example.app.dto.response.EmpleadoResponseDTO;
import org.example.app.entity.Empleado;
import org.example.app.service.IEmpleadoService;
import org.example.app.service.impl.EmpleadoServiceImpl;

import java.util.List;

public class EmpleadoController {
    IEmpleadoService iEmpleadoServicios = new EmpleadoServiceImpl();

    public void agregarEmpleado(Empleado empleado){
        iEmpleadoServicios.insertarEmpleado(empleado);
    }

    public void borrarEmpleado(Integer id){
        iEmpleadoServicios.borrarEmpleado(id);
    }

    public List<Empleado> listarEmpleados(){
        return iEmpleadoServicios.listarEmpleados();
    }

    public EmpleadoResponseDTO modificarEmpleado(Empleado empleado, Integer id){
        return iEmpleadoServicios.actualizarEmpleado(empleado,id);
    }

}
