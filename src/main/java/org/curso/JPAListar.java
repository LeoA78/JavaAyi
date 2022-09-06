package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JPAUtilDB;
import org.curso.app.entity.Cliente;

import java.util.List;

public class JPAListar {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtilDB.getEntityManager();

        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();

        clientes.forEach(System.out::println); //Forma de mostrar la lista lambda / programacion funcional
        entityManager.close();
    }
}