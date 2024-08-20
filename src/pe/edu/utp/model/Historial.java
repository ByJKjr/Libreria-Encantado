/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.model;

/**
 *
 * @author BRANDY
 */
public class Historial {
    private int id;
    private String fecha;
    private String hora;
    private String actividad;

    // Constructor
    public Historial(String fecha, String hora, String actividad) {
        this.fecha = fecha;
        this.hora = hora;
        this.actividad = actividad;
    }
    public Historial(){
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getActividad() {
        return actividad;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    // toString method
    @Override
    public String toString() {
        return "Historial{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", actividad='" + actividad + '\'' +
                '}';
    }
  
}
