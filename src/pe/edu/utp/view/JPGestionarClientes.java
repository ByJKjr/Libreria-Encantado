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
import pe.edu.utp.model.Cliente;
import pe.edu.utp.controller.ClienteController;

/**
 *
 * @author LAB-USR-ATE
 */
public class JPGestionarClientes extends javax.swing.JPanel {

    /**
     * Creates new form JPGestionarClientes
     */
    ClienteController objClienteControl = new ClienteController();
    List<Cliente> clientes = null;

    public JPGestionarClientes() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gestionar Clientes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 121, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 96, 30));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 96, 30));

        jLabel2.setText("Buscar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 286, -1));

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/buscar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 69, 33, -1));

        btnActualizar.setBackground(new java.awt.Color(153, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/actualizar-flecha.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 40, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        busquedaTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ordenarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pdf();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
            "ID", "Nombre Completo", "Telefono", "Correo", "Direccion"
        };
        objModel.setColumnIdentifiers(columna);
        //Estableciendo el modelo al jtable
        //Colocando el inventario de la bd a cada fila de la tabla

        return objModel;
    }

    //ACTUALIZAR TABLA CLIENTES
    private void actualizarTabla() {

        DefaultTableModel objModel = crearTabla();

        clientes = objClienteControl.obtenerTodosLosClientes();

        for (Cliente cliente : clientes) {
            objModel.addRow(new Object[]{
                cliente.getId_cliente(), cliente.toString(), cliente.getTelefono(),
                cliente.getCorreo_electronico(), cliente.getDireccion()
            });
        }

        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);

    }

    //ORDENAR TABLA
    private void ordenarTabla() {

        DefaultTableModel objModel = crearTabla();
        //QUICKSORT
        quickSort(clientes, 0, clientes.size() - 1);

        for (Cliente cliente : clientes) {
            objModel.addRow(new Object[]{
                cliente.getId_cliente(), cliente.toString(), cliente.getTelefono(),
                cliente.getCorreo_electronico(), cliente.getDireccion()
            });
        }

        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);

    }

    //Busqueda Tabla
    private void busquedaTabla() {
        String nombre = txtBuscar.getText().trim();
        DefaultTableModel objModel = crearTabla();
        //QUICKSORT
        quickSort(clientes, 0, clientes.size() - 1);
        //BUSQUEDA BINARIA
        int index = busquedaBinaria(clientes, nombre);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "No se encontro el cliente");
            return;
        }
        Cliente cliente = clientes.get(index);
        //Configurar tabla
        objModel.addRow(new Object[]{
            cliente.getId_cliente(), cliente.toString(), cliente.getTelefono(),
            cliente.getCorreo_electronico(), cliente.getDireccion()
        });

        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);

    }

    //QUICKSORT
    public static void quickSort(List<Cliente> clientes, int low, int high) {
        if (low < high) {
            int pi = partition(clientes, low, high);

            quickSort(clientes, low, pi - 1);  // Antes de pi
            quickSort(clientes, pi + 1, high); // Después de pi
        }
    }

    private static int partition(List<Cliente> clientes, int low, int high) {
        Cliente pivot = clientes.get(high);
        int i = (low - 1); // índice de elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es más pequeño o igual al pivot
            if (clientes.get(j).getNombre().compareTo(pivot.getNombre()) <= 0) {
                i++;

                // Intercambiar clientes.get(i) y clientes.get(j)
                Cliente temp = clientes.get(i);
                clientes.set(i, clientes.get(j));
                clientes.set(j, temp);
            }
        }

        // Intercambiar clientes.get(i+1) y clientes.get(high) (o pivot)
        Cliente temp = clientes.get(i + 1);
        clientes.set(i + 1, clientes.get(high));
        clientes.set(high, temp);

        return i + 1;
    }

    //BUSQUEDA BINARIA
    public static int busquedaBinaria(List<Cliente> clientes, String nombre) {
        int low = 0;
        int high = clientes.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Cliente midVal = clientes.get(mid);
            int cmp = midVal.getNombre().compareTo(nombre);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Nombre encontrado
            }
        }
        return -1; // Nombre no encontrado
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
