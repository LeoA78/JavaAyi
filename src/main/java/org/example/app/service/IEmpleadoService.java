package org.example.app.service;

import org.example.app.dto.request.EmpleadoDTO;
import org.example.app.dto.response.EmpleadoResponseDTO;
import org.example.app.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    void insertarEmpleado(Empleado empleado);
    void borrarEmpleado(Integer id);
    List<Empleado> listarEmpleados();
    EmpleadoResponseDTO actualizarEmpleado(EmpleadoDTO empleado, Integer id);
}
