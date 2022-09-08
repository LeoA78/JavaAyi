package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JPAUtilDB;
import org.curso.app.entity.Cliente;

import java.util.Scanner;

public class JPAPorId {
    public static void main(String[] args) {

        EntityManager em = JPAUtilDB.getEntityManager();

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();

        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);

        em.close();

    }
}
