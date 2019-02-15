/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DistributorRole;

import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Gun.BulletInventoryitem;
import Business.Gun.GunBulletSystem;
import Business.Gun.GunInventoryitem;
import Business.GunSystem;
import Business.Network.Network;
import Business.Organization.Organization;

import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BulletRequst;
import Business.WorkQueue.GunRequest;
import java.awt.CardLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author zhaoh
 */
public class DistributorAdminWorkJPanel extends javax.swing.JPanel {

    private JPanel display;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private GunSystem gunSystem;
    private Network network;
    private OrganizationDirectory directory;
    private GunBulletSystem gunBulletSystem;
    private int expense = 0;

    /**
     * Creates new form DistributorWorkJPanel
     */
    public DistributorAdminWorkJPanel(JPanel display, Enterprise enterprise, UserAccount account, Organization organization, GunSystem system, Network network) {
        initComponents();
        this.display = display;
        this.enterprise = enterprise;
        this.gunSystem = system;
        this.network = network;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        jLabel3.setText(enterprise.getGrade());
        expense = enterprise.getExpense();
        guntoinventory();
        bullettoinventory();
        Codebtn.setText("View Code");
        codelb.setText("");

    }

    public void guntoinventory() {

        for (GunRequest gunRequest : userAccount.getWorkQueue().getGunRequestList()) {

            if (gunRequest.getStatus().equals("completed")) {
                GunInventoryitem gunInventory = enterprise.findguninventory(gunRequest.getGunInventoryitem().getGun());
                if (gunInventory == null) {
                    enterprise.createguninventoryitem(gunRequest.getGunInventoryitem().getGun(), gunRequest.getGunInventoryitem().getGuninventory(), gunRequest.getGunprice());
                    gunRequest.setStatus("Added");
                    expense = expense + gunRequest.getGunInventoryitem().getGuninventory() * gunRequest.getGunprice();
                    enterprise.setExpense(expense);
                } else {
                    int oldquantity = gunInventory.getGuninventory();
                    int oldprice = gunInventory.getPrice();
                    System.out.println(oldquantity);
                    System.out.println(oldprice);
                    int price = (gunRequest.getGunInventoryitem().getGuninventory() * gunRequest.getGunprice() + oldprice * oldquantity) / (gunRequest.getGunInventoryitem().getGuninventory() + oldquantity);
                    gunInventory.setPrice(price);
                    expense = expense + gunRequest.getGunInventoryitem().getGuninventory() * gunRequest.getGunprice();
                    enterprise.setExpense(expense);
                    gunInventory.setnum(gunRequest.getGunInventoryitem().getGuninventory());
                    System.out.println(gunRequest.getGunInventoryitem().getGuninventory());
                    gunRequest.setStatus("Added");
                    System.out.println(expense);
                }

            }
        }
    }

    public void bullettoinventory() {

        for (BulletRequst buRequest : userAccount.getWorkQueue().getBulletRequstList()) {

            if (buRequest.getStatus().equals("completed")) {
                BulletInventoryitem bulletInventoryitem = enterprise.findbulletinventory(buRequest.getBulletInventoryitem().getBullet());
                if (bulletInventoryitem == null) {
                    enterprise.createbulletinventoryitem(buRequest.getBulletInventoryitem().getBullet(), buRequest.getBulletInventoryitem().getBulletinventory(), buRequest.getBulletprice());
                    buRequest.setStatus("Added");
                    expense = expense + buRequest.getBulletInventoryitem().getBulletinventory() * buRequest.getBulletprice();
                    enterprise.setExpense(expense);
                } else {
                    int oldquantity = bulletInventoryitem.getBulletinventory();
                    int oldprice = bulletInventoryitem.getPrice();

                    int price = (buRequest.getBulletInventoryitem().getBulletinventory() * buRequest.getBulletprice() + oldprice * oldquantity) / (buRequest.getBulletInventoryitem().getBulletinventory() + oldquantity);
                    bulletInventoryitem.setPrice(price);
                    expense = expense + buRequest.getBulletInventoryitem().getBulletinventory() * buRequest.getBulletprice();
                    enterprise.setExpense(expense);
                    bulletInventoryitem.setnum(buRequest.getBulletInventoryitem().getBulletinventory());

                    buRequest.setStatus("Added");

                }
            }
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

        manageOrganizationJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        manageOrganizationJButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Codebtn = new javax.swing.JButton();
        codelb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 51));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 51, 204)), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true)));

        manageOrganizationJButton.setBackground(new java.awt.Color(51, 204, 255));
        manageOrganizationJButton.setText("Manage Import");
        manageOrganizationJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), java.awt.Color.white, java.awt.Color.lightGray, new java.awt.Color(255, 255, 255)));
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Distributor:");

        valueLabel.setText("<value>");

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("  Work Area - Aminstrative Role");

        manageOrganizationJButton1.setBackground(new java.awt.Color(51, 204, 255));
        manageOrganizationJButton1.setText("Manage Order");
        manageOrganizationJButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), java.awt.Color.white, java.awt.Color.lightGray, new java.awt.Color(255, 255, 255)));
        manageOrganizationJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Grade:");

        jLabel3.setText("<value>");

        Codebtn.setText("Code");
        Codebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodebtnActionPerformed(evt);
            }
        });

        codelb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codelb.setText("Code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)))
                        .addGap(256, 256, 256)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageOrganizationJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(codelb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Codebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(118, 118, 118)
                .addComponent(manageOrganizationJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(Codebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codelb)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ManageTabbedPanel manageOrganizationJPanel = new ManageTabbedPanel(display, enterprise, enterprise.getOrganizationDirectory(), userAccount, network, gunSystem.getGunBulletSystem());
        display.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) display.getLayout();
        layout.next(display);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageOrganizationJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButton1ActionPerformed
        // TODO add your handling code here:
        ManageOrder manageOJPanel = new ManageOrder(display, enterprise, enterprise.getOrganizationDirectory(), userAccount, network, gunSystem.getGunBulletSystem());
        display.add("manageOJPanel", manageOJPanel);
        CardLayout layout = (CardLayout) display.getLayout();
        layout.next(display);
    }//GEN-LAST:event_manageOrganizationJButton1ActionPerformed

    private void CodebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodebtnActionPerformed

        DistributorEnterprise enter = (DistributorEnterprise) enterprise;
        if (Codebtn.getText().equals("View Code")) {
            codelb.setText(enter.getCode());
            Codebtn.setText("Hide Code");
        } else if (Codebtn.getText().equals("Hide Code")) {
            codelb.setText("");
            Codebtn.setText("Set Code");
        } else if (Codebtn.getText().equals("Set Code")) {
            JPasswordField jpf = new JPasswordField(24);
            JLabel jl = new JLabel("Please input your Code:     ");
            Box box = Box.createHorizontalBox();
            box.add(jl);
            box.add(jpf);
            int x = JOptionPane.showConfirmDialog(null, box, "Code Entry", JOptionPane.OK_CANCEL_OPTION);
            if (x == JOptionPane.CANCEL_OPTION) {
                return;
            }
            enter.setCode(jpf.getText());
            Codebtn.setText("View Code");
        }

    }//GEN-LAST:event_CodebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Codebtn;
    private javax.swing.JLabel codelb;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton manageOrganizationJButton1;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
