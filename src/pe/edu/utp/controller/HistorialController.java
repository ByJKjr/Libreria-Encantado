/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.controller;

import java.util.List;
import java.util.Stack;
import pe.edu.utp.dao.HistorialDAO;
import pe.edu.utp.dao.impl.HistorialDAOImpl;
import pe.edu.utp.model.Historial;

/**
 *
 * @author BRANDY
 */
public class HistorialController {

    private HistorialDAO historialDAO;

    // Constructor que recibe la DAO
    public HistorialController(HistorialDAO historialDAO) {
        this.historialDAO = historialDAO;
    }

    // Constructor por defecto
    public HistorialController() {
        this.historialDAO = new HistorialDAOImpl();
    }

    // Método para obtener todos los historiales
    public List<Historial> obtenerHistoriales() {
        return historialDAO.obtenerHistoriales();
    }

    // Método para agregar un nuevo historial
    public void agregarHistorial(String fecha, String hora, String actividad) {
        Historial nuevoHistorial = new Historial();
        nuevoHistorial.setFecha(fecha);
        nuevoHistorial.setHora(hora);
        nuevoHistorial.setActividad(actividad);
        historialDAO.insertarHistorial(nuevoHistorial);
    }

    public Stack<Historial> pilasHistorial() {
        Stack<Historial> pilaHistorial = new Stack<>();
        List<Historial> historiales = historialDAO.obtenerHistoriales();
        for (Historial historial : historiales) {
          pilaHistorial.push(historial);
        }
        return pilaHistorial;
    }
}
