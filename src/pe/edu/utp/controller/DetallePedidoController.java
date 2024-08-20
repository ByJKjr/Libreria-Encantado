/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import pe.edu.utp.dao.DetallePedidoDAO;
import pe.edu.utp.dao.impl.DetallePedidoDAOImpl;
import pe.edu.utp.model.DetallePedido;
import pe.edu.utp.model.Producto;
import pe.edu.utp.model.Pedido;

import java.util.List;

public class DetallePedidoController {

    private DetallePedidoDAO detallePedidoDAO;

    // Constructor que instancia directamente el DAO
    public DetallePedidoController() {
        this.detallePedidoDAO = new DetallePedidoDAOImpl();
    }

    // Método para guardar un detalle de pedido
    public void guardarDetallePedido(int cantidad, double subtotal, Producto libro, Pedido pedido) {
        DetallePedido detallePedido = new DetallePedido(cantidad, subtotal, libro, pedido);
        detallePedidoDAO.guardar(detallePedido);
    }

    // Método para actualizar un detalle de pedido
    public void actualizarDetallePedido(int idDetallePedido, int cantidad, double subtotal, Producto libro, Pedido pedido) {
        DetallePedido detallePedido = new DetallePedido(cantidad, subtotal, libro, pedido);
        detallePedido.setId_detalle_pedido(idDetallePedido);
        detallePedidoDAO.actualizar(detallePedido);
    }

    // Método para eliminar un detalle de pedido por su ID
    public void eliminarDetallePedido(int idDetallePedido) {
        detallePedidoDAO.eliminar(idDetallePedido);
    }

    // Método para obtener un detalle de pedido por su ID
    public DetallePedido obtenerDetallePedidoPorId(int idDetallePedido) {
        return detallePedidoDAO.obtenerPorId(idDetallePedido);
    }

    //HASHMAP 
    public HashMap<Integer, ArrayList<DetallePedido>> agregarDatosHashMap() {
        //DATOS
        HashMap<Integer, ArrayList<DetallePedido>> productosPorPedido = new HashMap<>();
        List<DetallePedido> detalles = obtenerTodosLosDetallesPedidos();

        //AGREGA LOS DETALLES POR ID_PEDIDO ; CLAVE: ID_PEDIDO, VALOR: ARRAYLIST<DetallePedido>
        for (DetallePedido detalle : detalles) {
            int idPedido = detalle.getPedido().getId_pedido();

            if (!productosPorPedido.containsKey(idPedido)) {
                productosPorPedido.put(idPedido, new ArrayList<>());
            }
            productosPorPedido.get(idPedido).add(detalle);
        }
        //Retorna el hashmap con los datos
        return productosPorPedido;
    }

    // Método para obtener todos los detalles de pedidos de un pedido específico
    public List<DetallePedido> obtenerDetallesPorPedido(int id_pedido) {
        return detallePedidoDAO.obtenerPorPedido(id_pedido);
    }

    // Método para obtener todos los detalles de pedidos
    public List<DetallePedido> obtenerTodosLosDetallesPedidos() {
        return detallePedidoDAO.obtenerTodos();
    }
}
