package org.example.app.constants;

public class Constants {
    /**
     * SQL querys person entity constant.
     */
    public static final String SQL_SELECT_PERSON = "SELECT id, nombre, apellido, edad, direccion FROM personas";
    public static final String SQL_INSERT_PERSON = "INSERT INTO personas(nombre, apellido, edad, direccion) VALUES(?, ?, ?, ?)";
    public static final String SQL_UPDATE_PERSON = "UPDATE personas SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id = ?";
    public static final String SQL_DELETE_PERSON = "DELETE FROM personas WHERE id = ?";

    /**
     * CLIENTE
     */
    public static final String SQL_SELECT_CLIENT = "SELECT id, vip, deuda, persona_FK FROM clientes";
    public static final String SQL_INSERT_CLIENT = "INSERT INTO clientes(vip, deuda, persona_FK) VALUES(?, ?, ?)";
    public static final String SQL_UPDATE_CLIENT = "UPDATE clientes SET vip = ?, deuda = ? WHERE id = ?";
    public static final String SQL_DELETE_CLIENT = "DELETE FROM clientes WHERE id = ?";

    /**
     * EMPLEADO
     */
    public static final String SQL_SELECT_EMPLOYEE = "SELECT id, legajo, cargo, persona_FK FROM empleados";
    public static final String SQL_INSERT_EMPLOYEE = "INSERT INTO empleados(legajo, cargo, persona_FK) VALUES(?, ?, ?)";
    public static final String SQL_UPDATE_EMPLOYEE = "UPDATE empleados SET legajo = ?, cargo = ? WHERE id = ?";
    public static final String SQL_DELETE_EMPLOYEE = "DELETE FROM empleados WHERE id = ?";


    /**
     * Variables de conexion a la base de datos. */

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_ayi_db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "";
}
