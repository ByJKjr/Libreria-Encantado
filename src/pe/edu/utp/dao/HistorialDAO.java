/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.Historial;

public interface HistorialDAO {
    // Método para obtener todos los registros de la tabla historial
    List<Historial> obtenerHistoriales();
    public void insertarHistorial(Historial historial);
}
