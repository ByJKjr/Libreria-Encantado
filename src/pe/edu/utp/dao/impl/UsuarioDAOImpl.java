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
import pe.edu.utp.model.Usuario;
import pe.edu.utp.dao.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public UsuarioDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public UsuarioDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(Usuario usuario) {
        String sql = "INSERT INTO empleado (nombre, apellido_paterno, apellido_materno, area, fecha_contratacion, dni, correo_electronico) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido_paterno());
            stmt.setString(3, usuario.getApellido_materno());
            stmt.setString(4, usuario.getArea());
            stmt.setString(5, usuario.getFecha_contratacion());
            stmt.setInt(6, usuario.getDni());
            stmt.setString(7, usuario.getCorreo_electronico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE empleado SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, " +
                     "area = ?, fecha_contratacion = ?, dni = ?, correo_electronico = ? WHERE id_empleado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido_paterno());
            stmt.setString(3, usuario.getApellido_materno());
            stmt.setString(4, usuario.getArea());
            stmt.setString(5, usuario.getFecha_contratacion());
            stmt.setInt(6, usuario.getDni());
            stmt.setString(7, usuario.getCorreo_electronico());
            stmt.setInt(8, usuario.getId_empleado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleado WHERE id_empleado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId_empleado(rs.getInt("id_empleado"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido_paterno(rs.getString("apellido_paterno"));
                    usuario.setApellido_materno(rs.getString("apellido_materno"));
                    usuario.setArea(rs.getString("area"));
                    usuario.setFecha_contratacion(rs.getString("fecha_contratacion"));
                    usuario.setDni(rs.getInt("dni"));
                    usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_empleado(rs.getInt("id_empleado"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido_paterno(rs.getString("apellido_paterno"));
                usuario.setApellido_materno(rs.getString("apellido_materno"));
                usuario.setArea(rs.getString("area"));
                usuario.setFecha_contratacion(rs.getString("fecha_contratacion"));
                usuario.setDni(rs.getInt("dni"));
                usuario.setCorreo_electronico(rs.getString("correo_electronico"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
}
