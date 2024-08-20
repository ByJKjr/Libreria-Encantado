/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.Autor;

public interface AutorDAO {
    void guardar(Autor autor);
    void actualizar(Autor autor);
    void eliminar(int id);
    Autor obtenerPorId(int id);
    List<Autor> obtenerTodos();
}
