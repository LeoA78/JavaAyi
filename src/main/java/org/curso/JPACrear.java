package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JPAUtilDB;
import org.curso.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JPACrear {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtilDB.getEntityManager();

        try{

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");

            entityManager.getTransaction().begin(); // Iniciamos la conexión

            Cliente clienteInsertar = new Cliente();

            clienteInsertar.setNombre(nombre);
            clienteInsertar.setApellido(apellido);
            clienteInsertar.setFormaPago(pago);
            clienteInsertar.setFechaCreacion(LocalDate.now());

            entityManager.persist(clienteInsertar);

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
