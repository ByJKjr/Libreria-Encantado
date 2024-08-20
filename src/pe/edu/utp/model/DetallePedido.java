/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.model;

/**
 *
 * @author BRANDY
 */
public class DetallePedido {
    int id_detalle_pedido;
    int cantidad;
    double subtotal;
    Producto libro;
    Pedido pedido;

    public DetallePedido() {
    }

    public DetallePedido( int cantidad, double subtotal, Producto libro, Pedido pedido) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.libro = libro;
        this.pedido = pedido;
    }

    public int getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(int id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getLibro() {
        return libro;
    }

    public void setLibro(Producto libro) {
        this.libro = libro;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
