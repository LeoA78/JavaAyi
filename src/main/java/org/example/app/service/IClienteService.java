package org.example.app.service;

import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;

import java.util.List;

public interface IClienteService {
    void insertarCliente(Cliente cliente);
    void borrarCliente(Integer id);
    List<Cliente> listarClientes();
    ClienteResponseDTO actualizarCliente(ClienteDTO cliente, Integer id);
}
