/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.conexion.Conexion;
import pe.edu.utp.dao.DetallePedidoDAO;
import pe.edu.utp.dao.PedidoDAO;
import pe.edu.utp.dao.ProductoDAO;
import pe.edu.utp.model.DetallePedido;
import pe.edu.utp.model.Pedido;
import pe.edu.utp.model.Producto;

public class DetallePedidoDAOImpl implements DetallePedidoDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public DetallePedidoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public DetallePedidoDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(DetallePedido detallePedido) {
        String sql = "INSERT INTO detalle_pedido (cantidad, subtotal, id_libro, id_pedido) " +
                     "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, detallePedido.getCantidad());
            stmt.setDouble(2, detallePedido.getSubtotal());
            stmt.setInt(3, detallePedido.getLibro().getId_libro());
            stmt.setInt(4, detallePedido.getPedido().getId_pedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(DetallePedido detallePedido) {
        String sql = "UPDATE detalle_pedido SET cantidad = ?, subtotal = ?, id_libro = ?, id_pedido = ? " +
                     "WHERE id_detalle_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, detallePedido.getCantidad());
            stmt.setDouble(2, detallePedido.getSubtotal());
            stmt.setInt(3, detallePedido.getLibro().getId_libro());
            stmt.setInt(4, detallePedido.getPedido().getId_pedido());
            stmt.setInt(5, detallePedido.getId_detalle_pedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetallePedido obtenerPorId(int id) {
        DetallePedido detallePedido = null;
        String sql = "SELECT * FROM detalle_pedido WHERE id_detalle_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    detallePedido = new DetallePedido();
                    detallePedido.setId_detalle_pedido(rs.getInt("id_detalle_pedido"));
                    detallePedido.setCantidad(rs.getInt("cantidad"));
                    detallePedido.setSubtotal(rs.getDouble("subtotal"));
                    
                    // Obtener y establecer el libro del detalle pedido
                    ProductoDAO productoDAO = new ProductoDAOImpl(conexion);
                    Producto libro = productoDAO.obtenerPorId(rs.getInt("id_libro"));
                    detallePedido.setLibro(libro);
                    
                    // Obtener y establecer el pedido del detalle pedido
                    PedidoDAO pedidoDAO = new PedidoDAOImpl(conexion);
                    Pedido pedido = pedidoDAO.obtenerPorId(rs.getInt("id_pedido"));
                    detallePedido.setPedido(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallePedido;
    }

    @Override
    public List<DetallePedido> obtenerPorPedido(int idPedido) {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido WHERE id_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DetallePedido detallePedido = new DetallePedido();
                    detallePedido.setId_detalle_pedido(rs.getInt("id_detalle_pedido"));
                    detallePedido.setCantidad(rs.getInt("cantidad"));
                    detallePedido.setSubtotal(rs.getDouble("subtotal"));
                    
                    // Obtener y establecer el libro del detalle pedido
                    ProductoDAO productoDAO = new ProductoDAOImpl(conexion);
                    Producto libro = productoDAO.obtenerPorId(rs.getInt("id_libro"));
                    detallePedido.setLibro(libro);
                    
                    // Obtener y establecer el pedido del detalle pedido
                    PedidoDAO pedidoDAO = new PedidoDAOImpl(conexion);
                    Pedido pedido = pedidoDAO.obtenerPorId(rs.getInt("id_pedido"));
                    detallePedido.setPedido(pedido);
                    
                    listaDetalles.add(detallePedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDetalles;
    }

    @Override
    public List<DetallePedido> obtenerTodos() {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setId_detalle_pedido(rs.getInt("id_detalle_pedido"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setSubtotal(rs.getDouble("subtotal"));
                
                // Obtener y establecer el libro del detalle pedido
                ProductoDAO productoDAO = new ProductoDAOImpl(conexion);
                Producto libro = productoDAO.obtenerPorId(rs.getInt("id_libro"));
                detallePedido.setLibro(libro);
                
                // Obtener y establecer el pedido del detalle pedido
                PedidoDAO pedidoDAO = new PedidoDAOImpl(conexion);
                Pedido pedido = pedidoDAO.obtenerPorId(rs.getInt("id_pedido"));
                detallePedido.setPedido(pedido);
                
                listaDetalles.add(detallePedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDetalles;
    }
}
