package org.curso.app.services.impl;

import jakarta.persistence.EntityManager;
import org.curso.app.entity.Cliente;
import org.curso.app.repositories.IClienteRepository;
import org.curso.app.repositories.impl.ClienteRepository;
import org.curso.app.services.IClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements IClienteService {
    private EntityManager em;
    private IClienteRepository<Cliente> iClienteRepository;


    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        this.iClienteRepository = new ClienteRepository(em);
    }
    @Override
    public List<Cliente> getAll() {
        return iClienteRepository.listar();
    }

    @Override
    public Cliente getById(Long id) { //Recomendado usarlo así por mayor seguridad
        Optional<Cliente> clienteById;

        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if (clienteById.isPresent()) {
            return clienteById.get();
        } else {
            return null;
        }

    }

    @Override
    public Cliente getById2(Long id) {
        Cliente clienteById;

        clienteById = iClienteRepository.getById(id);

        if (clienteById != null) {
            return clienteById;
        } else {
            return null;
        }

    }

    @Override
    public void eliminar(Long id) {

        Optional<Cliente> clienteById;
        clienteById = Optional.ofNullable(iClienteRepository.getById(id));

        if (clienteById.isPresent()) {

            try {

                em.getTransaction().begin();
                iClienteRepository.eliminar(id);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }

        } else {
            System.out.println("No se pudo borrar");
        }

    }

    @Override
    public void insert(Cliente cliente) {

        try {

            em.getTransaction().begin();
            iClienteRepository.insertar(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void update(Cliente cliente) {

        if (cliente.getId() > 0) {

            Optional<Cliente> clienteById;
            clienteById = Optional.ofNullable(iClienteRepository.getById(cliente.getId()));

            if(clienteById.isPresent()){
                try {

                    em.getTransaction().begin();
                    iClienteRepository.guardar(cliente);
                    em.getTransaction().commit();

                } catch (Exception e) {
                    em.getTransaction().rollback();
                    e.printStackTrace();
                }
            }else{
                System.out.println("El cliente a actualizar es inválido");
            }

        }

    }

}
