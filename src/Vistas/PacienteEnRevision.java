/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;


import AccesoADatos.DietaData;
import AccesoADatos.PacienteData;
import Entidades.Dieta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class PacienteEnRevision extends javax.swing.JInternalFrame {
 ArrayList<Dieta> listaD;
 DietaData dd;
 PacienteData pD;
 DefaultTableModel modelo = new DefaultTableModel();

    
    public PacienteEnRevision() {
        listaD=new ArrayList<>();
        dd=new DietaData();
        
        initComponents();
         armarCabecera();
         
         cargarDieta();
          
        jLFecha.setText(fechaHoy());
        System.out.println("pasando");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBEliminar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Fecha Actual");

        jLFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLFecha.setText("jLabel2");
        jLFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLFechaPropertyChange(evt);
            }
        });

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

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar.png"))); // NOI18N
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salida.png"))); // NOI18N
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Pacientes en Revision");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(345, 345, 345))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(jLFecha)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jSalir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(jBModificar)
                    .addComponent(jSalir))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
double pesoInicial;
double pesoBuscado ;
 double pesoActual;
 LocalDate fI,fF;  
 
        int fila = jTable1.getSelectedRow();

        if (fila != -1) {
            
            
            
         
//                SimpleDateFormat formato2=new SimpleDateFormat(fF);
            
//                SimpleDateFormat formato=new SimpleDateFormat(fI);
//                Date f1=formato.parse(fI);
//                Date f2=formato2.parse(fF);
int idDieta = (Integer) jTable1.getValueAt(fila, 2);
            System.out.println("fafs"+idDieta);
 if(jTable1.getValueAt(fila, 3) instanceof String ){
 fI= LocalDate.parse((String) jTable1.getValueAt(fila, 3));

}else{
     fI= (LocalDate) jTable1.getValueAt(fila, 3);
    
}
 if(jTable1.getValueAt(fila, 4) instanceof String ){
 fF= LocalDate.parse((String) jTable1.getValueAt(fila, 4));

}else{
     fF= (LocalDate) jTable1.getValueAt(fila, 4);
    
}
            
 
//            System.out.println(fF);
//DateTimeFormatter f= new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toFormatter();
//LocalDate fechaDeInicio = fI;
//LocalDate fechaDeFinal = LocalDate.parse(fF,f);
if(jTable1.getValueAt(fila, 5) instanceof String ){
 pesoInicial=Double.parseDouble((String) jTable1.getValueAt(fila, 5));
System.out.println(" pI"+pesoInicial);
}else{
     pesoInicial=(double) jTable1.getValueAt(fila, 5);
    System.out.println(" pI"+pesoInicial);
}
if(jTable1.getValueAt(fila, 6) instanceof String ){
  pesoBuscado=Double.parseDouble((String) jTable1.getValueAt(fila, 6));
 

}else{
pesoBuscado=(double) jTable1.getValueAt(fila, 6);
}
 if(jTable1.getValueAt(fila, 7) instanceof String ){
  pesoActual=Double.parseDouble((String) jTable1.getValueAt(fila, 7));
 

}else{
pesoActual=(double) jTable1.getValueAt(fila, 7);
}


System.out.println("pA"+pesoActual);

Dieta d1=new Dieta(idDieta,fI,fF,pesoInicial,pesoBuscado,pesoActual,true);
            System.out.println("metodo"+d1);
dd.modificarDieta(d1);
borrarFilas();

   
    
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jLFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLFechaPropertyChange
       
        
    }//GEN-LAST:event_jLFechaPropertyChange

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
       dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        int idDieta = (Integer) jTable1.getValueAt(fila, 2);
        
//       int idPaciente=dd.buscarDietaPorID(idDieta).getPaciente().getIdPaciente();
//        System.out.println(idDieta);
//        System.out.println(idPaciente);
//        pD.eliminarPaciente(idPaciente);
        dd.eliminarDieta(idDieta);
        borrarFilas();
        
    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        ArrayList<Object> lista = new ArrayList<>();
        lista.add("Nombre de los pacientes");
        lista.add("Apellidos de los pacientes");
        lista.add("ID de la dieta");
        lista.add("Fechad De Inicio");
        lista.add("Fecha Final");
        lista.add("Peso Inicial");
        lista.add("Peso Buscado");
        lista.add("Peso Actual");
        for (Object item : lista) {
            modelo.addColumn(item);
        }
        jTable1.setModel(modelo);
        
    }
 private void borrarFilas() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
  private void cargarDieta() {
        borrarFilas();
        listaD = (ArrayList) dd.listarPacientesPorPeso();
        for (Dieta d : listaD) {
            System.out.println(d);
            modelo.addRow(new Object[]{d.getPaciente().getNombre(),d.getPaciente().getApellido(),d.getIdDieta(),d.getFechaInicio(),d.getFechaFinal(),d.getPesoInicial(),d.getPesoBuscado(),d.getPesoActual()});

        }
}
  public static String fechaHoy(){
  Date fecha=new Date();
  SimpleDateFormat formatoFecha=new  SimpleDateFormat("dd/MM/yyyy");
  
  return formatoFecha.format(fecha);
  
  
  }
}

