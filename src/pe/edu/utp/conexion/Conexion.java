/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/LibreroEncantado";
    private static final String USUARIO = "macensa_adm001";
    private static final String CONTRASENA = "Macensa@72549774";

    private Connection conexion;
    
    public Conexion() {
        conectar(); // Establecer la conexión al crear una instancia de Conexion
    }

    // Método para establecer la conexión
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
           /* if (conexion != null) {
                System.out.println("Conexión establecida.");
            }*/
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection obtenerConexion() {
        if (conexion == null) {
            conectar(); // Conectar si la conexión aún no está establecida
        }
        return conexion;
    }

}