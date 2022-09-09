package org.curso.app.repositories;

import org.curso.app.entity.Cliente;

import java.util.List;

public interface IClienteRepository <T> {


    List<Cliente> listar();

    Cliente getById(Long id);

    void insertar(Cliente cliente);

    void guardar(Cliente cliente);

    void eliminar(Long id);
}
