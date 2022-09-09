package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JpaUtilDB;
import org.curso.app.entity.Cliente;

import javax.swing.*;
import java.time.LocalDate;

public class JpaEditar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtilDB.getEntityManager();

        try{

            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
            Cliente c = entityManager.find(Cliente.class, id);

            if(c == null){
                System.out.println("No existe ese ID");
            }else{

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre:", c.getNombre());
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido:", c.getApellido());
                String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:", c.getFormaPago());

                entityManager.getTransaction().begin(); // Iniciamos la conexión

                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setFormaPago(pago);
                c.setFechaCreacion(LocalDate.now());
                System.out.println("ID del cliente: " + c.getId());
                entityManager.merge(c);

                System.out.println("Cliente guardado satisfactoriamente en la base de datos.");

                entityManager.getTransaction().commit(); // Guarda en la base de datos el cambio
            }


        }catch(Exception e){
            entityManager.getTransaction().rollback(); // En caso de error hace un rollback
            e.getMessage();
        }finally{
            entityManager.close(); // Siempre cerrar la conexión
        }


    }

}
