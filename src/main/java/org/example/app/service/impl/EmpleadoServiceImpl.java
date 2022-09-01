package org.example.app.service.impl;

import org.example.app.dto.request.EmpleadoDTO;
import org.example.app.dto.response.EmpleadoResponseDTO;
import org.example.app.entity.Empleado;
import org.example.app.mapper.EmpleadoMapperImpl;
import org.example.app.service.IEmpleadoService;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoServiceImpl implements IEmpleadoService {

    private EmpleadoMapperImpl empleadoMapperImplement = new EmpleadoMapperImpl();

    @Override
    public void insertarEmpleado(Empleado empleado) {
        Empleado empleado1 = new Empleado();
        empleado1 = empleado;

        System.out.println("Se inserta a " + empleado1.toString());
    }

    @Override
    public void borrarEmpleado(Integer id) {
        System.out.println("Se borró una Empleado id: " + id);
    }

    @Override
    public List<Empleado> listarEmpleados() {

        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Lionel");
        empleado1.setApellido("Messi");

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Cristiano");
        empleado2.setApellido("Ronaldo");

        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add(empleado1);
        lista.add(empleado2);
        return lista;
    }

    public EmpleadoResponseDTO actualizarEmpleado(EmpleadoDTO empleadoDTO, Integer id) {
        Empleado empleadoModificado = new Empleado();

        empleadoModificado.setNombre(empleadoDTO.getNombre());
        empleadoModificado.setApellido(empleadoDTO.getApellido());

        return empleadoMapperImplement.toEntityToDto(empleadoModificado);

    }

}
