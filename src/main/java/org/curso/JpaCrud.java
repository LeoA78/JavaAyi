package org.curso;

import jakarta.persistence.EntityManager;
import org.curso.app.configuration.JpaUtilDB;
import org.curso.app.entity.Cliente;
import org.curso.app.services.IClienteService;
import org.curso.app.services.impl.ClienteServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class JpaCrud {
    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        IClienteService service = new ClienteServiceImpl(em);

        /*
        System.out.println("========== insertar nuevo cliente ===========");
        Cliente cliente = new Cliente();
        cliente.setNombre("Luci");
        cliente.setApellido("Mena");
        cliente.setFormaPago("paypal");
        cliente.setFechaCreacion(LocalDate.now());

        service.insert(cliente);
        System.out.println("cliente guardado con exito");
        service.getAll().forEach(System.out::println);
*/

        /*
        System.out.println("=========== editar cliente ==========");

        Cliente cliente = new Cliente();
        cliente.setId(7L);
        cliente.setNombre("Martina");
        cliente.setApellido("Perez");
        cliente.setFormaPago("credito");
        cliente.setFechaCreacion(LocalDate.now());

        service.update(cliente);


        //Otra opcion para verificar el update
        cliente.ifPresent(c -> {
            c.setFormaPago("mercado pago");
            service.guardar(c);
            System.out.println("cliente editado con exito!");
            service.listar().forEach(System.out::println);
        });
        //---------------------------------

        System.out.println("==========================");

        */

        System.out.println("========== eliminar cliente ===========");
        service.eliminar(7L);


        System.out.println("========== listar ==========");
        List<Cliente> clientes = service.getAll();
        clientes.forEach(System.out::println);


        System.out.println("========== obtener por id ==========");
        Cliente optionalCliente = service.getById(1L);
        System.out.println(optionalCliente);


        em.close();

    }
}
