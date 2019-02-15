/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovernementRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoh
 */
public class ManageGoverment extends javax.swing.JPanel {

    private Enterprise enterprise;
    private JPanel display;
    private OrganizationDirectory organizationDirectory;

    /**
     * Creates new form ManageGoverment
     */
    public ManageGoverment(JPanel display, Enterprise enterprise, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.enterprise = enterprise;
        this.display = display;
        this.organizationDirectory = organizationDirectory;
        populateCombo();
        populateTable();
        populateOrganizationEmpComboBox();
        popOrganizationComboBox();
        popData();
        
    }

    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.GovernmentEnterprise.getValue())) {
            organizationJComboBox.addItem(Organization.Type.CertificateOrganization);
            organizationJComboBox.addItem(Organization.Type.VerificationOrganization);
            organizationJComboBox.addItem(Organization.Type.GradeOrganization);
//               
        }
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            Object[] row = new Object[3];
            row[0] = organization.getOrganizationID();
            row[1] = organization;
            
            model.addRow(row);
        }
    }

    public void populateOrganizationEmpComboBox() {
        organizationEmpJComboBox.removeAllItems();
        
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            organizationEmpJComboBox.addItem(organization);
        }
    }
    
    private void populateTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) organizationJTable1.getModel();
        
        model.setRowCount(0);
        
        for (Person person : organization.getPersonDirectory().getPersonList()) {
            Object[] row = new Object[2];
            row[0] = person.getId();
            row[1] = person;
            model.addRow(row);
        }
    }

    public void popOrganizationComboBox() {
        organizationJComboBox1.removeAllItems();
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox1.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox1.removeAllItems();
        
        for (Person person : organization.getPersonDirectory().getPersonList()) {
            employeeJComboBox1.addItem(person);
        }
    }
    
    private void populateRoleComboBox(Organization organization) {
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            roleJComboBox.addItem(role);
        }
    }
    
    public void popData() {
        
        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua.getUsername();
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addOrgJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        organizationJTable1 = new javax.swing.JTable();
        CreatePerson = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        employeeJComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        CreateAccount = new javax.swing.JButton();
        organizationJComboBox1 = new javax.swing.JComboBox();
        UsernameJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passwordJTextField = new javax.swing.JPasswordField();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage Organization Working Area", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        organizationJTable.setBackground(new java.awt.Color(0, 204, 204));
        organizationJTable.setForeground(new java.awt.Color(255, 255, 255));
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Organization Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        addOrgJButton.setBackground(new java.awt.Color(51, 51, 255));
        addOrgJButton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        addOrgJButton.setForeground(new java.awt.Color(255, 255, 255));
        addOrgJButton.setText("Add Organization");
        addOrgJButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.white));
        addOrgJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrgJButtonActionPerformed(evt);
            }
        });

        organizationJComboBox.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(102, 102, 255));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.white));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel1.setText("Organization Type: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(addOrgJButton)
                .addGap(0, 103, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOrgJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(522, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Organization", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Employee Working Area", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 153));
        jLabel2.setText("Name");

        nameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameJTextFieldKeyTyped(evt);
            }
        });

        organizationEmpJComboBox.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 153));
        jLabel3.setText("Organization");

        organizationJTable1.setBackground(new java.awt.Color(0, 204, 204));
        organizationJTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        organizationJTable1.setForeground(new java.awt.Color(255, 255, 255));
        organizationJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(organizationJTable1);

        CreatePerson.setBackground(new java.awt.Color(0, 204, 204));
        CreatePerson.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        CreatePerson.setForeground(new java.awt.Color(255, 255, 255));
        CreatePerson.setText("Create Person");
        CreatePerson.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.white));
        CreatePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePersonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(organizationEmpJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(230, 230, 230)
                        .addComponent(CreatePerson)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(CreatePerson))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(436, 436, 436))
        );

        jTabbedPane1.addTab("Manage Employee", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage UserAccount Working Area", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 18))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setText("Person");

        employeeJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setText("Organization");

        CreateAccount.setBackground(new java.awt.Color(0, 204, 204));
        CreateAccount.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        CreateAccount.setText("Create");
        CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountActionPerformed(evt);
            }
        });

        organizationJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setText("Role");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("User Name");

        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });

        userJTable.setBackground(new java.awt.Color(0, 204, 204));
        userJTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.darkGray, java.awt.Color.white));
        userJTable.setForeground(new java.awt.Color(255, 255, 255));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(userJTable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");

        jSeparator1.setBackground(new java.awt.Color(0, 255, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(employeeJComboBox1, 0, 170, Short.MAX_VALUE)
                            .addComponent(roleJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(organizationJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateAccount)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(organizationJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsernameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(employeeJComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(CreateAccount))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage User", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addOrgJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrgJButtonActionPerformed
        
        Type type = (Type) organizationJComboBox.getSelectedItem();
        organizationDirectory.createOrganization(type);
        populateTable();
    }//GEN-LAST:event_addOrgJButtonActionPerformed

    private void CreatePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePersonActionPerformed
        if (nameJTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the Username!");
        } else if (!Character.isUpperCase(nameJTextField.getText().charAt(0)) && !Character.isLowerCase(nameJTextField.getText().charAt(0))) {
            JOptionPane.showMessageDialog(null, "Username should begin with a letter!");
        } else {
            Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
            String name = nameJTextField.getText();
            organization.getPersonDirectory().createPerson(name);
            populateTable(organization);
        }

    }//GEN-LAST:event_CreatePersonActionPerformed

    private void CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountActionPerformed
        Organization organization = (Organization) organizationJComboBox1.getSelectedItem();
        if (UsernameJTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the Username!");
        } else if (!Character.isUpperCase(UsernameJTextField.getText().charAt(0)) && !Character.isLowerCase(UsernameJTextField.getText().charAt(0))) {
            JOptionPane.showMessageDialog(null, "Username should begin with a letter!");
        } else if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(UsernameJTextField.getText())) {
            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList())
                System.out.println(userAccount.getUsername());
            JOptionPane.showMessageDialog(null, "Username has been used!");
        } else {
            
            String userName = UsernameJTextField.getText();
            String password = passwordJTextField.getText();            
            Person person = (Person) employeeJComboBox1.getSelectedItem();
            Role role = (Role) roleJComboBox.getSelectedItem();
            
            organization.getUserAccountDirectory().createUserAccount(userName, password, person, role);
            
            UsernameJTextField.setText("");
            passwordJTextField.setText("");
            popData();
        }
    }//GEN-LAST:event_CreateAccountActionPerformed

    private void organizationJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBox1ActionPerformed
        Organization organization = (Organization) organizationJComboBox1.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBox1ActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        populateOrganizationEmpComboBox();
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        populateTable(organization);
        popData();
        popOrganizationComboBox();
        populateEmployeeComboBox(organization);
        populateRoleComboBox(organization);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        if (organization != null) {
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    private void nameJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameJTextFieldKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameJTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccount;
    private javax.swing.JButton CreatePerson;
    private javax.swing.JTextField UsernameJTextField;
    private javax.swing.JButton addOrgJButton;
    private javax.swing.JComboBox employeeJComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox organizationJComboBox1;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JTable organizationJTable1;
    private javax.swing.JPasswordField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
