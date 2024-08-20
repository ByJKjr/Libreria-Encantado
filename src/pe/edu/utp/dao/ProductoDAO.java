/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import pe.edu.utp.model.Producto;
import java.util.List;

public interface ProductoDAO {
    void guardar(Producto producto);
    void actualizar(Producto producto);
    void eliminar(int id);
    Producto obtenerPorId(int id);
    List<Producto> obtenerTodos();
}

