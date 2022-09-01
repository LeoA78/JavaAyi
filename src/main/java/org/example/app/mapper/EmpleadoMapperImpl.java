package org.example.app.mapper;

import org.example.app.dto.response.EmpleadoResponseDTO;
import org.example.app.entity.Empleado;
import org.modelmapper.ModelMapper;

public class EmpleadoMapperImpl {
    private ModelMapper objMapper = new ModelMapper();

    public EmpleadoResponseDTO toEntityToDto(Empleado EmpleadoSource){
        EmpleadoResponseDTO EmpleadoResponseDTO = new EmpleadoResponseDTO();
        return objMapper.map(EmpleadoSource,EmpleadoResponseDTO.class);
    }
}
