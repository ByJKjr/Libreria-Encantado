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
import pe.edu.utp.dao.ClienteDAO;
import pe.edu.utp.dao.UsuarioDAO;
import pe.edu.utp.dao.PedidoDAO;
import pe.edu.utp.model.Cliente;
import pe.edu.utp.model.Pedido;
import pe.edu.utp.model.Usuario;

public class PedidoDAOImpl implements PedidoDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public PedidoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public PedidoDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(Pedido pedido) {
        String sql = "INSERT INTO pedido (fecha_pedido, monto, estado, igv, id_cliente, id_empleado) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, pedido.getFecha_pedido());
            stmt.setDouble(2, pedido.getMonto());
            stmt.setString(3, pedido.getEstado());
            stmt.setDouble(4, pedido.getIgv());
            stmt.setInt(5, pedido.getCliente().getId_cliente());
            stmt.setInt(6, pedido.getEmpleado().getId_empleado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Pedido pedido) {
        String sql = "UPDATE pedido SET fecha_pedido = ?, monto = ?, estado = ?, igv = ?, " +
                     "id_cliente = ?, id_empleado = ? WHERE id_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, pedido.getFecha_pedido());
            stmt.setDouble(2, pedido.getMonto());
            stmt.setString(3, pedido.getEstado());
            stmt.setDouble(4, pedido.getIgv());
            stmt.setInt(5, pedido.getCliente().getId_cliente());
            stmt.setInt(6, pedido.getEmpleado().getId_empleado());
            stmt.setInt(7, pedido.getId_pedido());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido obtenerPorId(int id) {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE id_pedido = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pedido = new Pedido();
                    pedido.setId_pedido(rs.getInt("id_pedido"));
                    pedido.setFecha_pedido(rs.getString("fecha_pedido"));
                    pedido.setMonto(rs.getDouble("monto"));
                    pedido.setEstado(rs.getString("estado"));
                    pedido.setIgv(rs.getDouble("igv"));
                    
                    // Obtener y establecer el cliente del pedido
                    ClienteDAO clienteDAO = new ClienteDAOImpl(conexion);
                    Cliente cliente = clienteDAO.obtenerPorId(rs.getInt("id_cliente"));
                    pedido.setCliente(cliente);
                    
                    // Obtener y establecer el empleado del pedido
                    UsuarioDAO usuarioDAO = new UsuarioDAOImpl(conexion);
                    Usuario empleado = usuarioDAO.obtenerPorId(rs.getInt("id_empleado"));
                    pedido.setEmpleado(empleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public List<Pedido> obtenerTodos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setFecha_pedido(rs.getString("fecha_pedido"));
                pedido.setMonto(rs.getDouble("monto"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setIgv(rs.getDouble("igv"));
                
                // Obtener y establecer el cliente del pedido
                ClienteDAO clienteDAO = new ClienteDAOImpl(conexion);
                Cliente cliente = clienteDAO.obtenerPorId(rs.getInt("id_cliente"));
                pedido.setCliente(cliente);
                
                // Obtener y establecer el empleado del pedido
                UsuarioDAO usuarioDAO = new UsuarioDAOImpl(conexion);
                Usuario empleado = usuarioDAO.obtenerPorId(rs.getInt("id_empleado"));
                pedido.setEmpleado(empleado);
                
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPedidos;
    }
}
