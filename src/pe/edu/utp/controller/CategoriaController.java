/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;


import pe.edu.utp.dao.CategoriaDAO;
import pe.edu.utp.dao.impl.CategoriaDAOImpl;
import pe.edu.utp.model.Categoria;

import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    // Constructor que instancia directamente el DAO
    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAOImpl();
    }

    // Método para guardar una categoría
    public void guardarCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);
        categoriaDAO.guardar(categoria);
    }

    // Método para actualizar una categoría
    public void actualizarCategoria(int idCategoria, String nombre) {
        Categoria categoria = new Categoria(nombre);
        categoria.setId_categoria(idCategoria);
        categoriaDAO.actualizar(categoria);
    }

    // Método para eliminar una categoría por su ID
    public void eliminarCategoria(int idCategoria) {
        categoriaDAO.eliminar(idCategoria);
    }

    // Método para obtener una categoría por su ID
    public Categoria obtenerCategoriaPorId(int idCategoria) {
        return categoriaDAO.obtenerPorId(idCategoria);
    }

    // Método para obtener todas las categorías
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaDAO.obtenerTodos();
    }
}