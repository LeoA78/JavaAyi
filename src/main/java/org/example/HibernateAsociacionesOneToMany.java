package org.example;

import jakarta.persistence.EntityManager;
import org.example.configurations.JpaUtilDb;
import org.example.entity.Cliente;
import org.example.entity.Direccion;

import java.util.ArrayList;
import java.util.List;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtilDb.getEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("German","Furfori");
            cliente.setFormaPago("Debito");

            Direccion direccion1 = new Direccion("Belgrano", 777);
            Direccion direccion2 = new Direccion("San Martin", 423);

            List<Direccion> listaDirecciones = new ArrayList<>();

            listaDirecciones.add(direccion1);
            listaDirecciones.add(direccion2);

            cliente.setDirecciones(listaDirecciones);


            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println(cliente);
            cliente = em.find(Cliente.class, cliente.getIdCliente());
            System.out.println("Cliente BD: " + cliente);

        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }

    }
}
