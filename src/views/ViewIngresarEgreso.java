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
public class ViewIngresarEgreso extends javax.swing.JPanel {

    /**
     * Creates new form ViewIngresarEgreso
     */
    public ViewIngresarEgreso() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_ingresar_egreso = new javax.swing.JTable();
        jl_id_egreso = new javax.swing.JLabel();
        jbtn_agregar = new javax.swing.JButton();
        jl_tipo_egreso = new javax.swing.JLabel();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_salir = new javax.swing.JButton();
        jbtn_nuevo = new javax.swing.JButton();
        jtf_buscar = new javax.swing.JTextField();
        jbtn_buscar = new javax.swing.JButton();
        jtf_aux_id_egreso = new javax.swing.JTextField();
        jtf_asdasd = new javax.swing.JTextField();
        jbtn_editar = new javax.swing.JButton();

        jt_ingresar_egreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_ingresar_egreso);

        jl_id_egreso.setText("ID Egreso");

        jbtn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anadir.png"))); // NOI18N

        jl_tipo_egreso.setText("Tipo Egreso");

        jbtn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N

        jbtn_salir.setText("Salir");

        jbtn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expulsar.png"))); // NOI18N

        jbtn_buscar.setText("Buscar");

        jbtn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jbtn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtf_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtn_buscar)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_id_egreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtf_aux_id_egreso, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtn_nuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtn_agregar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jbtn_eliminar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_tipo_egreso)
                                        .addGap(49, 49, 49)
                                        .addComponent(jtf_asdasd)
                                        .addGap(24, 24, 24)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_id_egreso)
                                    .addComponent(jtf_aux_id_egreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_tipo_egreso)
                                    .addComponent(jtf_asdasd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(113, 113, 113)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtn_nuevo)
                                    .addComponent(jbtn_agregar)
                                    .addComponent(jbtn_eliminar)
                                    .addComponent(jbtn_editar))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_buscar))))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtn_agregar;
    public javax.swing.JButton jbtn_buscar;
    public javax.swing.JButton jbtn_editar;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_salir;
    public javax.swing.JLabel jl_id_egreso;
    public javax.swing.JLabel jl_tipo_egreso;
    public javax.swing.JTable jt_ingresar_egreso;
    public javax.swing.JTextField jtf_asdasd;
    public javax.swing.JTextField jtf_aux_id_egreso;
    public javax.swing.JTextField jtf_buscar;
    // End of variables declaration//GEN-END:variables
}
