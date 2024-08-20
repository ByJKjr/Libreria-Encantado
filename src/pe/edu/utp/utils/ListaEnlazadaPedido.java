/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.utils;

import pe.edu.utp.model.DetallePedido;

/**
 *
 * @author mcp
 */
public class ListaEnlazadaPedido {

    //Enlace al primer nodo de la lista
    NodoProducto primero, ultimo;
    int size;

    //Constructor
    public ListaEnlazadaPedido() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    //Método para insertar elementos al inicio de lista
    public void insertarAlInicio(DetallePedido producto) {
        size++;
        NodoProducto nuevoNodo = new NodoProducto(producto);
        nuevoNodo.siguiente = primero;
        primero = nuevoNodo;
    }

    public void insertarAlFinal(DetallePedido producto) {
        size++;
        if (estaVacia()) {
            primero = new NodoProducto(producto);
            ultimo = primero;
        } else {
            ultimo.siguiente = new NodoProducto(producto);
            ultimo = ultimo.siguiente;
        }
    }

    private boolean estaVacia() {
        return primero == null;
    }

    //Método para mostrar elementos de la lista
    public DetallePedido[] imprimirLista() {
        NodoProducto actual = primero;
        int cont = 0;
        while (actual != null) {
            cont++;
            actual = actual.siguiente;
        }
        actual = primero;
        DetallePedido[] productos = new DetallePedido[cont];
        cont = 0;
        while (actual != null) {
            productos[cont] = actual.producto;
            actual = actual.siguiente;
            cont++;
        }

        return productos;
    }

    //Método para buscar un elemento por ID_DVenta
    /*public boolean buscar(Pedido estadoPedido) {
		NodoProducto actual = primero;
		System.out.println(actual.estadoPedido.getId_pedido());
		while(actual != null) {
			if(actual.estadoPedido.equals(estadoPedido)) {
				System.out.println("es igual");
				return true;
			}
			actual=actual.siguiente;
		}
		return false;
	}*/
    //Método para eliminar un elemento de la lista
    public boolean eliminar(DetallePedido producto) {
        if (primero == null) {
            return false;
        }
        if (primero.producto.equals(producto)) {
            primero = primero.siguiente;
            return true;
        }
        NodoProducto actual = primero;
        while (actual.siguiente != null) {
            if (actual.siguiente.producto.equals(producto)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean eliminarPorIndice(int ind) {
        if (ind < 0 || ind >= size) {
            return false; // Índice fuera de rango
        }

        if (ind == 0) {
            // Eliminar el primer nodo
            primero = primero.siguiente;
            size--;
            if (primero == null) {
                ultimo = null; // La lista está vacía
            }
            return true;
        }

        // Buscar el nodo anterior al índice dado
        NodoProducto anterior = obtenerNodo(ind - 1);

        if (anterior != null && anterior.siguiente != null) {
            // Eliminar el nodo en el índice dado
            anterior.siguiente = anterior.siguiente.siguiente;
            size--;
            if (anterior.siguiente == null) {
                ultimo = anterior; // Actualizar el último nodo si se eliminó el último nodo
            }
            return true;
        }

        return false; // No se encontró el nodo o el índice era inválido
    }
    
    private NodoProducto obtenerNodo(int ind) {
        if (ind < 0 || ind >= size) {
            return null; // Índice fuera de rango
        }

        NodoProducto actual = primero;
        for (int i = 0; i < ind; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }
    

    // Método para actualizar los datos de un objeto en la lista
    public boolean actualizar(DetallePedido antiguo, DetallePedido nuevo) {
        NodoProducto actual = primero;
        while (actual != null) {
            if (actual.producto.equals(antiguo)) {
                actual.producto = nuevo;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    
    
    public DetallePedido buscarProductoPorIndice(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista");
        }
        NodoProducto actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.producto;
    }
    
    
    
    
    // Método para ordenar la lista por ID_DVenta usando un algoritmo de selección
    /*public void ordenarPorId() {
        if (primero == null) {
            return;
        }
        NodoProducto actual = primero;
        while (actual != null) {
            NodoProducto min = actual;
            NodoProducto siguiente = actual.siguiente;
            while (siguiente != null) {
                if (siguiente.estadoPedido.getId_pedido()< min.estadoPedido.getId_pedido()) {
                    min = siguiente;
                }
                siguiente = siguiente.siguiente;
            }
            // Intercambiar datos
            Pedido temp = actual.estadoPedido;
            actual.estadoPedido = min.estadoPedido;
            min.estadoPedido = temp;
            actual = actual.siguiente;
        }
    }*/

}
