package org.example.app.service.impl;

import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;
import org.example.app.mapper.ClienteMapperImpl;
import org.example.app.service.IClienteService;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements IClienteService {
    private ClienteMapperImpl clienteMapperImplement = new ClienteMapperImpl();

    @Override
    public void insertarCliente(Cliente cliente) {
        Cliente cliente1 = new Cliente();
        cliente1 = cliente;

        System.out.println("Se inserta a " + cliente1.toString());
    }

    @Override
    public void borrarCliente(Integer id) {
        System.out.println("Se borró una Cliente id: " + id);
    }

    @Override
    public List<Cliente> listarClientes() {

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Lionel");
        cliente1.setApellido("Messi");

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Cristiano");
        cliente2.setApellido("Ronaldo");

        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(cliente1);
        lista.add(cliente2);
        return lista;
    }


    public ClienteResponseDTO actualizarCliente(ClienteDTO clienteDTO, Integer id) {
        Cliente clienteModificado = new Cliente();

        clienteModificado.setNombre(clienteDTO.getNombre());
        clienteModificado.setApellido(clienteDTO.getApellido());

        return clienteMapperImplement.toEntityToDto(clienteModificado);

    }
}
