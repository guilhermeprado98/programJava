/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PedidoController;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import util.DBUtils;

/**
 *
 * @author Ryan Alves
 */
public class Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form Pedido
     */
    private PedidoController pedidoController;

    private int id = 0;
    private int idEq = 0;
    private int idFunc = 0;
    private int idPac = 0;
    private int idStatus = 0;
    private String dtE = "";
    private String dtS = "";

    ResultSet equipamentos = null;
    ResultSet pacs = null;
    ResultSet funcs = null;
    ResultSet pedidos = null;
    ResultSet status = null;

    public Pedidos() {
        initComponents();
        pedidoController = new PedidoController();
        reloadTable();
        //System.out.println(pedidos.toString());
        //System.out.println(pedidos[0].getId());
    }

    public void reloadTable() {
        ResultSet rs = pedidoController.getPedidosTable();
        table.setModel(DBUtils.resultSetToTableModel(rs));
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
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JPaciente = new javax.swing.JComboBox<>();
        JFuncionario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        dtSolicitacaoField = new javax.swing.JTextField();
        dtEntregaField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Equipamento", "Status", "Funcionário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Paciente");

        jLabel2.setText("Funcionario");

        jLabel3.setText("Status");

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Equipamento");

        jLabel5.setText("Solicitação");

        jLabel6.setText("Entrega");

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Remover");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        dtSolicitacaoField.setText("Solicitação");

        dtEntregaField.setText("Entrega");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(JFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(dtEntregaField)
                            .addComponent(dtSolicitacaoField, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtSolicitacaoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtEntregaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        id = 0;
        idEq = 0;
        idFunc = 0;
        idPac = 0;
        idStatus = 0;
        dtE = "";
        dtS = "";
        loadAllData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        equipamentos = pedidoController.getEquipamentos();
        try {
            while (equipamentos.next()) {
                //jcombo.addItem(rSet.getString(campo));
                if (equipamentos.getString("nome").equals(jComboBox3.getSelectedItem().toString())) {
                    idEq = equipamentos.getInt("id");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        funcs = pedidoController.getFuncs();
        try {
            while (funcs.next()) {
                //jcombo.addItem(rSet.getString(campo));
                if (funcs.getString("nome").equals(JFuncionario.getSelectedItem().toString())) {
                    idFunc = funcs.getInt("id");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        pacs = pedidoController.getPacs();
        try {
            while (pacs.next()) {
                //jcombo.addItem(rSet.getString(campo));
                if (pacs.getString("nome").equals(JPaciente.getSelectedItem().toString())) {
                    idPac = pacs.getInt("id");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        status = pedidoController.getStatus();
        try {
            while (status.next()) {
                //jcombo.addItem(rSet.getString(campo));
                if (status.getString("tipo").equals(jComboBox4.getSelectedItem().toString())) {
                    idStatus = status.getInt("id");
                    System.out.println(idStatus);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        dtE = dtEntregaField.getText();
        dtS = dtSolicitacaoField.getText();

        pedidoController.salvar(id, idEq, idFunc, idPac, idStatus, dtE, dtS);
        reloadTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        String _id = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        System.out.println(id);
        id = Integer.parseInt(_id);
        loadAllData();
    }//GEN-LAST:event_tableMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        pedidoController.remover(id);
        reloadTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    public void loadAllData() {

        pedidos = pedidoController.getPedidos();
        try {
            while (pedidos.next()) {
                //jcombo.addItem(rSet.getString(campo));
                System.out.println(pedidos.getInt("id"));
                if (pedidos.getInt("id") == id) {
                    //System.out.println("achô");
                    idEq = pedidos.getInt("idEquipamento");
                    idFunc = pedidos.getInt("idFuncionario");
                    idPac = pedidos.getInt("idPaciente");
                    idStatus = pedidos.getInt("idStatus");
                    dtE = pedidos.getString("dataEntrega");
                    dtS = pedidos.getString("dataSolicitacao");
                    System.out.println(idEq + " " + idFunc + " " + idPac + " " + idStatus);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        funcs = pedidoController.getFuncs();
        setComboData(JFuncionario, funcs, "nome", idFunc);

        pacs = pedidoController.getPacs();
        setComboData(JPaciente, pacs, "nome", idPac);

        equipamentos = pedidoController.getEquipamentos();
        setComboData(jComboBox3, equipamentos, "nome", idEq);

        status = pedidoController.getStatus();
        setComboData(jComboBox4, status, "tipo", idStatus);
        
        dtSolicitacaoField.setText(dtS);
        dtEntregaField.setText(dtE);

    }

    public void setComboData(JComboBox jcombo, ResultSet rSet, String campo, int id) {
        jcombo.removeAllItems();
        int i = 0;
        try {
            while (rSet.next()) {
                jcombo.addItem(rSet.getString(campo));
                if (rSet.getInt("id") == id) {
                    jcombo.setSelectedIndex(i);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JFuncionario;
    private javax.swing.JComboBox<String> JPaciente;
    private javax.swing.JTextField dtEntregaField;
    private javax.swing.JTextField dtSolicitacaoField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}