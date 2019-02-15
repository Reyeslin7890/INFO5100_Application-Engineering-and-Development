/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Gun.Bullet;
import Business.Gun.BulletInventoryitem;
import Business.Gun.Gun;
import Business.Gun.GunBulletSystem;
import Business.Gun.GunInventoryitem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ShopRequest;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reyes
 */
public class ShopGuns extends javax.swing.JPanel {
    
    private JPanel display;
    private UserAccount userAccount;
    private Network network;
    private final GunBulletSystem gbs;
    private Object[][] cartitem;
    private int itemnum;
    
    public ShopGuns(JPanel display, UserAccount userAccount, Network network) {
        initComponents();
        this.display = display;
        this.userAccount = userAccount;
        this.network = network;
        gbs = GunBulletSystem.getInstance();
        cartitem = new Object[100][5];
        itemnum = 0;
        popcombo1();
        popcombo2();
        txt1.setText("0");
        txt2.setText("0");
        
    }
    
    public void popcombo1() {
        int itemCount = combo1.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            combo1.removeItemAt(0);
        }
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof DistributorEnterprise) {
                combo1.addItem(enterprise);
            }
        }
    }
    
    public void popcombo2() {
        int itemCount = combo2.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            combo2.removeItemAt(0);
        }
        combo2.addItem("Gun");
        combo2.addItem("Bullet");
    }
    
    public void poptable1(Enterprise enterprise) {
        DefaultTableModel dtm1 = (DefaultTableModel) tbl1.getModel();
        dtm1.setRowCount(0);
        for (GunInventoryitem item : enterprise.getGunInventory()) {
            Object[] row = new Object[2];
            row[0] = item.getGun();
            row[1] = item.getPrice();
            dtm1.addRow(row);
        }
    }
    
    public void poptable2(Enterprise enterprise) {
        DefaultTableModel dtm2 = (DefaultTableModel) tbl2.getModel();
        dtm2.setRowCount(0);
        for (BulletInventoryitem item : enterprise.getBulletInventory()) {
            Object[] row = new Object[2];
            row[0] = item.getBullet();
            row[1] = item.getPrice();
            dtm2.addRow(row);
        }
    }
    
    public void poptable3(Gun gun) {
        if (gun == null) {
            return;
        }
        DefaultTableModel dtm3 = (DefaultTableModel) tbl3.getModel();
        dtm3.setRowCount(0);
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof DistributorEnterprise) {
                for (GunInventoryitem item : enterprise.getGunInventory()) {
                    if (item.getGun().getName().equals(gun.getName())) {
                        Object[] row = new Object[3];
                        row[0] = item.getGun();
                        row[1] = enterprise;
                        row[2] = item.getPrice();
                        dtm3.addRow(row);
                        break;
                    }
                }
            }
        }
    }
    
    public void poptable3(Bullet bullet) {
        if (bullet == null) {
            return;
        }
        DefaultTableModel dtm3 = (DefaultTableModel) tbl3.getModel();
        dtm3.setRowCount(0);
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise instanceof DistributorEnterprise) {
                for (BulletInventoryitem item : enterprise.getBulletInventory()) {
                    if (item.getBullet().getName().equals(bullet.getName())) {
                        Object[] row = new Object[3];
                        row[0] = item.getBullet();
                        row[1] = enterprise;
                        row[2] = item.getPrice();
                        dtm3.addRow(row);
                        break;
                    }
                }
            }
        }
    }
    
    public void popcart() {
        DefaultTableModel ca = (DefaultTableModel) cart.getModel();
        ca.setRowCount(0);
        int tot = 0;
        Object[] enter = new Object[100];
        int enternum = 0;
        for (int i = 0; i < itemnum; i++) {
            ca.addRow(cartitem[i]);
            tot += (int) cartitem[i][4];
            boolean flag = false;
            for (int j = 0; j < enternum; j++) {
                if (cartitem[i][0].equals(enter[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                enter[enternum] = cartitem[i][0];
                enternum++;
            }
        }
        if (enternum > 0) {
            tot += (enternum - 1) * 10;
        }
        tottxt.setText(String.valueOf(tot));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbed = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        addguntocartbtn = new javax.swing.JButton();
        addbullettocartbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();
        Additemtocartbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        combo2 = new javax.swing.JComboBox<>();
        combo3 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        Checkoutbtn = new javax.swing.JButton();
        Removeitembtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tottxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to Gun Shop", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(0, 102, 255))); // NOI18N

        tabbed.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabbed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Shop:");

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gun", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bullet", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl2);

        addguntocartbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addguntocartbtn.setForeground(new java.awt.Color(153, 0, 153));
        addguntocartbtn.setText("<html>Add Gun<br />To Cart</html>");
        addguntocartbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addguntocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addguntocartbtnActionPerformed(evt);
            }
        });

        addbullettocartbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addbullettocartbtn.setForeground(new java.awt.Color(153, 0, 153));
        addbullettocartbtn.setText("<html>Add Bullet<br />   To Cart</html>");
        addbullettocartbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addbullettocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbullettocartbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("Quantity");

        txt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt1.setForeground(new java.awt.Color(153, 0, 153));
        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt1KeyTyped(evt);
            }
        });

        combo1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(302, 302, 302))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(addguntocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addComponent(addbullettocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addbullettocartbtn, addguntocartbtn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addguntocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbullettocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addbullettocartbtn, addguntocartbtn});

        tabbed.addTab("Shops List", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Shop", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl3);

        Additemtocartbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Additemtocartbtn.setForeground(new java.awt.Color(153, 0, 153));
        Additemtocartbtn.setText("<html>Add Item<br />   To Cart</html>");
        Additemtocartbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Additemtocartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdditemtocartbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setText("Quantity");

        txt2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt2.setForeground(new java.awt.Color(153, 0, 153));
        txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt2KeyTyped(evt);
            }
        });

        combo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo2ActionPerformed(evt);
            }
        });

        combo3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20))
                    .addComponent(txt2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(Additemtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Additemtocartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabbed.addTab("Search", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shop", "Item", "Price", "Quantity", "Item Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(cart);

        Checkoutbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Checkoutbtn.setForeground(new java.awt.Color(0, 0, 255));
        Checkoutbtn.setText("Checkout");
        Checkoutbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Checkoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutbtnActionPerformed(evt);
            }
        });

        Removeitembtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Removeitembtn.setForeground(new java.awt.Color(0, 0, 255));
        Removeitembtn.setText("Remove Item");
        Removeitembtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Removeitembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveitembtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Total Price:");

        tottxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tottxt.setForeground(new java.awt.Color(51, 51, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tips: Buying items from different shops will result in more costs.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Checkoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Removeitembtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGap(28, 28, 28)
                            .addComponent(tottxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Checkoutbtn, Removeitembtn});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Removeitembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tottxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Checkoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Checkoutbtn, Removeitembtn});

        tabbed.addTab("View Cart", jPanel3);

        Backbtn.setBackground(new java.awt.Color(153, 153, 255));
        Backbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Backbtn.setText("<<Back");
        Backbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Backbtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ManufactureRole/回滚箭头.jpg"))); // NOI18N
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Backbtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        display.remove(this);
        CardLayout layout = (CardLayout) display.getLayout();
        layout.previous(display);
    }//GEN-LAST:event_BackbtnActionPerformed

    private void AdditemtocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdditemtocartbtnActionPerformed
        int selrow = tbl3.getSelectedRow();
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        cartitem[itemnum][0] = tbl3.getValueAt(selrow, 1);
        cartitem[itemnum][1] = tbl3.getValueAt(selrow, 0);
        cartitem[itemnum][2] = (int) tbl3.getValueAt(selrow, 2);
        cartitem[itemnum][3] = Integer.parseInt(txt2.getText());
        cartitem[itemnum][4] = (int) cartitem[itemnum][2] * (int) cartitem[itemnum][3];
        itemnum++;
    }//GEN-LAST:event_AdditemtocartbtnActionPerformed

    private void txt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt1KeyTyped

    private void txt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt2KeyTyped

    private void tabbedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedMouseClicked
        popcart();
    }//GEN-LAST:event_tabbedMouseClicked

    private void addguntocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addguntocartbtnActionPerformed
        int selrow = tbl1.getSelectedRow();
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from gun table!");
            return;
        }
        cartitem[itemnum][0] = combo1.getSelectedItem();
        cartitem[itemnum][1] = (Gun)tbl1.getValueAt(selrow, 0);
        cartitem[itemnum][2] = (int) tbl1.getValueAt(selrow, 1);
        cartitem[itemnum][3] = Integer.parseInt(txt1.getText());
        cartitem[itemnum][4] = (int) cartitem[itemnum][2] * (int) cartitem[itemnum][3];
        itemnum++;
    }//GEN-LAST:event_addguntocartbtnActionPerformed

    private void addbullettocartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbullettocartbtnActionPerformed
        int selrow = tbl2.getSelectedRow();
        
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from bullet table!");
            return;
        }
        cartitem[itemnum][0] = combo1.getSelectedItem();
        cartitem[itemnum][1] = tbl2.getValueAt(selrow, 0);
        cartitem[itemnum][2] = (int) tbl2.getValueAt(selrow, 1);
        cartitem[itemnum][3] = Integer.parseInt(txt1.getText());
        cartitem[itemnum][4] = (int) cartitem[itemnum][2] * (int) cartitem[itemnum][3];
        itemnum++;
    }//GEN-LAST:event_addbullettocartbtnActionPerformed

    private void RemoveitembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveitembtnActionPerformed
        int selrow = cart.getSelectedRow();
        if (selrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an item!");
            return;
        }
        cartitem[selrow] = cartitem[itemnum - 1];
        itemnum--;
        popcart();

    }//GEN-LAST:event_RemoveitembtnActionPerformed

    private void combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo2ActionPerformed
        combo3.removeAllItems();
        if (combo2.getSelectedItem().equals("Gun")) {
            for (Gun gun : gbs.getGunDirectory().getGunList()) {
                combo3.addItem(gun);
            }
        } else {
            gbs.getBulletDirectory().getBulletList().forEach((bullet) -> {
                combo3.addItem(bullet);
            });
        }
        DefaultTableModel dtm3 = (DefaultTableModel) tbl3.getModel();
        dtm3.setRowCount(0);

    }//GEN-LAST:event_combo2ActionPerformed

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
        if (combo2.getSelectedItem().equals("Gun")) {
            Gun gun = (Gun) combo3.getSelectedItem();
            poptable3(gun);
        } else {
            Bullet bullet = (Bullet) combo3.getSelectedItem();
            poptable3(bullet);
        }
    }//GEN-LAST:event_combo3ActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        Object x = combo1.getSelectedItem();
        if (!(x instanceof Enterprise)) {
            return;
        }
        Enterprise enterprise = (Enterprise) x;
        poptable1(enterprise);
        poptable2(enterprise);
    }//GEN-LAST:event_combo1ActionPerformed

    private void CheckoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutbtnActionPerformed
        if (itemnum <= 0) {
            JOptionPane.showMessageDialog(null, "Please buy something!");
            return;
        }
        
        if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(null, "Your total is " + tottxt.getText() + ". Are you sure to buy the items?", "Last Confirm", JOptionPane.YES_NO_OPTION)) {
            return;
        }
        for (int i = 0; i < itemnum; i++) {
            DistributorEnterprise distributorEnterprise = (DistributorEnterprise) cartitem[i][0];
            int quan = (int) cartitem[i][3];
            int price = (int) cartitem[i][2];
            ShopRequest shopRequest = new ShopRequest();
            shopRequest.setSender(userAccount);
            shopRequest.setQuantity(quan);
            shopRequest.setPrice(price);
            shopRequest.setStatus("Unprocessed");
            if (cartitem[i][1] instanceof Gun) {
                Gun gun = (Gun) cartitem[i][1];
                shopRequest.setGun(gun);
            } else {
                Bullet bullet = (Bullet) cartitem[i][1];
                shopRequest.setBullet(bullet);
            }
            distributorEnterprise.getWorkQueue().getWorkRequestList().add(shopRequest);
        }
        itemnum = 0;
        popcart();
        JOptionPane.showMessageDialog(null, "Orders have been sent.");

    }//GEN-LAST:event_CheckoutbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Additemtocartbtn;
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton Checkoutbtn;
    private javax.swing.JButton Removeitembtn;
    private javax.swing.JButton addbullettocartbtn;
    private javax.swing.JButton addguntocartbtn;
    private javax.swing.JTable cart;
    private javax.swing.JComboBox combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox combo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTable tbl3;
    private javax.swing.JTextField tottxt;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    // End of variables declaration//GEN-END:variables
}
