/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.utils;

import pe.edu.utp.model.DetallePedido;




public class NodoProducto {
    DetallePedido producto;
    NodoProducto siguiente;
    
    //Constructor que inserta al final
    public NodoProducto(DetallePedido producto) {
        this.producto = producto;
        this.siguiente= null;
    }
    //Constructor que inserta al inicio
    public NodoProducto(DetallePedido producto, NodoProducto siguiente) {
        this.producto = producto;
        this.siguiente=siguiente;
    }

    public DetallePedido getProducto() {
        return producto;
    }

    public void setProducto(DetallePedido producto) {
        this.producto = producto;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }

}
