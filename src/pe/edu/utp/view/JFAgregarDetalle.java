/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.utp.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controller.DetallePedidoController;
import pe.edu.utp.controller.HistorialController;
import pe.edu.utp.controller.PedidoController;
import pe.edu.utp.controller.ProductoController;
import pe.edu.utp.model.DetallePedido;
import pe.edu.utp.model.Producto;
import pe.edu.utp.model.Pedido;

/**
 *
 * @author BRANDY
 */
public class JFAgregarDetalle extends javax.swing.JFrame {

    JPActualizarPedido objPedido;
    DetallePedidoController objDetalleControl = new DetallePedidoController();
    ProductoController objProductoControl = new ProductoController();
    PedidoController objPedidoControl = new PedidoController();
    HistorialController objHistorialControl = new HistorialController();

    List<Producto> productos = null;
    int idPedido;

    public JFAgregarDetalle(JPActualizarPedido objPedido, int id_pedido) {
        initComponents();
        this.objPedido = objPedido;
        this.idPedido = id_pedido;
        actualizarTablaProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Agregar Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 690, 270));

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Productos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 120, -1));

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Buscar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 50, 50, -1));
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 160, 20));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 40, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    //CREAR TABLA
    private DefaultTableModel crearTabla() {
        DefaultTableModel objModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        ;
        };
        String columna[] = {
            "Id", "Titulo", "Autor", "Editorial",
            "Categoria", "ISBN", "Publicacion", "Idioma", "Precio", "Stock"
        };
        objModel.setColumnIdentifiers(columna);
        //Estableciendo el modelo al jtable
        //Colocando el inventario de la bd a cada fila de la tabla

        return objModel;
    }

    private void actualizarTablaProducto() {

        DefaultTableModel objModel = crearTabla();

        productos = objProductoControl.obtenerTodosLosProductos();

        for (Producto objProducto : productos) {
            objModel.addRow(new Object[]{objProducto.getId_libro(), objProducto.getTitulo(),
                objProducto.getAutor().toString(), objProducto.getEditorial().toString(),
                objProducto.getCategoria().toString(),
                objProducto.getIsbn(), objProducto.getFecha_publicacion(), objProducto.getIdioma(),
                objProducto.getPrecio(), objProducto.getCantidad()});
        }

        jTable1.setModel(objModel);
    }

    private void busquedaTablaProducto() {
        String titulo = txtBuscar.getText().trim();
        DefaultTableModel objModel = crearTabla();

        quickSort(productos, 0, productos.size() - 1);
        busquedaBinaria(productos, titulo);

        for (Producto objProducto : productos) {
            objModel.addRow(new Object[]{objProducto.getId_libro(), objProducto.getTitulo(),
                objProducto.getAutor().toString(), objProducto.getEditorial().toString(),
                objProducto.getCategoria().toString(),
                objProducto.getIsbn(), objProducto.getFecha_publicacion(), objProducto.getIdioma(),
                objProducto.getPrecio(), objProducto.getCantidad()});
        }

        jTable1.setModel(objModel);
    }

    private void agregarProducto() {
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            if (!verificarExistencia(id)) {
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
                double precio = (double) jTable1.getValueAt(filaSeleccionada, 8);
                double subtotal = cantidad * precio;
                Producto libro = objProductoControl.obtenerProductoPorId(id);
                Pedido pedido = objPedidoControl.obtenerPedidoPorId(idPedido);
                DetallePedido detalle = new DetallePedido(cantidad, subtotal, libro, pedido);
                objDetalleControl.guardarDetallePedido(cantidad, subtotal, libro, pedido);

                objPedido.productosPorPedido.get(idPedido).add(detalle);//hashmap

                //PILAS: AGREGAR AL HISTORIAL
                String fechaActual = LocalDate.now().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaActual = LocalTime.now().format(formatter);
                String actividad = "Se agrego un producto en un pedido";
                objHistorialControl.agregarHistorial(fechaActual, horaActual, actividad);
                //-----
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "El producto ya esta asignado al pedido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun producto");
        }
    }

    private boolean verificarExistencia(int id) {
        ArrayList<DetallePedido> productosExistentes = objPedido.productosPorPedido.get(idPedido);
        for (DetallePedido producto : productosExistentes) {
            if (id == producto.getLibro().getId_libro()) {
                return true;
            }
        }
        return false;
    }

    //----------------QUICKSORT----------
    public static void quickSort(List<Producto> productos, int low, int high) {
        if (low < high) {
            int pi = partition(productos, low, high);

            quickSort(productos, low, pi - 1);  // Antes de pi
            quickSort(productos, pi + 1, high); // Después de pi
        }
    }

    private static int partition(List<Producto> productos, int low, int high) {
        Producto pivot = productos.get(high);
        int i = (low - 1); // índice de elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es más pequeño o igual al pivot
            if (productos.get(j).getTitulo().compareTo(pivot.getTitulo()) <= 0) {
                i++;

                // Intercambiar productos.get(i) y productos.get(j)
                Producto temp = productos.get(i);
                productos.set(i, productos.get(j));
                productos.set(j, temp);
            }
        }

        // Intercambiar productos.get(i+1) y productos.get(high) (o pivot)
        Producto temp = productos.get(i + 1);
        productos.set(i + 1, productos.get(high));
        productos.set(high, temp);

        return i + 1;
    }

    //BUSQUEDA BINARIA
    public static int busquedaBinaria(List<Producto> productos, String titulo) {
        int low = 0;
        int high = productos.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Producto midVal = productos.get(mid);
            int cmp = midVal.getTitulo().compareTo(titulo);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Título encontrado
            }
        }
        return -1; // Título no encontrado
    }
}
