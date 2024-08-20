
package pe.edu.utp.model;

/**
 *
 * @author cpech
 */

public class Categoria {
    //Atributos
    private int id_categoria;
    private String nombre;
    
    //Constructor
    public Categoria(){
        
    }
    
    //constructor sobrecargado

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre; 
    }
    
    
    
    
}

