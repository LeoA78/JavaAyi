package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JpaUtilDB;
import org.curso.app.entity.Cliente;

import java.util.List;

public class JpaListar {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtilDB.getEntityManager();

        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();

        clientes.forEach(System.out::println); //Programación funcional
        entityManager.close();
    }
}