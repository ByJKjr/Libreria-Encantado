/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;

import pe.edu.utp.dao.ClienteDAO;
import pe.edu.utp.dao.impl.ClienteDAOImpl;
import pe.edu.utp.model.Cliente;

import java.util.List;

public class ClienteController {

    private ClienteDAO clienteDAO;

    // Constructor que instancia directamente el DAO
    public ClienteController() {
        this.clienteDAO = new ClienteDAOImpl();
    }

    // Método para guardar un cliente
    public boolean guardarCliente(String nombre, String apellidoPaterno, String apellidoMaterno, String dni, String direccion, String telefono) {
        Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, dni, direccion, telefono);
        clienteDAO.guardar(cliente);
        return true;
    }

    // Método para actualizar un cliente
    public void actualizarCliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String dni, String direccion, String telefono) {
        Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno, dni, direccion, telefono);
        cliente.setId_cliente(idCliente);
        clienteDAO.actualizar(cliente);
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(int idCliente) {
        clienteDAO.eliminar(idCliente);
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(int idCliente) {
        return clienteDAO.obtenerPorId(idCliente);
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.obtenerTodos();
    }
}