/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject.view;

import dk.cphbusiness.xpscrumproject.Controller;
import dk.cphbusiness.xpscrumproject.entity.Student;
import dk.cphbusiness.xpscrumproject.entity.Subject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dennis
 */
public class Gui extends javax.swing.JFrame {

    
    Controller control;
    DefaultListModel poolA = new DefaultListModel();
    DefaultListModel poolB = new DefaultListModel();
    DefaultListModel poolC = new DefaultListModel();
    DefaultListModel poolUn = new DefaultListModel();
    DefaultTableModel studentModel;
    MyNewCellRenderer cellRender;
    /**
     * Creates new form Gui
     */
    public Gui() {
        control = new Controller(false);
        control.loadStudents(null);
        initComponents();
        cellRender = new MyNewCellRenderer();
        poolA = new DefaultListModel();
        poolB = new DefaultListModel();
        poolC = new DefaultListModel();
        poolUn = new DefaultListModel();
        studentModel = (DefaultTableModel) jTableResult.getModel();
        control.loadDB();
        setjList();
        getCalculatedStudents();
    }
    
    
    public void colorTableRow(){
//        for (int i = 0; i < jTableResult.getRowCount(); i++) {
                for (int j = 0; j < jTableResult.getColumnCount(); j++) {
                    jTableResult.getColumnModel().getColumn(j).setCellRenderer(cellRender);
                    
                }
//        }

    }
    
    public void getCalculatedStudents(){
        List<Student> student = control.calculate();
        studentModel.setRowCount(0);
        studentModel.setRowCount(student.size());
        for (int i = 0; i < student.size(); i++) {
            jTableResult.setValueAt(student.get(i).getName(), i, 0);
            jTableResult.setValueAt(student.get(i).getFirstPriority().get(0), i, 1);
            jTableResult.setValueAt(student.get(i).getFirstPriority().get(1), i, 2);
            jTableResult.setValueAt(student.get(i).getFirstPriority().get(2), i, 3);
            jTableResult.setValueAt(student.get(i).getSecondPriority().get(0), i, 4);
            jTableResult.setValueAt(student.get(i).getSecondPriority().get(1), i, 5);
            jTableResult.setValueAt(student.get(i).getSecondPriority().get(2), i, 6);
            int[] grades = student.get(i).getGrades();
            String grade = grades[0]+"."+grades[1]+"."+grades[2];
            jTableResult.setValueAt(grade, i, 7);            
        }
        colorTableRow();
        
    }
    
    public void sortSubjectLists(List<Subject> list){
        Collections.sort(list, new Comparator<Subject>(){

            @Override
            public int compare(Subject s1, Subject s2) {
                return s1.getTitle().compareToIgnoreCase(s2.getTitle());
            }
            
        });
    }
    
    private void sortList(List<Subject> pool, DefaultListModel model){
        Object[] toArray = pool.toArray();
        Arrays.sort(toArray, new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Subject s1 = (Subject) o1;
                Subject s2 = (Subject) o2;
                
                return s1.getTitle().compareToIgnoreCase(s2.getTitle());
            }
            
        });
        model.removeAllElements();
        for (int i = 0; i < toArray.length; i++) {
           model.addElement(toArray[i]);
        }
    }
    
    public void setjList(){
        poolA.removeAllElements();
        poolB.removeAllElements();
        poolC.removeAllElements();
        poolUn.removeAllElements();
        List<Subject> poolAList = control.getPoolAList();
        List<Subject> poolBList = control.getPoolBList();
        List<Subject> poolCList = control.getPoolCList();
        List<Subject> poolUnList = control.getUnassignedList();

        
        sortList(poolUnList, poolUn);
        sortList(poolAList, poolA);
        sortList(poolBList, poolB);
        sortList(poolCList, poolC);
        
        
        jListPoolA.setModel(poolA);
        jListPoolB.setModel(poolB);
        jListPoolC.setModel(poolC);
        jListUn.setModel(poolUn);
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
        jListPoolA = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPoolB = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListUn = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        jButtonSubmit = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonToPoolA = new javax.swing.JButton();
        jButtonToPoolB = new javax.swing.JButton();
        jLabelPoolA = new javax.swing.JLabel();
        jLabelPoolB = new javax.swing.JLabel();
        JListUn = new javax.swing.JLabel();
        jLabelPoolC = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListPoolC = new javax.swing.JList();
        jButtonToPoolC = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jListPoolA.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListPoolA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 176));

        jListPoolB.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListPoolB);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 176));

        jListUn.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jListUn);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 161, 176));

        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Navn", "First Prio 1", "First Prio 2", "First Prio 3l", "Second Prio 1", "Second Prio 2", "Second Prio 3", "Tilfredshed"
            }
        ));
        jScrollPane4.setViewportView(jTableResult);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 728, 258));

        jButtonSubmit.setText("Submit pools");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));

        jButtonRemove.setText("Remove");
        jButtonRemove.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonRemove.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 120, -1));

        jButtonToPoolA.setText("<-- POOL A");
        jButtonToPoolA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToPoolAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonToPoolA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 107, -1));

        jButtonToPoolB.setText("<-- POOL B");
        jButtonToPoolB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToPoolBActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonToPoolB, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 107, -1));

        jLabelPoolA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPoolA.setText("Pool A");
        getContentPane().add(jLabelPoolA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLabelPoolB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPoolB.setText("Pool B");
        getContentPane().add(jLabelPoolB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 120, -1));

        JListUn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JListUn.setText("Unassigned");
        getContentPane().add(JListUn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 161, -1));

        jLabelPoolC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPoolC.setText("Pool C");
        getContentPane().add(jLabelPoolC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 120, -1));

        jListPoolC.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jListPoolC);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 120, 176));

        jButtonToPoolC.setText("<-- POOL C");
        jButtonToPoolC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToPoolCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonToPoolC, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 107, -1));

        jButtonClear.setText("Clear Pools");
        jButtonClear.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonClear.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 107, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonToPoolAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToPoolAActionPerformed
        List<Subject> unList = jListUn.getSelectedValuesList();
        if(unList.isEmpty()){
        }else{
            for (int i = 0; i < unList.size(); i++) {
                control.moveFromTo((Subject)unList.get(i), "Unassigned", "A");
                
            }
            setjList();
            getCalculatedStudents();
        }
    }//GEN-LAST:event_jButtonToPoolAActionPerformed

    private void jButtonToPoolBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToPoolBActionPerformed
        List unList = jListUn.getSelectedValuesList();
        if(unList.isEmpty()){
        }else{
            for (int i = 0; i < unList.size(); i++) {
                control.moveFromTo((Subject)unList.get(i), "Unassigned", "B");
            }
        }
        setjList();
        getCalculatedStudents();
    }//GEN-LAST:event_jButtonToPoolBActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        if(jListPoolA.getSelectedIndex() != -1){
        List aList = jListPoolA.getSelectedValuesList();
            for (int i = 0; i < aList.size(); i++) {
                control.moveFromTo((Subject)aList.get(i), "A", "Unassigned");
            }
        }
        if(jListPoolB.getSelectedIndex() != -1){
        List bList = jListPoolB.getSelectedValuesList();
            for (int i = 0; i < bList.size(); i++) {
                control.moveFromTo((Subject)bList.get(i), "B", "Unassigned");
            }
        }
        if(jListPoolC.getSelectedIndex() != -1){
        List cList = jListPoolC.getSelectedValuesList();
            for (int i = 0; i < cList.size(); i++) {
                control.moveFromTo((Subject)cList.get(i), "C", "Unassigned");
            }
        }
       setjList();
       getCalculatedStudents();
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        control.submitPools();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonToPoolCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToPoolCActionPerformed
        List unList = jListUn.getSelectedValuesList();
        if(unList.isEmpty()){
        }else{
            for (int i = 0; i < unList.size(); i++) {
                control.moveFromTo((Subject)unList.get(i), "Unassigned", "C");
                
            }
        }
        setjList();
        getCalculatedStudents();
    }//GEN-LAST:event_jButtonToPoolCActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        control.resetPools();
        setjList();
        getCalculatedStudents();
    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JListUn;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JButton jButtonToPoolA;
    private javax.swing.JButton jButtonToPoolB;
    private javax.swing.JButton jButtonToPoolC;
    private javax.swing.JLabel jLabelPoolA;
    private javax.swing.JLabel jLabelPoolB;
    private javax.swing.JLabel jLabelPoolC;
    private javax.swing.JList jListPoolA;
    private javax.swing.JList jListPoolB;
    private javax.swing.JList jListPoolC;
    private javax.swing.JList jListUn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableResult;
    // End of variables declaration//GEN-END:variables
}
