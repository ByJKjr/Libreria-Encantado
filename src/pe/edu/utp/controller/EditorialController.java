/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;


import pe.edu.utp.dao.EditorialDAO;
import pe.edu.utp.dao.impl.EditorialDAOImpl;
import pe.edu.utp.model.Editorial;

import java.util.List;

public class EditorialController {

    private EditorialDAO editorialDAO;

    // Constructor que instancia directamente el DAO
    public EditorialController() {
        this.editorialDAO = new EditorialDAOImpl();
    }

    // Método para guardar una editorial
    public void guardarEditorial(String nombre, String pais) {
        Editorial editorial = new Editorial(nombre, pais);
        editorialDAO.guardar(editorial);
    }

    // Método para actualizar una editorial
    public void actualizarEditorial(int idEditorial, String nombre, String pais) {
        Editorial editorial = new Editorial(nombre, pais);
        editorial.setId_editorial(idEditorial);
        editorialDAO.actualizar(editorial);
    }

    // Método para eliminar una editorial por su ID
    public void eliminarEditorial(int idEditorial) {
        editorialDAO.eliminar(idEditorial);
    }

    // Método para obtener una editorial por su ID
    public Editorial obtenerEditorialPorId(int idEditorial) {
        return editorialDAO.obtenerPorId(idEditorial);
    }

    // Método para obtener todas las editoriales
    public List<Editorial> obtenerTodasLasEditoriales() {
        return editorialDAO.obtenerTodos();
    }
}