package org.example.app.controller;

import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;
import org.example.app.service.IClienteService;
import org.example.app.service.impl.ClienteServiceImpl;

import java.util.List;

public class ClienteController {
    IClienteService iClienteServicios = new ClienteServiceImpl();

    public void agregarCliente(Cliente cliente){
        iClienteServicios.insertarCliente(cliente);
    }

    public void borrarCliente(Integer id){
        iClienteServicios.borrarCliente(id);
    }

    public List<Cliente> listarClientes(){
        return iClienteServicios.listarClientes();
    }

    public Cliente modificarCliente(Cliente cliente, Integer id){
        return iClienteServicios.actualizarCliente(cliente,id);
    }

}
