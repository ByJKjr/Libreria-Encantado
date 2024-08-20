package pe.edu.utp.model;



//Clase Usuario como Trabajador regiestrado
public class Usuario {
    //Atributos
    private int id_empleado;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String area;
    private String fecha_contratacion;
    private int dni;
    private String correo_electronico;
    
    //Constructor
    public Usuario(){
  
    }
    
    //Constructor sobrecargado

    public Usuario(String nombre, String apellido_paterno, String apellido_materno, String area, String fecha_contratacion, int dni, String correo_electronico) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.area = area;
        this.fecha_contratacion = fecha_contratacion;
        this.dni = dni;
        this.correo_electronico = correo_electronico;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido_paterno + " " + apellido_materno;
    }
    

        

    
    
    
    
    
    
}
