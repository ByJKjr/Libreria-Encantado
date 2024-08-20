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
import pe.edu.utp.dao.EditorialDAO;
import pe.edu.utp.model.Editorial;

public class EditorialDAOImpl implements EditorialDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public EditorialDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public EditorialDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(Editorial editorial) {
        String sql = "INSERT INTO editorial (nombre, pais) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, editorial.getNombre());
            stmt.setString(2, editorial.getPais());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Editorial editorial) {
        String sql = "UPDATE editorial SET nombre = ?, pais = ? WHERE id_editorial = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, editorial.getNombre());
            stmt.setString(2, editorial.getPais());
            stmt.setInt(3, editorial.getId_editorial());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM editorial WHERE id_editorial = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Editorial obtenerPorId(int id) {
        Editorial editorial = null;
        String sql = "SELECT * FROM editorial WHERE id_editorial = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    editorial = new Editorial();
                    editorial.setId_editorial(rs.getInt("id_editorial"));
                    editorial.setNombre(rs.getString("nombre"));
                    editorial.setPais(rs.getString("pais"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editorial;
    }

    @Override
    public List<Editorial> obtenerTodos() {
        List<Editorial> listaEditoriales = new ArrayList<>();
        String sql = "SELECT * FROM editorial";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Editorial editorial = new Editorial();
                editorial.setId_editorial(rs.getInt("id_editorial"));
                editorial.setNombre(rs.getString("nombre"));
                editorial.setPais(rs.getString("pais"));
                listaEditoriales.add(editorial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEditoriales;
    }
}
