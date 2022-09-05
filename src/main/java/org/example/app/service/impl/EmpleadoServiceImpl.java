package org.example.app.service.impl;

import org.example.app.configuration.ConexionDB;
import org.example.app.dto.request.EmpleadoDTO;
import org.example.app.dto.response.EmpleadoResponseDTO;
import org.example.app.entity.Empleado;
import org.example.app.entity.Persona;
import org.example.app.mapper.EmpleadoMapperImpl;
import org.example.app.service.IEmpleadoService;
import org.example.app.utils.Utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.app.constants.Constants.*;

public class EmpleadoServiceImpl implements IEmpleadoService {

    private EmpleadoMapperImpl empleadoMapperImplement = new EmpleadoMapperImpl();
    private ConexionDB conexionDB;

    @Override
    public void insertarEmpleado(Empleado empleado) {
        Utiles.isRegistrationExist("personas",empleado.getIdPersona());

        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_EMPLOYEE);
            stmt.setString(1,empleado.getLegajo());
            stmt.setString(2,empleado.getCargo());
            stmt.setInt(3,empleado.getIdPersona());
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

            if(respuesta == 1){
                System.out.println("El empleado fue ingresado correctamente");
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
    public void borrarEmpleado(Integer id) {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_EMPLOYEE);
            stmt.setInt(1,id);
            Integer respuesta =  stmt.executeUpdate();

            if(respuesta < 1){
                System.out.println("El id: " + id + " no existe.");
            }else{
                System.out.println("El empleado con el id: " + id + " fue eliminado correctamente");
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
    public List<Empleado> listarEmpleados() {


        ArrayList<Empleado> lista = new ArrayList<>();

        return lista;
    }

    public List<Empleado> getAllEmpleados() {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_EMPLOYEE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("id");
                String legajo = rs.getString("legajo");
                String cargo = rs.getString("cargo");
                Integer idPersona = rs.getInt("id_persona");

                empleado = new Empleado(idEmpleado, legajo, cargo, idPersona);

                empleados.add(empleado);
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

        return empleados;
    }

    public EmpleadoResponseDTO actualizarEmpleado(Empleado empleado, Integer id) {

        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_EMPLOYEE);
            stmt.setString(1,empleado.getLegajo());
            stmt.setString(2,empleado.getCargo());
            stmt.setInt(3,empleado.getIdPersona());
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

            if(respuesta == 1){
                System.out.println("El empleado fue ingresado correctamente");
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

}
