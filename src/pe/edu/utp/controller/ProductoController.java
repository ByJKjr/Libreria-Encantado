/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;


import pe.edu.utp.dao.ProductoDAO;
import pe.edu.utp.dao.impl.ProductoDAOImpl;
import pe.edu.utp.model.Producto;
import pe.edu.utp.model.Autor;
import pe.edu.utp.model.Editorial;
import pe.edu.utp.model.Categoria;

import java.util.List;

public class ProductoController {

    private ProductoDAO productoDAO;

    // Constructor que instancia directamente el DAO
    public ProductoController() {
        this.productoDAO = new ProductoDAOImpl();
    }

    // Método para guardar un producto
    public boolean guardarProducto(Producto producto) {
        productoDAO.guardar(producto);
        return true;
    }

    // Método para actualizar un producto
    public void actualizarProducto(Producto producto) {
        productoDAO.actualizar(producto);
    }

    // Método para eliminar un producto por su ID
    public void eliminarProducto(int idLibro) {
        productoDAO.eliminar(idLibro);
    }

    // Método para obtener un producto por su ID
    public Producto obtenerProductoPorId(int idLibro) {
        return productoDAO.obtenerPorId(idLibro);
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodos();
    }
}