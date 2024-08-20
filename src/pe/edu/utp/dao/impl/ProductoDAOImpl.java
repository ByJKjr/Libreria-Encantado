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
import pe.edu.utp.dao.AutorDAO;
import pe.edu.utp.dao.CategoriaDAO;
import pe.edu.utp.dao.EditorialDAO;
import pe.edu.utp.dao.ProductoDAO;
import pe.edu.utp.model.Autor;
import pe.edu.utp.model.Categoria;
import pe.edu.utp.model.Editorial;
import pe.edu.utp.model.Producto;

public class ProductoDAOImpl implements ProductoDAO {

    private Connection conexion;

    // Constructor que recibe la conexión
    public ProductoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ProductoDAOImpl() {
        // Obtener la conexión desde la clase Conexion
        Conexion miConexion = new Conexion();
        this.conexion = miConexion.obtenerConexion();
    }

    @Override
    public void guardar(Producto producto) {
        String sql = "INSERT INTO libro (titulo, id_autor, id_editorial, id_categoria, isbn, fecha_publicacion, idioma, precio, cantidad) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getTitulo());
            stmt.setInt(2, producto.getAutor().getId_autor());
            stmt.setInt(3, producto.getEditorial().getId_editorial());
            stmt.setInt(4, producto.getCategoria().getId_categoria());
            stmt.setLong(5, producto.getIsbn());
            stmt.setString(6, producto.getFecha_publicacion());
            stmt.setString(7, producto.getIdioma());
            stmt.setDouble(8, producto.getPrecio());
            stmt.setInt(9, producto.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE libro SET titulo = ?, id_autor = ?, id_editorial = ?, id_categoria = ?, " +
                     "isbn = ?, fecha_publicacion = ?, idioma = ?, precio = ?, cantidad = ? WHERE id_libro = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getTitulo());
            stmt.setInt(2, producto.getAutor().getId_autor());
            stmt.setInt(3, producto.getEditorial().getId_editorial());
            stmt.setInt(4, producto.getCategoria().getId_categoria());
            stmt.setLong(5, producto.getIsbn());
            stmt.setString(6, producto.getFecha_publicacion());
            stmt.setString(7, producto.getIdioma());
            stmt.setDouble(8, producto.getPrecio());
            stmt.setInt(9, producto.getCantidad());
            stmt.setInt(10, producto.getId_libro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM libro WHERE id_libro = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto obtenerPorId(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM libro WHERE id_libro = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setId_libro(rs.getInt("id_libro"));
                    producto.setTitulo(rs.getString("titulo"));
                    
                    // Obtener y establecer el autor del producto
                    AutorDAO autorDAO = new AutorDAOImpl(conexion);
                    Autor autor = autorDAO.obtenerPorId(rs.getInt("id_autor"));
                    producto.setAutor(autor);
                    
                    // Obtener y establecer la editorial del producto
                    EditorialDAO editorialDAO = new EditorialDAOImpl(conexion);
                    Editorial editorial = editorialDAO.obtenerPorId(rs.getInt("id_editorial"));
                    producto.setEditorial(editorial);
                    
                    // Obtener y establecer la categoría del producto
                    CategoriaDAO categoriaDAO = new CategoriaDAOImpl(conexion);
                    Categoria categoria = categoriaDAO.obtenerPorId(rs.getInt("id_categoria"));
                    producto.setCategoria(categoria);
                    
                    producto.setIsbn(rs.getLong("isbn"));
                    producto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                    producto.setIdioma(rs.getString("idioma"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCantidad(rs.getInt("cantidad"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_libro(rs.getInt("id_libro"));
                producto.setTitulo(rs.getString("titulo"));
                
                // Obtener y establecer el autor del producto
                AutorDAO autorDAO = new AutorDAOImpl(conexion);
                Autor autor = autorDAO.obtenerPorId(rs.getInt("id_autor"));
                producto.setAutor(autor);
                
                // Obtener y establecer la editorial del producto
                EditorialDAO editorialDAO = new EditorialDAOImpl(conexion);
                Editorial editorial = editorialDAO.obtenerPorId(rs.getInt("id_editorial"));
                producto.setEditorial(editorial);
                
                // Obtener y establecer la categoría del producto
                CategoriaDAO categoriaDAO = new CategoriaDAOImpl(conexion);
                Categoria categoria = categoriaDAO.obtenerPorId(rs.getInt("id_categoria"));
                producto.setCategoria(categoria);
                
                producto.setIsbn(rs.getLong("isbn"));
                producto.setFecha_publicacion(rs.getString("fecha_publicacion"));
                producto.setIdioma(rs.getString("idioma"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }
}

