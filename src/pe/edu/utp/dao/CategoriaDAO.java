/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.Categoria;

public interface CategoriaDAO {
    void guardar(Categoria categoria);
    void actualizar(Categoria categoria);
    void eliminar(int id);
    Categoria obtenerPorId(int id);
    List<Categoria> obtenerTodos();
}
