package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JPAUtilDB;
import org.curso.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class JPAEliminar {
    public static void main(String[] args) {

        EntityManager entityManager = JPAUtilDB.getEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar");
        Long id = sc.nextLong();

        try{

            entityManager.getTransaction().begin(); // Iniciamos la conexión

            Cliente clienteEliminar = entityManager.find(Cliente.class,id);

            entityManager.remove(clienteEliminar);

            System.out.println("Cliente guardado satisfactoriamente en la base de datos.");

            entityManager.getTransaction().commit(); // Guarda en la base de datos el cambio

        }catch(Exception e){
            entityManager.getTransaction().rollback(); // En caso de error hace un rollback
            e.getMessage();
        }finally{
            entityManager.close(); // Siempre cerrar la conexión
        }


    }
}
