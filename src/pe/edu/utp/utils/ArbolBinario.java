/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.utils;

import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.model.Pedido;

import java.util.ArrayList;

public class ArbolBinario {
    private NodoArbol raiz;

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para insertar un pedido en el árbol
    public void insertar(Pedido pedido) {
        raiz = insertarRecursivo(raiz, pedido);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Pedido pedido) {
        if (nodo == null) {
            nodo = new NodoArbol(pedido.getCliente().getNombre());
            nodo.agregarPedido(pedido);
            return nodo;
        }

        int comparacion = pedido.getCliente().getNombre().compareTo(nodo.getNombre());
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), pedido));
        } else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), pedido));
        } else {
            nodo.agregarPedido(pedido);
        }

        return nodo;
    }

    // Método para buscar pedidos por nombre de cliente
    public ArrayList<Pedido> buscarPorNombreCliente(String nombre) {
        NodoArbol nodo = buscarRecursivo(raiz, nombre);
        return nodo != null ? nodo.getPedidos() : null;
    }

    private NodoArbol buscarRecursivo(NodoArbol nodo, String nombre) {
        if (nodo == null || nodo.getNombre().equals(nombre)) {
            return nodo;
        }

        int comparacion = nombre.compareTo(nodo.getNombre());
        if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), nombre);
        } else {
            return buscarRecursivo(nodo.getDerecho(), nombre);
        }
    }

    // Método para mostrar el árbol en orden (para depuración)
    public void mostrarEnOrden() {
        mostrarEnOrdenRecursivo(raiz);
    }

    private void mostrarEnOrdenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            mostrarEnOrdenRecursivo(nodo.getIzquierdo());
            System.out.println("Cliente Nombre: " + nodo.getNombre());
            for (Pedido pedido : nodo.getPedidos()) {
                System.out.println("\tPedido: " + pedido.getId_pedido());
            }
            mostrarEnOrdenRecursivo(nodo.getDerecho());
        }
    }
}
