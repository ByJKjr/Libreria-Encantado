/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;


import pe.edu.utp.dao.PedidoDAO;
import pe.edu.utp.dao.impl.PedidoDAOImpl;
import pe.edu.utp.model.Pedido;
import pe.edu.utp.model.Cliente;
import pe.edu.utp.model.Usuario;

import java.util.List;
import pe.edu.utp.utils.ArbolBinario;

public class PedidoController {

    private PedidoDAO pedidoDAO;

    // Constructor que instancia directamente el DAO
    public PedidoController() {
        this.pedidoDAO = new PedidoDAOImpl();
    }

    // Método para guardar un pedido
    public void guardarPedido(String fechaPedido, double monto, String estado, double igv, Cliente cliente, Usuario empleado) {
        Pedido pedido = new Pedido(fechaPedido, monto, estado, igv, cliente, empleado);
        pedidoDAO.guardar(pedido);
    }

    // Método para actualizar un pedido
    public void actualizarPedido(int idPedido, String fechaPedido, double monto, String estado, double igv, Cliente cliente, Usuario empleado) {
        Pedido pedido = new Pedido(fechaPedido, monto, estado, igv, cliente, empleado);
        pedido.setId_pedido(idPedido);
        pedidoDAO.actualizar(pedido);
    }

    // Método para eliminar un pedido por su ID
    public void eliminarPedido(int idPedido) {
        pedidoDAO.eliminar(idPedido);
    }
    
    // Metodo para agrupar los pedidos por nombre 
    public ArbolBinario agregarDatosArbol(){
       ArbolBinario arbol = new ArbolBinario();
       
       List<Pedido> pedidos = obtenerTodosLosPedidos();
       
       for (Pedido pedido : pedidos) {
            arbol.insertar(pedido);
       }

       return arbol;
    }

    // Método para obtener un pedido por su ID
    public Pedido obtenerPedidoPorId(int idPedido) {
        return pedidoDAO.obtenerPorId(idPedido);
    }

    // Método para obtener todos los pedidos
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoDAO.obtenerTodos();
    }
}