/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;

import pe.edu.utp.dao.UsuarioDAO;
import pe.edu.utp.dao.impl.UsuarioDAOImpl;
import pe.edu.utp.model.Usuario;

import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    // Constructor que instancia directamente el DAO
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    // Método para guardar un usuario
    public boolean guardarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, String area, String fechaContratacion, int dni, String correoElectronico) {
        Usuario usuario = new Usuario(nombre, apellidoPaterno, apellidoMaterno, area, fechaContratacion, dni, correoElectronico);
        usuarioDAO.guardar(usuario);
        return true;
    }

    // Método para actualizar un usuario
    public void actualizarUsuario(int idEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String area, String fechaContratacion, int dni, String correoElectronico) {
        Usuario usuario = new Usuario(nombre, apellidoPaterno, apellidoMaterno, area, fechaContratacion, dni, correoElectronico);
        usuario.setId_empleado(idEmpleado);
        usuarioDAO.actualizar(usuario);
    }

    // Método para eliminar un usuario por su ID
    public void eliminarUsuario(int idEmpleado) {
        usuarioDAO.eliminar(idEmpleado);
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(int idEmpleado) {
        return usuarioDAO.obtenerPorId(idEmpleado);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDAO.obtenerTodos();
    }
}
