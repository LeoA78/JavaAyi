package org.curso.app.services;

import org.curso.app.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getAll();

    Cliente getById(Long id);

    Cliente getById2(Long id);

    void eliminar(Long id);

    void insert(Cliente cliente);

    void update(Cliente cliente);
}
