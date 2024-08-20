package pe.edu.utp.model;

/**
 *
 * @author cpech
 */
public class Producto {
    //Atributos
    private int id_libro;
    private String titulo;
    private Autor id_autor;
    private Editorial id_editorial;
    private Categoria id_categoria;
    private long isbn;
    private String fecha_publicacion;
    private String idioma;
    private double precio;
    private int cantidad;
    
    //Constructor
    public Producto() {
    }

    //Constructor sobrecargado

    public Producto(String titulo, Autor id_autor, Editorial id_editorial, Categoria id_categoria, long isbn, String fecha_publicacion, String idioma, double precio, int cantidad) {
        this.titulo = titulo;
        this.id_autor = id_autor;
        this.id_editorial = id_editorial;
        this.id_categoria = id_categoria;
        this.isbn = isbn;
        this.fecha_publicacion = fecha_publicacion;
        this.idioma = idioma;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return id_autor;
    }

    public void setAutor(Autor autor) {
        this.id_autor = autor;
    }

    public Editorial getEditorial() {
        return id_editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.id_editorial = editorial;
    }

    public Categoria getCategoria() {
        return id_categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.id_categoria = categoria;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    

  
 } 