package org.example.app.service;

public interface IService {
    void insertar(String nombre, String apellido);
    void borrar(Integer id);
    String modificar(String nombre, String apellido);

    String listarTodos();

}
