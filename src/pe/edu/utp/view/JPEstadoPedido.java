/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pe.edu.utp.view;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pe.edu.utp.controller.PedidoController;
import pe.edu.utp.model.Pedido;
import pe.edu.utp.utils.ArbolBinario;

/**
 *
 * @author LAB-USR-ATE
 */
public class JPEstadoPedido extends javax.swing.JPanel {

    PedidoController objPedidoControl = new PedidoController();
    List<Pedido> pedidos = null;
    ArbolBinario arbol = null;

    public JPEstadoPedido() {
        initComponents();
        actualizarTablaPedido();
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
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Estado de Pedido");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 640, 430));

        jLabel2.setText("Buscar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 260, -1));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 40, 20));

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setText("ORDENAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 120, 30));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setText("PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 120, 30));

        jLabel3.setText("Pedido:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/utp/img/actualizar-flecha.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 40, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       busquedaTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      ordenarTablaPedido();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       actualizarTablaPedido();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pdf();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
 private DefaultTableModel crearTabla() {
        DefaultTableModel objModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        ;
        };
        String columna[] = {
            "ID", "Fecha_pedido", "Cliente", "Empleado", "Monto(+IGV)", "Estado"
        };
        objModel.setColumnIdentifiers(columna);
        //Estableciendo el modelo al jtable
        //Colocando el inventario de la bd a cada fila de la tabla

        return objModel;
    }
    //ACTUALIZAR TABLA PEDIDO
    private void actualizarTablaPedido() {

        DefaultTableModel objModel = crearTabla();
     
        pedidos = objPedidoControl.obtenerTodosLosPedidos();

        for (Pedido pedido : pedidos) {
            objModel.addRow(new Object[]{
                pedido.getId_pedido(), pedido.getFecha_pedido(), pedido.getCliente().toString(),
                pedido.getEmpleado().toString(), pedido.getIgv() + pedido.getMonto(), pedido.getEstado()
            });
        }

        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
    }
    
    //Ordenar tabla por fecha
    
    private void ordenarTablaPedido() {

        DefaultTableModel objModel = crearTabla();
     
        //QUICKSORT
        quickSort(pedidos, 0, pedidos.size()-1);

        for (Pedido pedido : pedidos) {
            objModel.addRow(new Object[]{
                pedido.getId_pedido(), pedido.getFecha_pedido(), pedido.getCliente().toString(),
                pedido.getEmpleado().toString(), pedido.getIgv() + pedido.getMonto(), pedido.getEstado()
            });
        }

        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
    }
    //Busqueda tabla por nombre del cliente
    private void busquedaTabla(){
        String nombre = txtBuscar.getText().trim();
        DefaultTableModel objModel = crearTabla();
        //OBTENER EL ARBOL CON LOS DATOS
        arbol = objPedidoControl.agregarDatosArbol();
        ArrayList<Pedido> pedidosPorCliente= arbol.buscarPorNombreCliente(nombre);
        
        //Establecer datos a la tabla
        for (Pedido pedido : pedidosPorCliente) {
            objModel.addRow(new Object[]{
                pedido.getId_pedido(), pedido.getFecha_pedido(), pedido.getCliente().toString(),
                pedido.getEmpleado().toString(), pedido.getIgv() + pedido.getMonto(), pedido.getEstado()
            });
        }
        jTable1.setModel(objModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        
    }
    
    //QUICKSORT
    public static void quickSort(List<Pedido> pedidos, int low, int high) {
        if (low < high) {
            int pi = partition(pedidos, low, high);

            quickSort(pedidos, low, pi - 1);  // Antes de pi
            quickSort(pedidos, pi + 1, high); // Después de pi
        }
    }

    private static int partition(List<Pedido> pedidos, int low, int high) {
        Pedido pivot = pedidos.get(high);
        int i = (low - 1); // índice de elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es más grande o igual al pivot (para orden descendente)
            if (pedidos.get(j).getFecha_pedido().compareTo(pivot.getFecha_pedido()) >= 0) {
                i++;
                
                // Intercambiar pedidos.get(i) y pedidos.get(j)
                Pedido temp = pedidos.get(i);
                pedidos.set(i, pedidos.get(j));
                pedidos.set(j, temp);
            }
        }

        // Intercambiar pedidos.get(i+1) y pedidos.get(high) (o pivot)
        Pedido temp = pedidos.get(i + 1);
        pedidos.set(i + 1, pedidos.get(high));
        pedidos.set(high, temp);

        return i + 1;
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
