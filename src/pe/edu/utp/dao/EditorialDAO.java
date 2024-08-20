/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.Editorial;

public interface EditorialDAO {
    void guardar(Editorial editorial);
    void actualizar(Editorial editorial);
    void eliminar(int id);
    Editorial obtenerPorId(int id);
    List<Editorial> obtenerTodos();
}