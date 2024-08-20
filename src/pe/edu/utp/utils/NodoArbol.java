/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.utils;

import java.util.ArrayList;
import pe.edu.utp.model.Pedido;

/**
 *
 * @author BRANDY**/

public class NodoArbol {
    private String nombre;
    private ArrayList<Pedido> pedidos;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    // Constructor
    public NodoArbol(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

    // Método para agregar un pedido al nodo
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}