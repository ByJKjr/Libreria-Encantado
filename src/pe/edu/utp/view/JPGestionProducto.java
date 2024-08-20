/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pe.edu.utp.view;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controller.CategoriaController;
import pe.edu.utp.controller.AutorController;
import pe.edu.utp.controller.EditorialController;
import pe.edu.utp.controller.ProductoController;
import pe.edu.utp.model.Producto;

/**
 *
 * @author LAB-USR-ATE
 */
public class JPGestionProducto extends javax.swing.JPanel {

    CategoriaController objCategoriaControl = new CategoriaController();
    AutorController objAutorControl = new AutorController();
    EditorialController objEditorialControl = new EditorialController();
    ProductoController objProductoControl = new ProductoController();
    private List<Producto> productos = null;

    public JPGestionProducto() {
        initComponents();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Autor", "Editorial", "Categoria", "ISBN", "Fecha Publicacion", "Idioma", "Precio", "Cantidad"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 690, 420));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("GESTION DE PRODUCTO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 21, -1, -1));

        btnOrdenar.setBackground(new java.awt.Color(102, 255, 102));
        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 90, 30));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 90, 30));

        jLabel2.setText("Buscar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 220, -1));

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 75, 30, 30));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setForeground(new java.awt.Color(153, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/actualizar-flecha.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pdf();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenarTabla();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     actualizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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

        return objModel;
    }

//ESTABLECER DATOS EN LA TABLA
    private void actualizarTabla() {

        DefaultTableModel objModel = crearTabla();

        productos = objProductoControl.obtenerTodosLosProductos();

        //COLOCAR CADA UNO DE LOS DATOS
        for (Producto objProducto : productos) {
            objModel.addRow(new Object[]{objProducto.getId_libro(), objProducto.getTitulo(),
                objProducto.getAutor().toString(), objProducto.getEditorial().toString(),
                objProducto.getCategoria().toString(),
                objProducto.getIsbn(), objProducto.getFecha_publicacion(), objProducto.getIdioma(),
                objProducto.getPrecio(), objProducto.getCantidad()});
        }

        jTable1.setModel(objModel);
    }

    //ORDENA LA TABLA
    private void ordenarTabla() {

        DefaultTableModel objModel = crearTabla();
        //USO DEL QUICKSORT
        quickSort(productos, 0, productos.size() - 1);

        //COLOCAR CADA UNO DE LOS DATOS
        for (Producto objProducto : productos) {
            objModel.addRow(new Object[]{objProducto.getId_libro(), objProducto.getTitulo(),
                objProducto.getAutor().toString(), objProducto.getEditorial().toString(),
                objProducto.getCategoria().toString(),
                objProducto.getIsbn(), objProducto.getFecha_publicacion(), objProducto.getIdioma(),
                objProducto.getPrecio(), objProducto.getCantidad()});
        }

        jTable1.setModel(objModel);
    }

    private void buscar() {
        String titulo = txtBuscar.getText().trim();
        //Quicksort
        quickSort(productos, 0, productos.size() - 1);
        //busqueda binaria
        int index = busquedaBinaria(productos, titulo);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "No se encontro el producto");
            return;
        }
        //crear tabla
        DefaultTableModel objModel = crearTabla();
        Producto objProducto = productos.get(index);

        //colocar elementos
        objModel.addRow(new Object[]{objProducto.getId_libro(), objProducto.getTitulo(),
            objProducto.getAutor().toString(), objProducto.getEditorial().toString(),
            objProducto.getCategoria().toString(),
            objProducto.getIsbn(), objProducto.getFecha_publicacion(), objProducto.getIdioma(),
            objProducto.getPrecio(), objProducto.getCantidad()});
        
        //COLOCAR EL MODELO A LA TABLA
        jTable1.setModel(objModel);

    }
  //----QUICKSORT-----
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

 //PDF
    private void pdf() {
        MessageFormat header = new MessageFormat("Usuarios");
        MessageFormat footer = new MessageFormat("Página {0}");

        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);

            boolean complete = jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, false);
            if (complete) {
                System.out.println("Impresión completada.");
            } else {
                System.out.println("Impresión cancelada.");
            }
        } catch (PrinterException e) {
            System.err.println("Error durante la impresión: " + e.getMessage());
        }
    }

}
