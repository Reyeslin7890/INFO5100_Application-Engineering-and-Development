/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovernementRole.VerificationRole;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VerificationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reyes
 */
public class ManageVerificationJPanel extends javax.swing.JPanel {

    private JPanel display;
    private UserAccount userAccount;
    private Organization organization;

    public ManageVerificationJPanel(JPanel display, UserAccount userAccount, Organization organization) {
        initComponents();
        this.display = display;
        this.userAccount = userAccount;
        this.organization = organization;
        poptable();
    }

    public void poptable() {
        DefaultTableModel dtm = (DefaultTableModel) Vertable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[5];
            row[0] = request;
            VerificationRequest verificationRequest = (VerificationRequest) request;
            row[1] = verificationRequest.getAge();
            row[2] = verificationRequest.getSsn();
            row[3] = verificationRequest.getReceiver();
            row[4] = verificationRequest.getResult();
            dtm.addRow(row);
        }
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
        Vertable = new javax.swing.JTable();
        assignbtn = new javax.swing.JButton();
        Processbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 153));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5), "Government:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 36)), javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Verificate department", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24)))); // NOI18N

        Vertable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Vertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Applier", "Age", "SSN", "Auditor", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Vertable);

        assignbtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        assignbtn.setText("Assign to me");
        assignbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        assignbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignbtnActionPerformed(evt);
            }
        });

        Processbtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Processbtn.setText("Process Application");
        Processbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Processbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessbtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/GovernementRole/VerificationRole/小人走路.gif"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assignbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Processbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Processbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignbtnActionPerformed
        int selrow = Vertable.getSelectedRow();
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        VerificationRequest verificationRequest = (VerificationRequest) Vertable.getValueAt(selrow, 0);
        if (verificationRequest.getReceiver() != null) {
            JOptionPane.showMessageDialog(null, "This request has been assigned. Please select another row!");
            return;
        }
        if (verificationRequest.getResult() != null) {
            JOptionPane.showMessageDialog(null, "The request has been processed");
            return;
        }
        verificationRequest.setReceiver(userAccount);
        poptable();
    }//GEN-LAST:event_assignbtnActionPerformed

    private void ProcessbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessbtnActionPerformed
        int selrow = Vertable.getSelectedRow();
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        VerificationRequest verificationRequest = (VerificationRequest) Vertable.getValueAt(selrow, 0);
        if (verificationRequest.getReceiver() != userAccount) {
            JOptionPane.showMessageDialog(null, "Please select the request which is assigned to you");
            return;
        }
        if (verificationRequest.getResult() != null) {
            JOptionPane.showMessageDialog(null, "The request is already proccessed!");
            return;
        }

        PersonInfromationFormJPanel panel = new PersonInfromationFormJPanel(display, verificationRequest);
        display.add("PersonInfromationFormJPanel", panel);
        CardLayout layout = (CardLayout) display.getLayout();
        layout.next(display);

    }//GEN-LAST:event_ProcessbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Processbtn;
    private javax.swing.JTable Vertable;
    private javax.swing.JButton assignbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
