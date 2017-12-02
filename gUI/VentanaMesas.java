/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gUI;

import iciresto.Administrador;
import iciresto.Mesa;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author OMEN
 */
public class VentanaMesas extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private Administrador administrador;
    /**
     * Creates new form VentanaMesas
     */
    public VentanaMesas(int x, int y) {
        administrador = new Administrador();
        initComponents();
        setBounds(x, y, 1024, 768);
        configurarTabla();
    }
    
    public void configurarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Nro de Mesa");
        modelo.addColumn("Capacidad");
        modelo.addColumn("Estado");
        modelo.addColumn("Consumo");
        this.tabla.setModel(modelo);
        TableColumn columnaEstado = tabla.getColumnModel().getColumn(2);        
        String[] estados = {"LIBRE","ASIGNADA","ATENDIDA","RESERVADA","NO HABILITADA"};
        JComboBox comboBoxEstados = new JComboBox(estados);
        TableCellEditor tce = new DefaultCellEditor(comboBoxEstados);
        columnaEstado.setCellEditor(tce);
        addDatos();
    }
    
    public void addDatos(){
        ArrayList<Mesa> listaMesas = administrador.getListaMesas();
        for(int i=0;i<listaMesas.size();i++){
            int capacidad = listaMesas.get(i).getCapacidad();
            String estado = listaMesas.get(i).getEstado();
            int consumo = listaMesas.get(i).getConsumo();
            addDatosFila(capacidad,estado,consumo);
        }
    }
    
    public void recargarTabla(){
        modelo.setRowCount(0);
        addDatos();
        
    }
    
    public void addDatosFila(int capacidad,String estado,int consumo){
        String[] datos = new String[4];
        datos[0] = modelo.getRowCount()+1+"";
        datos[1] = capacidad+"";
        datos[2] = estado;
        datos[3] = consumo+"";
        modelo.addRow(datos);
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
        tabla = new javax.swing.JTable();
        botonAgregarMesas = new javax.swing.JButton();
        botonSalir= new javax.swing.JButton();
        botonGuardarCambios = new javax.swing.JButton();
        botonEliminarMesas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 0));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                if(colIndex == 0){
                    return false;
                }else{
                    return true;
                }
            }
        };
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setFocusable(false);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                tablaAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        botonAgregarMesas.setBackground(new java.awt.Color(255, 153, 0));
        botonAgregarMesas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        botonAgregarMesas.setForeground(new java.awt.Color(153, 0, 0));
        botonAgregarMesas.setText("Agregar Mesa");
        botonAgregarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarMesasActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(255, 153, 0));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(153, 0, 0));
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        
        botonGuardarCambios.setBackground(new java.awt.Color(255, 153, 0));
        botonGuardarCambios.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        botonGuardarCambios.setForeground(new java.awt.Color(153, 0, 0));
        botonGuardarCambios.setText("Guardar Cambios");
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });

        botonEliminarMesas.setBackground(new java.awt.Color(255, 153, 0));
        botonEliminarMesas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        botonEliminarMesas.setForeground(new java.awt.Color(153, 0, 0));
        botonEliminarMesas.setText("Eliminar Mesa");
        botonEliminarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonAgregarMesas)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarMesas)
                        .addGap(18, 18, 18)
                        .addComponent(botonGuardarCambios)
                        .addGap(18, 18, 18)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarMesas)
                    .addComponent(botonSalir)
                    .addComponent(botonGuardarCambios)
                    .addComponent(botonEliminarMesas))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarMesasActionPerformed
        administrador.agregarMesa(modelo.getRowCount()+1);
        addDatosFila(0,"LIBRE",0);       
    }//GEN-LAST:event_botonAgregarMesasActionPerformed

    private void tablaAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_tablaAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaAncestorMoved
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        int reply = JOptionPane.showConfirmDialog(this, "Los datos no guardados se perderán ¿Desea salir de todas formas?", "Precaución", JOptionPane.YES_NO_OPTION);
         if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed
        //Aqui se obtienen todas las mesas y las almacena en la lista de mesas del Administrador
        for(int f=0;f<modelo.getRowCount();f++){
            int numeroMesa = f+1;
            for(int c=1;c<4;c++){
                String valor = modelo.getValueAt(f, c).toString();
                if(c==1){
                    try{
                        if(Integer.valueOf(valor) >= 0){
                           administrador.setCapacidadMesa(numeroMesa, Integer.valueOf(valor));  
                        }else{
                           JOptionPane.showMessageDialog(this, "La Capacidad de la Mesa "+numeroMesa+" contiene caracteres ilegales. Recuerde usar solo numeros positivos.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
                           return; 
                        }                     
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "La Capacidad de la Mesa "+numeroMesa+" contiene caracteres ilegales. Recuerde usar solo numeros positivos.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }else if(c==2){
                    administrador.setEstadoMesa(numeroMesa, valor);
                }else{
                    try{
                        if(Integer.valueOf(valor) >= 0){
                           administrador.setConsumoMesa(numeroMesa, Integer.valueOf(valor)); 
                        }else{
                           JOptionPane.showMessageDialog(this, "El Consumo de la Mesa "+numeroMesa+" contiene caracteres ilegales. Recuerde usar solo numeros positivos.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
                           return; 
                        }
                        
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "El Consumo de la Mesa "+numeroMesa+" contiene caracteres ilegales. Recuerde usar solo numeros.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }
            }
        }
        administrador.guardarContenido();
        JOptionPane.showMessageDialog(this, "Las Mesas han sido guardadas correctamente.", "Cambios Guardados", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
       
    }//GEN-LAST:event_tablaMouseClicked

    private void botonEliminarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarMesasActionPerformed
       int hola = tabla.getSelectedRow();
       
       //Si el metodo tabla.getSelectedRow() da -1 quiere decir que no hay fila seleccionada
       if(tabla.getRowCount() == 0 || tabla.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }else{
            int fila = tabla.getSelectedRow();
            modelo.removeRow(fila);  
            administrador.eliminarMesa(fila);
            
            //Para ordenar nuevamente las filas (Poner sus numeros correspondientes) hay que recargar la tabla
            recargarTabla();
       }
       
    }//GEN-LAST:event_botonEliminarMesasActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarMesas;
    private javax.swing.JButton botonEliminarMesas;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
