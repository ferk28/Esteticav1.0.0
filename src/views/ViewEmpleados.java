/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author fernando
 */
public class ViewEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form ViewEmpleados
     */
    public ViewEmpleados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_id_empleado = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jl_edad = new javax.swing.JLabel();
        jl_genero = new javax.swing.JLabel();
        jl_clave_elector = new javax.swing.JLabel();
        jl_telefono = new javax.swing.JLabel();
        jl_telefono2 = new javax.swing.JLabel();
        jl_identificacion = new javax.swing.JLabel();
        jtf_id_empleado = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jtf_clave_elector = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jtf_telefono2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_empleados = new javax.swing.JTable();
        jbtn_nuevo = new javax.swing.JButton();
        jbtn_editar = new javax.swing.JButton();
        jbtn_agregar = new javax.swing.JButton();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_primero = new javax.swing.JButton();
        jbtn_anterior = new javax.swing.JButton();
        jbtn_siguiente = new javax.swing.JButton();
        jbtn_ultimo = new javax.swing.JButton();
        jtf_edad = new javax.swing.JTextField();
        jcb_genero = new javax.swing.JComboBox<>();
        jcb_identificaciones = new javax.swing.JComboBox<>();

        jl_id_empleado.setText("ID Empleado");

        jl_nombre.setText("Nombre");

        jl_edad.setText("Edad");

        jl_genero.setText("Genero");

        jl_clave_elector.setText("Clave de Elector");

        jl_telefono.setText("Telefono");

        jl_telefono2.setText("Telefono 2");

        jl_identificacion.setText("Identificaciones");

        jt_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_empleados);

        jbtn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expulsar.png"))); // NOI18N

        jbtn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes.png"))); // NOI18N

        jbtn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir_1.png"))); // NOI18N

        jbtn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N

        jbtn_primero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espalda (1).png"))); // NOI18N

        jbtn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avance-rapido (3).png"))); // NOI18N

        jbtn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/avance-rapido (2).png"))); // NOI18N

        jbtn_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espalda (2).png"))); // NOI18N

        jtf_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_edadActionPerformed(evt);
            }
        });

        jcb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jcb_identificaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_nombre)
                            .addComponent(jl_id_empleado)
                            .addComponent(jl_edad)
                            .addComponent(jl_genero)
                            .addComponent(jl_clave_elector)
                            .addComponent(jl_telefono)
                            .addComponent(jl_telefono2)
                            .addComponent(jl_identificacion))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtf_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(jtf_clave_elector)
                                .addComponent(jtf_telefono2)
                                .addComponent(jtf_nombre)
                                .addComponent(jtf_id_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtf_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcb_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_identificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_primero)
                        .addGap(72, 72, 72)
                        .addComponent(jbtn_anterior)
                        .addGap(66, 66, 66)
                        .addComponent(jbtn_siguiente)
                        .addGap(50, 50, 50)
                        .addComponent(jbtn_ultimo)
                        .addGap(93, 93, 93)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_agregar)
                    .addComponent(jbtn_eliminar)
                    .addComponent(jbtn_nuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtn_editar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_id_empleado)
                            .addComponent(jtf_id_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nombre)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_edad)
                            .addComponent(jtf_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_genero)
                            .addComponent(jcb_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_clave_elector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_clave_elector))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_telefono)
                            .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_telefono2)
                            .addComponent(jtf_telefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_identificacion)
                            .addComponent(jcb_identificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_primero)
                    .addComponent(jbtn_anterior)
                    .addComponent(jbtn_ultimo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtn_siguiente))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jbtn_nuevo)
                .addGap(65, 65, 65)
                .addComponent(jbtn_editar)
                .addGap(73, 73, 73)
                .addComponent(jbtn_agregar)
                .addGap(67, 67, 67)
                .addComponent(jbtn_eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_edadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtn_agregar;
    public javax.swing.JButton jbtn_anterior;
    public javax.swing.JButton jbtn_editar;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_primero;
    public javax.swing.JButton jbtn_siguiente;
    public javax.swing.JButton jbtn_ultimo;
    public javax.swing.JComboBox<String> jcb_genero;
    public javax.swing.JComboBox<String> jcb_identificaciones;
    public javax.swing.JLabel jl_clave_elector;
    public javax.swing.JLabel jl_edad;
    public javax.swing.JLabel jl_genero;
    public javax.swing.JLabel jl_id_empleado;
    public javax.swing.JLabel jl_identificacion;
    public javax.swing.JLabel jl_nombre;
    public javax.swing.JLabel jl_telefono;
    public javax.swing.JLabel jl_telefono2;
    public javax.swing.JTable jt_empleados;
    public javax.swing.JTextField jtf_clave_elector;
    public javax.swing.JTextField jtf_edad;
    public javax.swing.JTextField jtf_id_empleado;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_telefono;
    public javax.swing.JTextField jtf_telefono2;
    // End of variables declaration//GEN-END:variables
}