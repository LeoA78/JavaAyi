package org.example.app.service.impl;

import org.example.app.configuration.ConexionDB;
import org.example.app.dto.request.PersonaDTO;
import org.example.app.dto.response.PersonaResponseDTO;
import org.example.app.entity.Persona;
import org.example.app.mapper.PersonaMapperImpl;
import org.example.app.service.IPersonaService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.app.constants.Constants.*;

public class PersonaServiceImpl implements IPersonaService {
     private PersonaMapperImpl personaMapperImplement = new PersonaMapperImpl();
     private ConexionDB conexionDB;

    @Override
    public void insertarPersona(Persona persona) {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_PERSON);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setInt(3,persona.getEdad());
            stmt.setString(4,persona.getDireccion());
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

           if(respuesta == 1){
                System.out.println("La persona fue ingresada correctamente");
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
    public List<Persona> listarPersonas() {

        Persona persona1 = new Persona();
        persona1.setNombre("Lionel");
        persona1.setApellido("Messi");

        Persona persona2 = new Persona();
        persona2.setNombre("Cristiano");
        persona2.setApellido("Ronaldo");

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(persona1);
        lista.add(persona2);
        return lista;
    }



    public PersonaResponseDTO actualizarPersona(PersonaDTO personaDTO, Integer id) {

        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_PERSON);
            stmt.setString(1,personaDTO.getNombre());
            stmt.setString(2,personaDTO.getApellido());
            stmt.setInt(3,personaDTO.getEdad());
            stmt.setString(4,personaDTO.getDireccion());
            stmt.setInt(5,id);
            Integer respuesta =  stmt.executeUpdate();

            System.out.println("Respueta: " + respuesta);

            if(respuesta == 1){
                System.out.println("La persona fue ingresada correctamente");
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
       /* Persona personaModificada = new Persona();

        personaModificada.setNombre(personaDTO.getNombre());
        personaModificada.setApellido(personaDTO.getApellido());


        return personaMapperImplement.toEntityToDto(personaModificada); */
    }

    @Override
    public List<Persona> getAllPersonas() {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PERSON);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");

                persona = new Persona(idPersona, nombre, apellido, direccion,edad);

                personas.add(persona);
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

        return personas;
    }

    @Override
    public void borrarPersona(Integer id) {
        conexionDB = new ConexionDB();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionDB.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_PERSON);
            stmt.setInt(1,id);
            Integer respuesta =  stmt.executeUpdate();

            if(respuesta < 1){
                System.out.println("El id: " + id + " no existe.");
            }else{
                System.out.println("La persona con el id: " + id + " fue eliminada correctamente");
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



}