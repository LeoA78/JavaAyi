package org.example.app.mapper;

import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;
import org.modelmapper.ModelMapper;

public class ClienteMapperImpl {
    private ModelMapper objMapper = new ModelMapper();

    public ClienteResponseDTO toEntityToDto(Cliente clienteSource){
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        return objMapper.map(clienteSource,ClienteResponseDTO.class);
    }
}
