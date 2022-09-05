package org.example.app.service.impl;

import org.example.app.configuration.ConexionDB;
import org.example.app.dto.request.ClienteDTO;
import org.example.app.dto.response.ClienteResponseDTO;
import org.example.app.entity.Cliente;
import org.example.app.entity.Empleado;
import org.example.app.mapper.ClienteMapperImpl;
import org.example.app.service.IClienteService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.app.constants.Constants.*;

public class ClienteServiceImpl implements IClienteService {
    private ClienteMapperImpl clienteMapperImplement = new ClienteMapperImpl();
    private ConexionDB conexionDB;

    @Override
    public void insertarCliente(Cliente cliente) {

        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CLIENT);
            stmt.setBoolean(1,cliente.getVip());
            stmt.setDouble(2,cliente.getDeuda());
            stmt.setInt(3,cliente.getIdPersonaCliente());
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

            if(respuesta == 1){
                System.out.println("El cliente fue ingresado correctamente");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }

    @Override
    public void borrarCliente(Integer id) {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_CLIENT);
            stmt.setInt(1,id);
            Integer respuesta =  stmt.executeUpdate();

            if(respuesta < 1){
                System.out.println("El id: " + id + " no existe.");
            }else{
                System.out.println("El cliente con el id: " + id + " fue eliminado correctamente");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    @Override
    public List<Cliente> listarClientes() {
        return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente, Integer id) {

        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CLIENT);
            stmt.setBoolean(1,cliente.getVip());
            stmt.setDouble(2,cliente.getDeuda());
            stmt.setInt(3,cliente.getIdPersonaCliente());
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

            if(respuesta == 1){
                System.out.println("El cliente fue ingresado correctamente");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return null;
    }

    @Override
    public List<Cliente> getAllClientes() {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPLOYEE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id");
                Boolean vip = rs.getBoolean("vip");
                Double deuda = rs.getDouble("deuda");
                Integer idPersona = rs.getInt("id_persona");

                cliente = new Cliente(idCliente, vip, deuda, idPersona);

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conexionDB.close(rs);
                conexionDB.close(stmt);
                conexionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return clientes;
    }
}
