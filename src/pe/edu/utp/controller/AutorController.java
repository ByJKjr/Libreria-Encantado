/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;

import pe.edu.utp.dao.AutorDAO;
import pe.edu.utp.dao.impl.AutorDAOImpl;
import pe.edu.utp.model.Autor;

import java.util.List;

public class AutorController {

    private AutorDAO autorDAO;

    // Constructor que instancia directamente el DAO
    public AutorController() {
        this.autorDAO = new AutorDAOImpl();
    }

    // Método para guardar un autor
    public void guardarAutor(String nombre, String apellidoPaterno, String apellidoMaterno, String pais, String fechaNacimiento) {
        Autor autor = new Autor(nombre, apellidoPaterno, apellidoMaterno, pais, fechaNacimiento);
        autorDAO.guardar(autor);
    }

    // Método para actualizar un autor
    public void actualizarAutor(int idAutor, String nombre, String apellidoPaterno, String apellidoMaterno, String pais, String fechaNacimiento) {
        Autor autor = new Autor(nombre, apellidoPaterno, apellidoMaterno, pais, fechaNacimiento);
        autor.setId_autor(idAutor);
        autorDAO.actualizar(autor);
    }

    // Método para eliminar un autor por su ID
    public void eliminarAutor(int idAutor) {
        autorDAO.eliminar(idAutor);
    }

    // Método para obtener un autor por su ID
    public Autor obtenerAutorPorId(int idAutor) {
        return autorDAO.obtenerPorId(idAutor);
    }

    // Método para obtener todos los autores
    public List<Autor> obtenerTodosLosAutores() {
        return autorDAO.obtenerTodos();
    }
}