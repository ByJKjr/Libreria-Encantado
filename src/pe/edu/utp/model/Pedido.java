/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.model;

/**
 *
 * @author BRANDY
 */
public class Pedido {
  int id_pedido;
  String fecha_pedido;
  double monto;
  String estado;
  double igv;
  Cliente cliente;
  Usuario empleado;

    public Pedido() {
    }

    public Pedido(String fecha_pedido, double monto, String estado, double igv, Cliente cliente, Usuario empleado) {
        this.fecha_pedido = fecha_pedido;
        this.monto = monto;
        this.estado = estado;
        this.igv = igv;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
    }
    
    
  
   
}
