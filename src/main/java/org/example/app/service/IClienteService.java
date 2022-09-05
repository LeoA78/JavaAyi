package org.example.app.service;

import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;
import org.example.app.entity.Persona;

import java.util.List;

public interface IClienteService {
    void insertarCliente(Cliente cliente);
    void borrarCliente(Integer id);
    List<Cliente> listarClientes();
    Cliente actualizarCliente(Cliente cliente, Integer id);
    List<Cliente> getAllClientes();
}
