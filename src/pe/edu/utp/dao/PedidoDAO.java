/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.dao;

import java.util.List;
import pe.edu.utp.model.Pedido;


public interface PedidoDAO {
    void guardar(Pedido pedido);
    void actualizar(Pedido pedido);
    void eliminar(int id);
    Pedido obtenerPorId(int id);
    List<Pedido> obtenerTodos();
}
