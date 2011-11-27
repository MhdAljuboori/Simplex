/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainForm.java
 *
 * Created on Nov 26, 2011, 2:53:07 PM
 */
package main;

import OR.Matrix;
import OR.SimplexProblem;
import OR.SolutionList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sun.util.logging.resources.logging;

/**
 *
 * @author mhd
 */
public class MainForm extends javax.swing.JFrame {

    /** Creates new form MainForm */
    public MainForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabConditions = new javax.swing.JTable();
        btnAddVar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabC = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabB = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblZstatement = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMaxMin = new javax.swing.JComboBox();
        btnAddCondition = new javax.swing.JButton();
        btnRemoveCondition = new javax.swing.JButton();
        btnRemoveVar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabTable = new javax.swing.JTable();
        btnSolve = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabSolutions = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tabConditions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "X1", "X2", "X3", "X4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabConditions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(tabConditions);

        btnAddVar.setText("+");
        btnAddVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVarActionPerformed(evt);
            }
        });

        tabC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "X1", "X2", "X3", "X4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane2.setViewportView(tabC);

        jLabel1.setText("C =");

        jLabel2.setText("A = ");

        tabB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "b"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabB);

        jLabel3.setText("<=");

        lblZstatement.setText("maxZ = C . X");

        jLabel5.setText("subjected to : ");

        cbMaxMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Max", "Min" }));
        cbMaxMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaxMinActionPerformed(evt);
            }
        });

        btnAddCondition.setText("+");
        btnAddCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddConditionActionPerformed(evt);
            }
        });

        btnRemoveCondition.setText("-");
        btnRemoveCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveConditionActionPerformed(evt);
            }
        });

        btnRemoveVar.setText("-");
        btnRemoveVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveVarActionPerformed(evt);
            }
        });

        jLabel4.setText("Variables");

        jLabel6.setText("Conditions");

        tabTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Z", "X1", "X2", "X3", "X4", "RHS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane4.setViewportView(tabTable);

        btnSolve.setText("Solve");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        tabSolutions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Z", "X1", "X2", "X3", "X4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabSolutions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane5.setViewportView(tabSolutions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cbMaxMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddCondition)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemoveCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)
                                        .addComponent(btnSolve))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddVar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemoveVar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblZstatement)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddCondition, btnAddVar, btnRemoveCondition, btnRemoveVar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZstatement)
                    .addComponent(cbMaxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddVar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveVar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddCondition)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRemoveCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSolve)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddCondition, btnAddVar, btnRemoveCondition, btnRemoveVar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAddVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVarActionPerformed
// TODO add your handling code here:
    TableColumn newCol = new TableColumn();
    newCol.setHeaderValue("X" +  (tabConditions.getColumnCount() + 1));
    tabConditions.addColumn(newCol);
    
    newCol = new TableColumn();
    newCol.setHeaderValue("X" +  (tabC.getColumnCount() + 1));
    tabC.addColumn(newCol);
}//GEN-LAST:event_btnAddVarActionPerformed

private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
// TODO add your handling code here:
    
}//GEN-LAST:event_formComponentShown

private void cbMaxMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaxMinActionPerformed
// TODO add your handling code here:
    lblZstatement.setText(cbMaxMin.getSelectedItem().toString().toLowerCase() + "Z = C . X");
}//GEN-LAST:event_cbMaxMinActionPerformed

private void btnAddConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddConditionActionPerformed
// TODO add your handling code here:
   DefaultTableModel model = (DefaultTableModel) tabConditions.getModel();
   model.addRow(new java.util.Vector<Object>());
   model = (DefaultTableModel) tabB.getModel();
   model.addRow(new java.util.Vector<Object>());
}//GEN-LAST:event_btnAddConditionActionPerformed

private void btnRemoveConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveConditionActionPerformed
   DefaultTableModel model = (DefaultTableModel) tabConditions.getModel();
   int count = tabConditions.getRowCount();
   model.removeRow(count-1);
   model = (DefaultTableModel) tabB.getModel();
   model.removeRow(count-1);
}//GEN-LAST:event_btnRemoveConditionActionPerformed

private void btnRemoveVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveVarActionPerformed
// TODO add your handling code here:
    int count = tabConditions.getColumnCount();
    tabConditions.getColumnModel().removeColumn(tabConditions.getColumn("X" + (count)));
    tabC.getColumnModel().removeColumn(tabC.getColumn("X" + (count)));
    System.out.println(tabConditions.getColumnCount()); 
}//GEN-LAST:event_btnRemoveVarActionPerformed

private double[][] Vector2doubleArray(Vector<Vector<Double>> a) {
    int n = tabConditions.getColumnCount();
    int m = tabConditions.getRowCount();
    double[][] doubles = new double[m][n];
    for (int i=0;i<m;i++) {
        for (int j=0;j<n;j++)
            doubles[i][j] = a.get(i).get(j);
    }
    return doubles;
}

private Double[][] Vector2DoubleArray(Vector<Vector<Double>> a) {
    int n = tabConditions.getColumnCount();
    int m = tabConditions.getRowCount();
    Double[][] doubles = new Double[m][n];
    for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++)
            doubles[i][j] = a.get(i).get(j);
    }
    return doubles;
}

private double[][] getDataFromTable(JTable table) {
    int n = table.getColumnCount();
    int m = table.getRowCount();
    double[][] doubles = new double[m][n];
    for (int i=0;i<m;i++) {
        for (int j=0;j<n;j++)
            doubles[i][j] = ((Double)table.getValueAt(i, j)).doubleValue();
    }
    return doubles;
}

private static Double[] double2Double(double[] a) {
    
    Double[] doubles = new Double[a.length];
    for (int i=0;i<a.length;i++) {
            doubles[i] = a[i];
    }
    return doubles;
}

private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
// TODO add your handling code here:
    
    double[][] A = getDataFromTable(tabConditions);

    double[] C = getDataFromTable(tabC)[0];
    
    double[] b = new Matrix(getDataFromTable(tabB)).transpose().getArray()[0];
    
    SimplexProblem problem = new SimplexProblem(SimplexProblem.ProblemType.valueOf(cbMaxMin.getSelectedItem().toString()),
            A, double2Double(C), double2Double(b));
    SolutionList list = problem.solveByTableSimplex();
    DefaultTableModel model;
    model = (DefaultTableModel)tabSolutions.getModel();
   
    while (list.getLength() > tabSolutions.getColumnCount()) {
        TableColumn newCol = new TableColumn();
        newCol.setHeaderValue("X" +  (tabSolutions.getColumnCount() + 1));
        tabSolutions.addColumn(newCol);
    }
    
    //model.setColumnCount(list.getLength());
    for (int i=0;i<list.size();i++) {
        Double[] row = list.get(i);
        model.addRow(row);
    }
}//GEN-LAST:event_btnSolveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCondition;
    private javax.swing.JButton btnAddVar;
    private javax.swing.JButton btnRemoveCondition;
    private javax.swing.JButton btnRemoveVar;
    private javax.swing.JButton btnSolve;
    private javax.swing.JComboBox cbMaxMin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblZstatement;
    private javax.swing.JTable tabB;
    private javax.swing.JTable tabC;
    private javax.swing.JTable tabConditions;
    private javax.swing.JTable tabSolutions;
    private javax.swing.JTable tabTable;
    // End of variables declaration//GEN-END:variables
}
