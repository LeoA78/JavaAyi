package org.curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.curso.app.configuration.JPAUtilDB;
import org.curso.app.entity.Cliente;

import java.util.Scanner;

public class JPASingleResultWhere {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        EntityManager em = JPAUtilDB.getEntityManager();

        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);

        System.out.println("Ingrese una forma de pago: ");

        String pago = s.next();
        query.setParameter(1, pago);
        query.setMaxResults(1); //Ejecuta un solo resultado

        Cliente c = (Cliente) query.getSingleResult(); //Castea al objeto cliente
        System.out.println(c);

        em.close();

    }
}
