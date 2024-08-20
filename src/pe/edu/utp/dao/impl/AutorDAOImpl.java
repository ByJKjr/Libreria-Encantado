package pe.edu.utp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.conexion.Conexion;
import pe.edu.utp.model.Autor;
import pe.edu.utp.dao.AutorDAO;

public class AutorDAOImpl implements AutorDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public AutorDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public AutorDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(Autor autor) {
        String sql = "INSERT INTO autor (nombre, apellido_paterno, apellido_materno, pais, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getApellido_paterno());
            stmt.setString(3, autor.getApellido_materno());
            stmt.setString(4, autor.getPais());
            stmt.setString(5, autor.getFecha_nacimiento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Autor autor) {
        String sql = "UPDATE autor SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, pais = ?, fecha_nacimiento = ? WHERE id_autor = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getApellido_paterno());
            stmt.setString(3, autor.getApellido_materno());
            stmt.setString(4, autor.getPais());
            stmt.setString(5, autor.getFecha_nacimiento());
            stmt.setInt(6, autor.getId_autor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM autor WHERE id_autor = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Autor obtenerPorId(int id) {
        Autor autor = null;
        String sql = "SELECT * FROM autor WHERE id_autor = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    autor = new Autor();
                    autor.setId_autor(rs.getInt("id_autor"));
                    autor.setNombre(rs.getString("nombre"));
                    autor.setApellido_paterno(rs.getString("apellido_paterno"));
                    autor.setApellido_materno(rs.getString("apellido_materno"));
                    autor.setPais(rs.getString("pais"));
                    autor.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autor;
    }

    @Override
    public List<Autor> obtenerTodos() {
        List<Autor> listaAutores = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId_autor(rs.getInt("id_autor"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellido_paterno(rs.getString("apellido_paterno"));
                autor.setApellido_materno(rs.getString("apellido_materno"));
                autor.setPais(rs.getString("pais"));
                autor.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                listaAutores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutores;
    }
}