package ui;

/**
 *
 * @author zhangle
 */
import init.main;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import util.Label;
import util.PrintImage;
import models.ISle;
import models.InvInfo;
import models.InvUserView;
import models.OSle;
import models.Storage;
import models.User;
import db.HibernateUtil;

public class ViewInvForm extends javax.swing.JFrame {
//  public ViewInvForm(String initid) {
//    initComponents(initid);
//  }

  /**
   * Creates new form AddInvForm
   */
  public ViewInvForm(String initid) {
    initComponents(initid);
    createTimePicker.setFormats("yyyy-MM-dd");
    checkinTimePicker.setFormats("yyyy-MM-dd");
    checkoutTimePicker.setFormats("yyyy-MM-dd");

    initInv = (InvInfo) HibernateUtil.findById(InvInfo.class, initid);
//    initInv = main.client.getInvUserInfo(initid);

//    String sqlStr = "select * from inv.isle order by TRANSFERTIME desc";
//    isleList = HibernateUtil.queryBySql(ISle.class, sqlStr);
//    String[] isles = new String[isleList.size() + 1];
//    isles[0] = "  ";
//    for (int i = 0; i < isleList.size(); i++)
//      isles[i + 1] = isleList.get(i).getISleID();

//    sqlStr = "select * from inv.storage";
//    storageList = HibernateUtil.queryBySql(Storage.class, sqlStr);
//    String[] storages = new String[storageList.size() + 1];
//    storages[0] = "  ";
//    for (int i = 0; i < storageList.size(); i++)
//      storages[i + 1] = storageList.get(i).getStorageTag();
    storageList = main.client.getStorageInfo();
    for (Storage storage : storageList) {
      lockerMap.put(storage.getStorageID(),storage.getStorageTag());
    }
    storageIDComboBox.setModel(new DefaultComboBoxModel(lockerMap.values().toArray()));
    
    storageIDComboBox.setSelectedItem(lockerMap.get(initInv.getStorageID()));

//    sqlStr = "select * from inv.osle order by PACKTIME desc";
//    osleList = HibernateUtil.queryBySql(OSle.class, sqlStr);
//    String[] osles = new String[osleList.size() + 1];
//    osles[0] = "  ";
//    for (int i = 0; i < osleList.size(); i++)
//      osles[i + 1] = osleList.get(i).getOSleID();

    String sqlStr = "select * from inv.user";
    userlist = HibernateUtil.queryBySql(User.class, sqlStr);
    String[] users = new String[userlist.size() + 1];
    users[0] = "  ";
    for (int i = 0; i < userlist.size(); i++)
      users[i + 1] = userlist.get(i).getName();

    proStatusComboBox.setModel(new DefaultComboBoxModel(new String[] { "active", "dormant" }));
    checkinEngComboBox.setModel(new DefaultComboBoxModel(users));
//    isleIDComboBox.setModel(new DefaultComboBoxModel(isles));
    isleIDComboBox.setText(initInv.getISleID());
//    osleIDComboBox.setModel(new DefaultComboBoxModel(osles));
    securityStatusComboBox.setModel(new DefaultComboBoxModel(new String[] { "non-prototype", "prototype" }));
//    managerComboBox.setModel(new DefaultComboBoxModel(users));
    
    verificationStatusComboBox.setModel(new DefaultComboBoxModel(new String[] { "verified", "unverified", "shipped", "flagged" }));
    checkoutComboBox.setModel(new DefaultComboBoxModel(users));
//    storageIDComboBox.setModel(new DefaultComboBoxModel(storages));
    createEngComboBox.setModel(new DefaultComboBoxModel(users));
    storageStatusComboBox.setModel(new DefaultComboBoxModel(new String[] { "checked in", "checked out" }));

    invIDText.setText(initInv.getInvID());
    invIDText.setEnabled(false);
    projectNoText.setText(initInv.getProjectNum());
    projectNoText.setEnabled(false);
    clientProNoText.setText(initInv.getClientProductNum());
    clientProNoText.setEnabled(false);
    String userName  = initInv.getCreatEngID();
    User theUser = (User) HibernateUtil.findById(User.class, initInv.getCreatEngID());
//    createEngComboBox.setSelectedItem(((User) HibernateUtil.findById(User.class, initInv.getCreatEngID())).getName());
    createEngComboBox.setSelectedItem(theUser.getName());
    createEngComboBox.setEnabled(false);
    createTimePicker.setDate(initInv.getCreatTime());
    createTimePicker.setEnabled(false);
    isleIDComboBox.setText(initInv.getISleID());

    isleIDComboBox.setEnabled(false);
//    managerComboBox.setSelectedItem(((User) HibernateUtil.findById(User.class, initInv.getProjectManageID())).getName());
//    managerComboBox.setEnabled(false);
    managerComboBox.setText(initInv.getProjectManageID());
    radarText.setText(initInv.getRADAR());
    vendorText.setText(initInv.getVendor());
    sysSNText.setText(initInv.getSystemSN());
    configNoText.setText(initInv.getConfigNum());

    descriptionTextArea.setText(initInv.getDescription());
    proStatusComboBox.setSelectedItem(initInv.getProjectStatus());
    securityStatusComboBox.setSelectedItem(initInv.getSecurityStatus());
    verificationStatusComboBox.setSelectedItem(initInv.getVerificationStatus());
    osleIDComboBox.setText(initInv.getOSleID());

    if (initInv.getStorageStatus().equals("checked in")) {
      storageStatusComboBox.setSelectedItem("checked in");
      checkinTimePicker.setDate(initInv.getCheckInTime());
      String checkInUser = initInv.getCheckInEngID();
      checkinEngComboBox.setSelectedItem(((User) HibernateUtil.findById(User.class, initInv.getCheckInEngID())).getName());
      storageIDComboBox.setSelectedItem(lockerMap.get(initInv.getStorageID()));
    } else {
      storageStatusComboBox.setSelectedItem("checked out");
      checkoutTimePicker.setDate(initInv.getCheckOutTime());
      checkoutComboBox.setSelectedItem(((User) HibernateUtil.findById(User.class, initInv.getCheckOutEngID())).getName());
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents(String initid) {

    jPanel1 = new javax.swing.JPanel();
    saveBtn = new javax.swing.JButton();
    printBtn = new javax.swing.JButton();
    cancelBtn = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    invIDText = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    projectNoText = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    clientProNoText = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    sysSNText = new javax.swing.JTextField();
    radarText = new javax.swing.JTextField();
    vendorText = new javax.swing.JTextField();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    configNoText = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jLabel20 = new javax.swing.JLabel();
    jLabel21 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    descriptionTextArea = new javax.swing.JTextArea();
    createTimePicker = new org.jdesktop.swingx.JXDatePicker();
    checkinTimePicker = new org.jdesktop.swingx.JXDatePicker();
    checkoutTimePicker = new org.jdesktop.swingx.JXDatePicker();
    isleIDComboBox = new javax.swing.JTextField();
    osleIDComboBox = new javax.swing.JTextField();
    proStatusComboBox = new javax.swing.JComboBox();
    storageStatusComboBox = new javax.swing.JComboBox();
    managerComboBox = new javax.swing.JTextField();
    checkinEngComboBox = new javax.swing.JComboBox();
    securityStatusComboBox = new javax.swing.JComboBox();
    verificationStatusComboBox = new javax.swing.JComboBox();
    createEngComboBox = new javax.swing.JComboBox();
    checkoutComboBox = new javax.swing.JComboBox();
    storageIDComboBox = new javax.swing.JComboBox();

    jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

    saveBtn.setText("Save");
    saveBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveBtnActionPerformed(evt);
      }
    });

    printBtn.setText("Print Bar");
    printBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        printBtnActionPerformed(evt);
      }
    });

    cancelBtn.setText("Cancel");
    cancelBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        jPanel1Layout.createSequentialGroup().addGap(70, 70, 70).addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(144, 144, 144).addComponent(printBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(140, 140, 140)
            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(87, 87, 87)));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        jPanel1Layout.createSequentialGroup().addContainerGap(11, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(saveBtn).addComponent(printBtn).addComponent(cancelBtn)).addContainerGap()));

    jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    jLabel1.setText("Inventory ID");

    jLabel2.setText("Project Number");

    projectNoText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        projectNoTextActionPerformed(evt);
      }
    });

    jLabel4.setText("Client's Product SN");

    jLabel5.setText("Create Time");

    jLabel6.setText("Checkin Time");

    jLabel7.setText("Checkout Time");

    jLabel8.setText("Locker");

    jLabel9.setText("ISle ID");

    jLabel10.setText("OSle ID");

    jLabel11.setText("RADAR");

    jLabel12.setText("System SN");

    radarText.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radarTextActionPerformed(evt);
      }
    });

    jLabel13.setText("Configure No");

    jLabel14.setText("Vendor");

    jLabel15.setText("Security Status");

    jLabel16.setText("Project Status");

    jLabel17.setText("Create Engineer");

    jLabel18.setText("Project Manager");

    jLabel19.setText("Checkin Engineer");

    jLabel20.setText("Checkout Engineer");

    jLabel21.setText("Storage Status");

    jLabel22.setText("Verification Status");

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));

    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(5);
    jScrollPane1.setViewportView(descriptionTextArea);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
        .addGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE).addContainerGap())));
    jPanel4Layout.setVerticalGroup(jPanel4Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 92, Short.MAX_VALUE)
        .addGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel4Layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE).addContainerGap())));

    createTimePicker.setPreferredSize(new java.awt.Dimension(160, 28));

    checkinTimePicker.setPreferredSize(new java.awt.Dimension(160, 28));

    checkoutTimePicker.setPreferredSize(new java.awt.Dimension(160, 28));

    storageIDComboBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        storageIDComboBoxActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        javax.swing.GroupLayout.Alignment.TRAILING,
        jPanel3Layout
            .createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(
                jPanel3Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(
                        jPanel3Layout
                            .createSequentialGroup()
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel8)
                                    .addComponent(jLabel9).addComponent(jLabel11).addComponent(jLabel13).addComponent(jLabel16).addComponent(jLabel21).addComponent(jLabel18).addComponent(jLabel19))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(invIDText).addComponent(clientProNoText)
                                    .addComponent(createTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(storageIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(isleIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(radarText).addComponent(configNoText)
                                    .addComponent(proStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(storageStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(managerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkinEngComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(34, 34, 34)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7).addComponent(jLabel10)
                                    .addComponent(jLabel12).addComponent(jLabel14).addComponent(jLabel15).addComponent(jLabel22).addComponent(jLabel17).addComponent(jLabel20))
                            .addGap(21, 21, 21)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(projectNoText, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(checkinTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkoutTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(osleIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(sysSNText).addComponent(vendorText)
                                    .addComponent(securityStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(verificationStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createEngComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkoutComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addGap(11, 11, 11)));
    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        jPanel3Layout
            .createSequentialGroup()
            .addGap(13, 13, 13)
            .addGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                    .addComponent(invIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)
                    .addComponent(projectNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
                jPanel3Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        jPanel3Layout
                            .createSequentialGroup()
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
                                    .addComponent(clientProNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
                                    .addComponent(createTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8)
                                    .addComponent(storageIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
                                    .addComponent(isleIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel11)
                                    .addComponent(radarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel13)
                                    .addComponent(configNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel16)
                                    .addComponent(proStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel21)
                                    .addComponent(storageStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel18)
                                    .addComponent(managerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(
                        jPanel3Layout
                            .createSequentialGroup()
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
                                    .addComponent(checkinTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
                                    .addComponent(checkoutTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10)
                                    .addComponent(osleIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel12)
                                    .addComponent(sysSNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(vendorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel15)
                                    .addComponent(securityStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel22)
                                    .addComponent(verificationStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel17)
                                    .addComponent(createEngComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel20)
                                    .addComponent(checkoutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel19)
                    .addComponent(checkinEngComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap()));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
        jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        javax.swing.GroupLayout.Alignment.TRAILING,
        layout.createSequentialGroup().addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

    pack();
  }// </editor-fold>

  private void projectNoTextActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void radarTextActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here://GEN-FIRST:event_saveBtnActionPerformed

    InvInfo inv = (InvInfo) HibernateUtil.findById(InvInfo.class, initInv.getInvID());
    if(osleIDComboBox.getText() != null)
      inv.setOSleID(osleIDComboBox.getText().toString());
    inv.setDescription(descriptionTextArea.getText());
    inv.setProjectStatus(proStatusComboBox.getSelectedItem().toString());
    inv.setSecurityStatus(securityStatusComboBox.getSelectedItem().toString());
    inv.setVerificationStatus(verificationStatusComboBox.getSelectedItem().toString());
    inv.setProjectManageID(managerComboBox.getText());
    inv.setStorageStatus(storageStatusComboBox.getSelectedItem().toString());
    inv.setRADAR(radarText.getText());
    inv.setSystemSN(sysSNText.getText());
    inv.setVendor(vendorText.getText());
    inv.setConfigNum(configNoText.getText());
    if (storageStatusComboBox.getSelectedItem().toString() == "checked in") {
      if (checkinEngComboBox.getSelectedIndex() > 0)
        inv.setCheckInEngID(userlist.get(checkinEngComboBox.getSelectedIndex() - 1).getUserID());
      else {
        JOptionPane.showMessageDialog(ViewInvForm.this, "Please select the \"Checkin Engineer\" before saving this item", "error", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      inv.setCheckInTime(checkinTimePicker.getDate());
      if ((storageIDComboBox.getSelectedItem() == null)) {
        JOptionPane.showMessageDialog(ViewInvForm.this, "Please select the \"locker\" before saving this item", "error", JOptionPane.INFORMATION_MESSAGE);
        return;
      } else{
        for (Object storageID : lockerMap.keySet()) {
          if (lockerMap.get(storageID).equals(storageIDComboBox.getSelectedItem()) ){
            System.err.println(storageID);
            inv.setStorageID(storageID.toString());
            break;
          }
        }
      }
    } else {
      if (checkoutComboBox.getSelectedIndex() > 0)
        inv.setCheckOutEngID(userlist.get(checkoutComboBox.getSelectedIndex() - 1).getUserID());
      else {
        JOptionPane.showMessageDialog(ViewInvForm.this, "Please select the \"Checkout Engineer\" before saving this item", "error", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      inv.setCheckOutTime(checkoutTimePicker.getDate());
    }

    HibernateUtil.update(inv);
    MainForm.gridTable.setModel(init.main.client.getInvInfoTM(0));
    JOptionPane.showMessageDialog(ViewInvForm.this, "The information of the item " + invIDText.getText()+" is updated successfully!", "OK", JOptionPane.INFORMATION_MESSAGE);

  }

  private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    // GEN-FIRST:event_cancelBtnActionPerformed
    this.dispose();

  }

  private void storageIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    // GEN-FIRST:event_printBtnActionPerformed
    String invid = invIDText.getText().toString();

//    if (managerComboBox.getSelectedIndex() == 0) {
//      JOptionPane.showMessageDialog(ViewInvForm.this, "please select project manager", "error", JOptionPane.INFORMATION_MESSAGE);
//      return;
//    }
//    byte[] imageByte = Label.creatLabel(invid.substring(0, 12), invid, "Inventory", projectNoText.getText());
    byte[] imageByte = Label.creatInvLabel(invid.substring(0, 12), invid, "Inventory", "ProNo. "+projectNoText.getText(),"SN: "+clientProNoText.getText());
    Icon icon = new ImageIcon(imageByte);
    Object[] options = { "Yes", "No" };
    int response = JOptionPane.showOptionDialog(ViewInvForm.this, "Are you sure you want to print the tag?", "Warning", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options[0]);
    if (response == 1) {
      return;
    }if (response == 0) {
      File printFile = Label.generateFinalImage("barcode-last.png",imageByte);
      if (printFile == null)
        return;
      PrintImage pi = new PrintImage();
      pi.print("barcode-last.png", 1);
    }
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed"
    // desc=" Look and feel setting code (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ViewInvForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ViewInvForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ViewInvForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ViewInvForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
//        new ViewInvForm().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify
  private javax.swing.JButton cancelBtn;
  private javax.swing.JComboBox checkinEngComboBox;
  private org.jdesktop.swingx.JXDatePicker checkinTimePicker;
  private javax.swing.JComboBox checkoutComboBox;
  private org.jdesktop.swingx.JXDatePicker checkoutTimePicker;
  private javax.swing.JTextField clientProNoText;
  private javax.swing.JTextField configNoText;
  private javax.swing.JComboBox createEngComboBox;
  private org.jdesktop.swingx.JXDatePicker createTimePicker;
  private javax.swing.JTextArea descriptionTextArea;
  private javax.swing.JTextField invIDText;
  private javax.swing.JTextField isleIDComboBox;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField managerComboBox;
  private javax.swing.JTextField osleIDComboBox;
  private javax.swing.JButton printBtn;
  private javax.swing.JComboBox proStatusComboBox;
  private javax.swing.JTextField projectNoText;
  private javax.swing.JTextField radarText;
  private javax.swing.JButton saveBtn;
  private javax.swing.JComboBox securityStatusComboBox;
  private javax.swing.JComboBox storageIDComboBox;
  private javax.swing.JComboBox storageStatusComboBox;
  private javax.swing.JTextField sysSNText;
  private javax.swing.JTextField vendorText;
  private javax.swing.JComboBox verificationStatusComboBox;
  // End of variables declaration
  private models.InvInfo initInv;
  private List<ISle> isleList;
  private List<User> userlist;
  private List<OSle> osleList;
  private List<Storage> storageList;
  private Map lockerMap = new HashMap();
}
