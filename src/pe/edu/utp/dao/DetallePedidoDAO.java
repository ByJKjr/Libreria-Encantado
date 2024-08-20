/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.DetallePedido;

public interface DetallePedidoDAO {
    void guardar(DetallePedido detallePedido);
    void actualizar(DetallePedido detallePedido);
    void eliminar(int id);
    DetallePedido obtenerPorId(int id);
    List<DetallePedido> obtenerPorPedido(int idPedido);
    List<DetallePedido> obtenerTodos();
}

