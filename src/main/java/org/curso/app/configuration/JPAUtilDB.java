package org.curso.app.configuration;

import jakarta.persistence.*;

public class JPAUtilDB {
    //La factory se llama en el arranque del programa y después ya queda instanciada
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory(); //Construye la instancia mayor

    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("cursoAyiJPA");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
