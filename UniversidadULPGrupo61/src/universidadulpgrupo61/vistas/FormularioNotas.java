/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulpgrupo61.vistas;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import universidadulpgrupo61.accesoADatos.AlumnoData;
import universidadulpgrupo61.accesoADatos.InscripcionData;
import universidadulpgrupo61.accesoADatos.MateriaData;
import universidadulpgrupo61.entidades.*;

/**
 *
 * @author ferge
 */
public class FormularioNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            if (columna == 2) {
                return true;
            }
            return false;
        }
    };

    public FormularioNotas() {
        initComponents();
        this.setTitle("Formulario Notas");
        cargarComboAlumnos();
        cargarTablaActualizacionNotas();
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNotas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cboAlumno = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 427, 10));

        jPanel2.setBackground(new java.awt.Color(148, 56, 95));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbNotas.setAutoCreateRowSorter(true);
        tbNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbNotas.setOpaque(false);
        tbNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbNotasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbNotas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 490, 140));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione un alumno:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, -1));

        cboAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboAlumnoItemStateChanged(evt);
            }
        });
        jPanel2.add(cboAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 280, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 530, 220));

        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 80, -1));

        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 71, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Carga de Notas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if (cboAlumno.getSelectedItem() == null){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno.");
            return;
        }
        
        if (tbNotas.getRowCount() == 0){
            return;
        }
        
        InscripcionData iD = new InscripcionData();
        Alumno a = (Alumno) cboAlumno.getSelectedItem();

//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ENTER);
//            //robot.keyRelease(KeyEvent.VK_ENTER);
//        } catch (AWTException ex) {
//
//        }

        if (tbNotas.isEditing()){
            TableCellEditor editor = tbNotas.getCellEditor();
            editor.stopCellEditing();
        }
        
        for (int fila = 0; fila <= tbNotas.getRowCount() - 1; fila++) {
            int idAlumno = a.getIdAlumno();
            int idMateria = (Integer) tbNotas.getValueAt(fila, 0);
            try{
                double nota = Double.valueOf(tbNotas.getValueAt(fila, 2).toString());
                iD.actualizarNota(idAlumno, idMateria, nota);
            }catch (NumberFormatException nf){
                JOptionPane.showMessageDialog(this, "Ingrese una nota válida.");
                tbNotas.setValueAt(null, fila, 2);
                return;
            }  
        }
        JOptionPane.showMessageDialog(null, "Actualización de notas exitosa.");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboAlumnoItemStateChanged
        if (cboAlumno.getSelectedItem() == null) {
            modelo.setRowCount(0);
            return;
        }

        mostrarDatosTabla();
    }//GEN-LAST:event_cboAlumnoItemStateChanged

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void tbNotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNotasKeyTyped
        char caracter = evt.getKeyChar();
        if (!(((caracter >= '0') && (caracter <= '9') || (caracter == KeyEvent.VK_DELETE)))) {
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tbNotasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Alumno> cboAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbNotas;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/asd.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

    private void cargarComboAlumnos() {
        AlumnoData aD = new AlumnoData();
        List<Alumno> alumnos = aD.listarAlumnos();

        cboAlumno.addItem(null);

        for (Alumno alumno : alumnos) {
            cboAlumno.addItem(alumno);
        }

    }

    private void cargarTablaActualizacionNotas() {
        modelo.addColumn("Código");
        modelo.addColumn("Materia");
        modelo.addColumn("Nota");

        tbNotas.setModel(modelo);

    }

    private void mostrarDatosTabla() {

        InscripcionData iD = new InscripcionData();
        Alumno a = (Alumno) cboAlumno.getSelectedItem();

        List<Inscripcion> notas = iD.obtenerInscripcionesPorAlumno(a.getIdAlumno());

        modelo.setRowCount(0);

        for (Inscripcion inscripcion : notas) {
            this.modelo.addRow(new Object[]{inscripcion.getMateria().getIdMateria(), inscripcion.getMateria().getNombre(), inscripcion.getNota()});
        }

    }

}
