package org.example.app.mapper;

import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Persona;
import org.modelmapper.ModelMapper;

public class PersonaMapperImpl {

    private ModelMapper objMapper = new ModelMapper();

    public PersonaResponseDTO toEntityToDto(Persona personaSource){
        PersonaResponseDTO personaResponseDTO = new PersonaResponseDTO();
        return objMapper.map(personaSource,PersonaResponseDTO.class);
    }
}
