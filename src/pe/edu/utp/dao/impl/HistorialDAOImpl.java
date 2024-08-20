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
import pe.edu.utp.dao.HistorialDAO;
import pe.edu.utp.model.Historial;

/**
 *
 * @author BRANDY
 */
public class HistorialDAOImpl implements HistorialDAO{
    private Connection conexion;

    // Constructor que recibe la conexión
    public HistorialDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public HistorialDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }
    
    
    @Override
    public List<Historial> obtenerHistoriales(){
      List<Historial> historiales = new ArrayList<>();  
      String sql = "SELECT * FROM historial";
       try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Historial historial = new Historial();
                historial.setId(rs.getInt("id"));
                historial.setActividad(rs.getString("actividad"));
                historial.setFecha(rs.getString("fecha"));
                historial.setHora(rs.getString("hora"));
                historiales.add(historial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return historiales;
    }
            
   @Override
    public void insertarHistorial(Historial historial) {
        String sql = "INSERT INTO historial (fecha, hora, actividad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, historial.getFecha());
            stmt.setString(2, historial.getHora());
            stmt.setString(3, historial.getActividad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}
