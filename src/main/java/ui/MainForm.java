/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import init.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTable;

import au.com.bytecode.opencsv.CSVWriter;
import util.CsvFileUtil;
import ui.AddISleForm;
import ui.AddInvForm;
import ui.AddOSleForm;
import ui.AddStorageForm;
import ui.AddUserForm;
import ui.ChangPwdForm;
import ui.ViewISleForm;
import ui.ViewInvForm;
import ui.ViewOSleForm;
import ui.ViewStorageForm;
import ui.ViewUserForm;
import ui.model.TableModel;
import util.ArrayListOper;

/**
 *
 * @author zhangle
 */
public class MainForm extends javax.swing.JFrame {

  /**
   * Creates new form MainForm1
   */
  public MainForm() {
    initComponents();
    subMenue.add(initialPanel, BorderLayout.CENTER);
    subMenue.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION);
    String sparator = File.separator;
    gridPanel.setVisible(false);
    System.out.println(System.getProperty("user.dir")+ sparator + "img" + sparator + "ship.png");
    isleButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator + "ship.png"));
    osleButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "shipout.png"));
    invButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "inventory.png"));
    invCheckButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "invCheck.png"));
    LockerButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "locker.png"));
    accountButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "person.png"));
    logoutButton.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + sparator + "img" + sparator +  "logout.png"));
//    isleButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "ship.png").getPath()));
//    osleButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "shipout.png")));
//    invButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "inventory.png")));
//    invCheckButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "invCheck.png")));
//    LockerButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "locker.png")));
//    accountButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "person.png")));
//    logoutButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getResource(".." + sparator + "img" + sparator + "logout.png")));
//    isleButton.setIcon(new javax.swing.ImageIcon(Thread.currentThread().getContextClassLoader().getResource("").getPath()+sparator+"ship.png"));
//    osleButton.setIcon(new javax.swing.ImageIcon(Thread.currentThread().getContextClassLoader().getResource("").getPath()+sparator+"shipout.png"));
//    invButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getClassLoader().getResource("inventory.png")));
//    LockerButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getClassLoader().getResource("locker.png")));
//    accountButton.setIcon(new javax.swing.ImageIcon(MainForm.class.getClassLoader().getResource("person.png")));
    LockerQueryBtn.setVisible(false);
    // gridTable.setRowSelectionAllowed(true);
    // gridTable.setRowSelectionInterval(0, 0);
    queryEditor.setText("Search ...");
    invQueryEditor.setText("Search ...");
    osleQueryEditor.setText("Search ...");
    LockerQueryEditor.setText("Search ...");

    queryEditor.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void removeUpdate(DocumentEvent e) {
        restoreGridTable();
        handleEditor(queryEditor.getText());
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        handleEditor(queryEditor.getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        handleEditor(queryEditor.getText());
      }

    });
    invQueryEditor.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        handleEditor(invQueryEditor.getText());
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        restoreGridTable();

        handleEditor(invQueryEditor.getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        handleEditor(invQueryEditor.getText());
      }
    });

    osleQueryEditor.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void removeUpdate(DocumentEvent e) {
        restoreGridTable();
        handleEditor(osleQueryEditor.getText());
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        handleEditor(osleQueryEditor.getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        handleEditor(osleQueryEditor.getText());
      }

    });
    LockerQueryEditor.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void removeUpdate(DocumentEvent e) {
        restoreGridTable();
        handleEditor(LockerQueryEditor.getText());
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        handleEditor(LockerQueryEditor.getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        handleEditor(LockerQueryEditor.getText());
      }

    });
    isleQueryBtn.setVisible(false);
    osleQueryBtn.setVisible(true);
    LockerQueryBtn.setVisible(false);
    delUserBtn.setVisible(false);
    
    invAddBtn.setVisible(false);
    invVmBtn.setVisible(false);
    verifyInBtn.setVisible(false);
    verifyOutBtn.setVisible(false);
    userAddBtn.setVisible(false);
    userVMBtn.setVisible(false);
    reportBtn.setVisible(false);
    alarmBtn.setVisible(false);
    CheckInBtn.setVisible(false);
    checkOutBtn.setVisible(false);
    
    invQueryEditor.setVisible(false);
    userLevelSetBtn();

  }

  private void userLevelSetBtn(){
    switch (main.client.getUserLevel()) {
    case 0:
      //AA
      invCheckButton.setVisible(false);
      break;
    case 1:
      //ENG
      invAddBtn.setVisible(true);
      invVmBtn.setVisible(true);
      verifyOutBtn.setVisible(true);
      reportBtn.setVisible(true);
      invQueryEditor.setVisible(true);
      CheckInBtn.setVisible(true);
      checkOutBtn.setVisible(true);
      break;
    case 2:
      //IC
      invAddBtn.setVisible(true);
      invVmBtn.setVisible(true);
      verifyOutBtn.setVisible(true);
      reportBtn.setVisible(true);
      invQueryEditor.setVisible(true);
      verifyInBtn.setVisible(true);
      CheckInBtn.setVisible(true);
      checkOutBtn.setVisible(true);
      break;
    case 3:
      //MA
      invAddBtn.setVisible(true);
      invVmBtn.setVisible(true);
      verifyOutBtn.setVisible(true);
      reportBtn.setVisible(true);
      invQueryEditor.setVisible(true);
      verifyInBtn.setVisible(true);
      userAddBtn.setVisible(true);
      userVMBtn.setVisible(true);
      alarmBtn.setVisible(true);
      CheckInBtn.setVisible(true);
      checkOutBtn.setVisible(true);
      break;
    default:
      break;
    }
  }
  
  private void restoreGridTable() {
    if (isleButton.isSelected()) {
      gridTable.setModel(main.client.getISleUserInfoTM(0));
    } else if (osleButton.isSelected()) {
      gridTable.setModel(main.client.getOSleUserInfoTM(0));
    } else if (invButton.isSelected()) {
      gridTable.setModel(main.client.getInvInfoTM(0));
    } else if (LockerButton.isSelected()) {
      gridTable.setModel(main.client.getStorageTM(0));
    } else if (accountButton.isSelected()) {
      gridTable.setModel(main.client.getUserInfoTM(0));
    }

  }

  void handleEditor(String inputStr) {
    TableModel backupModel = (TableModel) gridTable.getModel();
    int columns = backupModel.getColumnCount();
    TableModel tm = null;
    if (inputStr.trim().equals("")) {
      restoreGridTable();
    } else {
      Object[][] objArray = ArrayListOper.filter(backupModel.getData(), inputStr.trim(), columns);
      tm = new TableModel(objArray, ((TableModel) gridTable.getModel()).getColumns());
      gridTable.setModel(tm);
      gridTable.updateUI();
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">
  private void initComponents() {

    invBtnGroup = new javax.swing.JPanel();
    invAddBtn = new javax.swing.JButton();
    invAddBatchBtn = new javax.swing.JButton();
    invVmBtn = new javax.swing.JButton();
    invQueryBtn = new javax.swing.JButton();
    verifyInBtn = new javax.swing.JButton();
    verifyOutBtn = new javax.swing.JButton();
    reportBtn = new javax.swing.JButton();
    alarmBtn = new javax.swing.JButton();
    CheckInBtn = new javax.swing.JButton();
    checkOutBtn = new javax.swing.JButton();
    isleBtnGroup = new javax.swing.JPanel();
    isleAddBtn = new javax.swing.JButton();
    isleVmBtn = new javax.swing.JButton();
    isleQueryBtn = new javax.swing.JButton();
    osleBtnGroup = new javax.swing.JPanel();
    osleAddBtn = new javax.swing.JButton();
    osleVmBtn = new javax.swing.JButton();
    osleQueryBtn = new javax.swing.JButton();
    LockerBtnGroup = new javax.swing.JPanel();
    LockerAddBtn = new javax.swing.JButton();
    LockerVmBtn = new javax.swing.JButton();
    LockerQueryBtn = new javax.swing.JButton();
    accountBtnGroup = new javax.swing.JPanel();
    changPwdBtn = new javax.swing.JButton();
    userAddBtn = new javax.swing.JButton();
    delUserBtn = new javax.swing.JButton();
    userVMBtn = new javax.swing.JButton();
    logoutBtn = new javax.swing.JButton();
    initialPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    buttonGroup1 = new javax.swing.ButtonGroup();
    headerPanel = new javax.swing.JPanel();
    jToolBar1 = new javax.swing.JToolBar();
    isleButton = new javax.swing.JToggleButton();
    jSeparator1 = new javax.swing.JToolBar.Separator();
    osleButton = new javax.swing.JToggleButton();
    jSeparator2 = new javax.swing.JToolBar.Separator();
    invButton = new javax.swing.JToggleButton();
    invCheckButton = new javax.swing.JToggleButton();
    jSeparator3 = new javax.swing.JToolBar.Separator();
    jSeparator6 = new javax.swing.JToolBar.Separator();
    LockerButton = new javax.swing.JToggleButton();
    jSeparator4 = new javax.swing.JToolBar.Separator();
    accountButton = new javax.swing.JToggleButton();
    logoutButton = new javax.swing.JToggleButton();
    jSeparator5 = new javax.swing.JToolBar.Separator();
    jSeparator7 = new javax.swing.JToolBar.Separator();
    menuPanel = new javax.swing.JPanel();
    subMenue = new org.jdesktop.swingx.JXCollapsiblePane();
    bottomPanel = new javax.swing.JPanel();
    gridPanel = new javax.swing.JScrollPane();
    gridTable = new org.jdesktop.swingx.JXTable();
    queryEditor = new javax.swing.JTextField();
    invQueryEditor = new javax.swing.JTextField();
    osleQueryEditor = new javax.swing.JTextField();
    LockerQueryEditor = new javax.swing.JTextField();

    gridTable.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          JXTable target = (JXTable) e.getSource();
          int row = target.getSelectedRow();
          String id = gridTable.getModel().getValueAt(row, 0).toString();
          switch (gridType) {
          case 1:
            ViewISleForm isleif = new ViewISleForm(id);
            popUpWindow(isleif);
            break;
          case 2:
            ViewOSleForm osleif = new ViewOSleForm(id);
            popUpWindow(osleif);
            break;
          case 3:
            if (main.client.getUserLevel() != 0 ){
               ViewInvForm invif = new ViewInvForm(id);
               popUpWindow(invif);
            }
            break;
          case 4:
            if (main.client.getUserLevel() != 0 ){
              ViewStorageForm sif = new ViewStorageForm(id);
              popUpWindow(sif);
            }
            break;
          case 5:
            if (main.client.getUserLevel() == 3 ){
              ViewUserForm uif = new ViewUserForm(id);
              popUpWindow(uif);
            }
            break;
          default:
            break;
          }
        }
      }
    });

    invBtnGroup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    invAddBtn.setText("Add");
    invAddBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        invAddBtnActionPerformed(evt);
      }
    });
    
    invAddBatchBtn.setText("Add Multi-inventories");
    invAddBatchBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        invAddBatchBtnActionPerformed(evt);
      }

    });

    invVmBtn.setText("View & Modify");
    invVmBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        invVmBtnActionPerformed(evt);
      }
    });

    invQueryBtn.setText("Advanced Search");
    invQueryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        invQueryBtnActionPerformed(evt);
      }
    });

    verifyInBtn.setText("Verify In Items");
    verifyInBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        verifyInBtnActionPerformed(evt);
      }
    });

    verifyOutBtn.setText("Verify Out Items");
    verifyOutBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        verifyOutBtnActionPerformed(evt);
      }
    });

    reportBtn.setText("Report");
    reportBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        reportBtnActionPerformed(evt);
      }
    });

    alarmBtn.setText("Start Email Hints");
    alarmBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        alarmBtnActionPerformed(evt);
      }
    });
    CheckInBtn.setText("Check In");
    CheckInBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        CheckInBtnActionPerformed(evt);
      }
    });
    checkOutBtn.setText("Check Out");
    checkOutBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkOutBtnActionPerformed(evt);
      }
    });

//    javax.swing.GroupLayout invBtnGroupLayout = new javax.swing.GroupLayout(invBtnGroup);
//    invBtnGroup.setLayout(invBtnGroupLayout);
//    invBtnGroupLayout.setHorizontalGroup(invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//        invBtnGroupLayout.createSequentialGroup().addContainerGap().addComponent(invAddBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(invVmBtn)
//            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(invQueryBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//            .addComponent(verifyInBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(verifyOutBtn)
//            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(reportBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(alarmBtn)
//            // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
//            // javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(invQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
//            .addContainerGap()));
//    invBtnGroupLayout.setVerticalGroup(invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//        invBtnGroupLayout
//            .createSequentialGroup()
//            .addContainerGap()
//            .addGroup(
//                invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(invQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(invAddBtn)
//                    .addComponent(invVmBtn).addComponent(invQueryBtn).addComponent(verifyInBtn).addComponent(verifyOutBtn).addComponent(reportBtn).addComponent(alarmBtn))
//            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    javax.swing.GroupLayout invBtnGroupLayout = new javax.swing.GroupLayout(invBtnGroup);
    invBtnGroup.setLayout(invBtnGroupLayout);
    invBtnGroupLayout.setHorizontalGroup(
        invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(invBtnGroupLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(invAddBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(invAddBatchBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(invVmBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(invQueryBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(verifyInBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(verifyOutBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(reportBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(alarmBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(CheckInBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(checkOutBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(invQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    invBtnGroupLayout.setVerticalGroup(
        invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(invBtnGroupLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(invBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(invQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(invAddBtn)
                .addComponent(invAddBatchBtn)
                .addComponent(invVmBtn)
                .addComponent(invQueryBtn)
                .addComponent(verifyInBtn)
                .addComponent(verifyOutBtn)
                .addComponent(reportBtn)
                .addComponent(alarmBtn)
                .addComponent(CheckInBtn)
                .addComponent(checkOutBtn))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    isleBtnGroup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    isleAddBtn.setText("Add");
    isleAddBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        isleAddBtnActionPerformed(evt);
      }
    });

    isleVmBtn.setText("View & Modify");
    isleVmBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        isleVmBtnActionPerformed(evt);
      }
    });

    isleQueryBtn.setText("Query");
    isleQueryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        isleQueryBtnActionPerformed(evt);
      }
    });
    queryEditor.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        queryEditorMouseEntered(evt);
      }
    });
    invQueryEditor.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        invQueryEditorMouseEntered(evt);
      }
    });
    osleQueryEditor.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        osleQueryEditorMouseEntered(evt);
      }
    });
    LockerQueryEditor.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        LockerQueryEditorMouseEntered(evt);
      }
    });
    javax.swing.GroupLayout isleBtnGroupLayout = new javax.swing.GroupLayout(isleBtnGroup);
    isleBtnGroup.setLayout(isleBtnGroupLayout);
    isleBtnGroupLayout.setHorizontalGroup(isleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        isleBtnGroupLayout.createSequentialGroup().addContainerGap().addComponent(isleAddBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(isleVmBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(isleQueryBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(queryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(253, Short.MAX_VALUE)));
    isleBtnGroupLayout.setVerticalGroup(isleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        isleBtnGroupLayout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
                isleBtnGroupLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isleAddBtn)
                    .addComponent(isleVmBtn)
                    .addGroup(
                        isleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(isleQueryBtn)
                            .addComponent(queryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    osleBtnGroup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    osleAddBtn.setText("Add");
    osleAddBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        osleAddBtnActionPerformed(evt);
      }
    });

    osleVmBtn.setText("View & Modify");
    osleVmBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        osleVmBtnActionPerformed(evt);
      }
    });

    osleQueryBtn.setText("Batch Shipping Out");
    osleQueryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        osleQueryBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout osleBtnGroupLayout = new javax.swing.GroupLayout(osleBtnGroup);
    osleBtnGroup.setLayout(osleBtnGroupLayout);
    osleBtnGroupLayout
        .setHorizontalGroup(osleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            osleBtnGroupLayout.createSequentialGroup().addContainerGap().addComponent(osleAddBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(osleVmBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(osleQueryBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(osleQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    osleBtnGroupLayout.setVerticalGroup(osleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        osleBtnGroupLayout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
                osleBtnGroupLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(osleAddBtn)
                    .addComponent(osleVmBtn)
                    .addGroup(
                        osleBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(osleQueryBtn)
                            .addComponent(osleQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    LockerBtnGroup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    LockerAddBtn.setText("Add");
    LockerAddBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LockerAddBtnActionPerformed(evt);
      }
    });

    LockerVmBtn.setText("View & Modify");
    LockerVmBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LockerVmBtnActionPerformed(evt);
      }
    });

    LockerQueryBtn.setText("Query");
    LockerQueryBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LockerQueryBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout LockerBtnGroupLayout = new javax.swing.GroupLayout(LockerBtnGroup);
    LockerBtnGroup.setLayout(LockerBtnGroupLayout);
    LockerBtnGroupLayout.setHorizontalGroup(LockerBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        LockerBtnGroupLayout.createSequentialGroup().addContainerGap().addComponent(LockerAddBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(LockerVmBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(LockerQueryBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(LockerQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(253, Short.MAX_VALUE)));
    LockerBtnGroupLayout.setVerticalGroup(LockerBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        LockerBtnGroupLayout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
                LockerBtnGroupLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LockerAddBtn)
                    .addComponent(LockerVmBtn)
                    .addGroup(
                        LockerBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(LockerQueryBtn)
                            .addComponent(LockerQueryEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    accountBtnGroup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    changPwdBtn.setText("Change Password");
    changPwdBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changPwdBtnActionPerformed(evt);
      }
    });

    userAddBtn.setText("Add User");
    userAddBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userAddBtnActionPerformed(evt);
      }
    });

    delUserBtn.setText("Delete User");
    delUserBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        delUserBtnActionPerformed(evt);
      }
    });

    userVMBtn.setText("View & Modify");
    userVMBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        userVMBtnActionPerformed(evt);
      }
    });
    logoutBtn.setText("Logout");
    logoutBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        logoutBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout accountBtnGroupLayout = new javax.swing.GroupLayout(accountBtnGroup);
    accountBtnGroup.setLayout(accountBtnGroupLayout);
//    accountBtnGroupLayout.setHorizontalGroup(accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//        accountBtnGroupLayout.createSequentialGroup().addContainerGap().addComponent(changPwdBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(userAddBtn)
//            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(delUserBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(userVMBtn)
//            .addContainerGap(315, Short.MAX_VALUE)));
//    accountBtnGroupLayout.setVerticalGroup(accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//        accountBtnGroupLayout
//            .createSequentialGroup()
//            .addContainerGap()
//            .addGroup(
//                accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(changPwdBtn).addComponent(userAddBtn).addComponent(delUserBtn)
//                    .addComponent(userVMBtn)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    accountBtnGroupLayout.setHorizontalGroup(
        accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accountBtnGroupLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(changPwdBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(userAddBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(delUserBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(userVMBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(logoutBtn)
            .addContainerGap(221, Short.MAX_VALUE))
    );
    accountBtnGroupLayout.setVerticalGroup(
        accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accountBtnGroupLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(changPwdBtn)
                .addComponent(userAddBtn)
                .addComponent(delUserBtn)
                .addGroup(accountBtnGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userVMBtn)
                    .addComponent(logoutBtn)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    initialPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    jLabel1.setBackground(new java.awt.Color(204, 204, 255));
    jLabel1.setForeground(new java.awt.Color(0, 0, 153));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("WELCOME TO PROTOTYPE INVENTORY MANAGEMENT SYSTEM");

    javax.swing.GroupLayout initialPanelLayout = new javax.swing.GroupLayout(initialPanel);
    initialPanel.setLayout(initialPanelLayout);
    initialPanelLayout.setHorizontalGroup(initialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 769,
        Short.MAX_VALUE));
    initialPanelLayout.setVerticalGroup(initialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
        initialPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    headerPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
        javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

    jToolBar1.setRollover(true);

    buttonGroup1.add(isleButton);
    isleButton.setText("<html>Shipping<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;In</html>");
    isleButton.setFocusable(false);
    isleButton.setMaximumSize(new java.awt.Dimension(84, 60));
    isleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    isleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    isleButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        isleButtonActionPerformed(evt);
      }
    });
    jToolBar1.add(isleButton);
    jToolBar1.add(jSeparator1);

    buttonGroup1.add(osleButton);
    osleButton.setText("<html>Shipping<br>&nbsp;&nbsp;&nbsp;&nbsp;Out</html>");
    osleButton.setFocusable(false);
    osleButton.setMaximumSize(new java.awt.Dimension(84, 60));
    osleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    osleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    osleButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        osleButtonActionPerformed(evt);
      }
    });
    jToolBar1.add(osleButton);
    jToolBar1.add(jSeparator2);

    buttonGroup1.add(invButton);
    invButton.setText("<html>Inventory<br>&nbsp;Creation</html>");
    invButton.setFocusable(false);
    invButton.setMaximumSize(new java.awt.Dimension(84, 60));
    invButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    invButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    invButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        invButtonActionPerformed(evt);
      }
    });
    jToolBar1.add(invButton);
    jToolBar1.add(jSeparator3);

    buttonGroup1.add(invCheckButton);
    invCheckButton.setText("<html>&nbsp;&nbsp;Inventory<br>Management</html>");
    invCheckButton.setFocusable(false);
    invCheckButton.setMaximumSize(new java.awt.Dimension(84, 60));
    invCheckButton.setSize(new java.awt.Dimension(40, 0));
    invCheckButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    invCheckButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    invCheckButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            invCheckButtonActionPerformed(evt);
        }
    });
    jToolBar1.add(invCheckButton);
    jToolBar1.add(jSeparator6);

    
    
    
    buttonGroup1.add(LockerButton);
    LockerButton.setText("Locker");
    LockerButton.setFocusable(false);
    LockerButton.setMaximumSize(new java.awt.Dimension(84, 60));
    LockerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    LockerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    LockerButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LockerButtonActionPerformed(evt);
      }
    });
    jToolBar1.add(LockerButton);
    jToolBar1.add(jSeparator4);

    buttonGroup1.add(accountButton);
    accountButton.setText("  Account  ");
    accountButton.setFocusable(false);
    accountButton.setMaximumSize(new java.awt.Dimension(84, 60)); 
    accountButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    accountButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    accountButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        accountButtonActionPerformed(evt);
      }
    });
    jToolBar1.add(accountButton);
    jToolBar1.add(jSeparator5);

    
    buttonGroup1.add(logoutButton);
    logoutButton.setText("Logout");
    logoutButton.setFocusable(false);
    logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    logoutButton.setMaximumSize(new java.awt.Dimension(84, 60));
    logoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    logoutButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            logoutButtonActionPerformed(evt);
        }
    });
    jToolBar1.add(logoutButton);
    jToolBar1.add(jSeparator7);
    
    javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
    headerPanel.setLayout(headerPanelLayout);
    headerPanelLayout.setHorizontalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1039,
        Short.MAX_VALUE));
    headerPanelLayout.setVerticalGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 75,
        Short.MAX_VALUE));

    javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
    menuPanel.setLayout(menuPanelLayout);
    menuPanelLayout.setHorizontalGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
            javax.swing.GroupLayout.Alignment.TRAILING,
            menuPanelLayout.createSequentialGroup().addContainerGap().addComponent(subMenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
    menuPanelLayout.setVerticalGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(subMenue, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE));

    bottomPanel.setBackground(new java.awt.Color(255, 255, 255));
    bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    gridPanel.setPreferredSize(new java.awt.Dimension(1043, 435));
    gridTable.setShowGrid(true);
    gridTable.setGridColor(Color.DARK_GRAY);
    gridTable.setRowSelectionAllowed(true);

    gridTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    gridPanel.setViewportView(gridTable);

    javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
    bottomPanel.setLayout(bottomPanelLayout);
    bottomPanelLayout.setHorizontalGroup(bottomPanelLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1043, Short.MAX_VALUE)
        .addGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                bottomPanelLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0))));
    bottomPanelLayout.setVerticalGroup(bottomPanelLayout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 435, Short.MAX_VALUE)
        .addGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                bottomPanelLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0))));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
            layout.createSequentialGroup().addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    pack();
  }// </editor-fold>

  private void changeBtnGroup(Component btnGroup) {
    subMenue.removeAll();
    subMenue.add(btnGroup, BorderLayout.CENTER);
    subMenue.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION);
    gridPanel.setVisible(true);
    subMenue.updateUI();
  }

  private void popUpWindow(JFrame aif) {
    // AddInvForm aif = new AddInvForm();
    if(aif.isVisible())
      return;
    double winWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    double winHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    Dimension pd = new Dimension(aif.getSize());
    Point pp = new Point((int) (winWidth / 2 - pd.getWidth() / 2), (int) (winHeight / 2 - pd.getHeight() / 2));
    aif.setLocation(pp);
    aif.setVisible(true);
    aif.setAlwaysOnTop(true);
//    aif.setAlwaysOnTop(true);
  }

  private void isleButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(isleBtnGroup);
    gridTable.setModel(main.client.getISleUserInfoTM(0));
    gridType = 1;
  }

  private void osleButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(osleBtnGroup);
    gridTable.setModel(main.client.getOSleUserInfoTM(0));
    gridType = 2;
  }

  private void invButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(invBtnGroup);
    invAddBtn.setVisible(true);
    invAddBatchBtn.setVisible(true);
    invQueryBtn.setVisible(true);
    invVmBtn.setVisible(true);
    verifyInBtn.setVisible(false);
    verifyOutBtn.setVisible(false);
    reportBtn.setVisible(false);
    alarmBtn.setVisible(false);
    CheckInBtn.setVisible(false);
    checkOutBtn.setVisible(false);
    Object[][] data = main.client.getInvUserInfo(12);
    gridTable.setModel(main.client.getInvInfoTM(0));
    gridType = 3;
  }
  
  private void invCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(invBtnGroup);
    invAddBtn.setVisible(false);
    invAddBatchBtn.setVisible(false);
    invQueryBtn.setVisible(true);
    invVmBtn.setVisible(false);
    verifyInBtn.setVisible(true);
    verifyOutBtn.setVisible(true);
    reportBtn.setVisible(true);
    CheckInBtn.setVisible(true);
    checkOutBtn.setVisible(true);
    if (main.client.getUserLevel() == 3){
      alarmBtn.setVisible(true);
    }
    Object[][] data = main.client.getInvUserInfo(12);
    gridTable.setModel(main.client.getInvInfoTM(0));
    gridType = 3;
  }

  private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(accountBtnGroup);
    gridTable.setModel(main.client.getUserInfoTM(0));
    gridType = 5;
  }
  private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
    logoutBtnActionPerformed(evt);
  }

  private void invAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
    AddInvForm aif = new AddInvForm();
    popUpWindow(aif);
  }

  private void invAddBatchBtnActionPerformed(ActionEvent evt) {
    if (abif == null)
      abif = new AddBatchInvForm();
    popUpWindow(abif);
  }
  private void invVmBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (gridTable.getModel().getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "There is no item", "WARN", JOptionPane.WARNING_MESSAGE);
      return;
    }
    int curRow = gridTable.getSelectedRow() == -1 ? 0 : gridTable.getSelectedRow();
    ViewInvForm vif = new ViewInvForm(gridTable.getModel().getValueAt(curRow, 0).toString());
    popUpWindow(vif);
  }

  private void invQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (qif == null)
      qif =  new QueryInvFrame();
    popUpWindow(qif);

  }

  private void verifyInBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if(vinf == null)
     vinf = new VerifyInForm();
    popUpWindow(vinf);
  }

  private void verifyOutBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (voutf == null)
       voutf = new VerifyOutForm();
    popUpWindow(voutf);
  }

  private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {
    File out = chooseCSVFile();
    TableModel tm = (TableModel) gridTable.getModel();
    String[] titles = tm.getColumns();
    Object[][] data = tm.getData();
    if (out != null) {
      try {
        CSVWriter w = CsvFileUtil.createWriter(out);
        w.writeNext(titles);
//        w.writeNext(new String[] { "" });
        for (int i = 0; i < data.length; i++) {
          String[] str = new String[titles.length];
          for (int j = 0; j < titles.length; j++) {
            if (data[i][j] == null) {
              str[j] = "";
            }else {
              str[j] = data[i][j].toString();
            }
          }
          w.writeNext(str);
        }           
        CsvFileUtil.closeWriter(w);
        JOptionPane.showMessageDialog(null, "Successfully write csv to : " + out.getAbsolutePath(), "INFO", JOptionPane.INFORMATION_MESSAGE);
      } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to write csv to : " + out.getAbsolutePath(), "INFO", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }

  private void alarmBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if(amf == null)
     amf = new AlarmMailForm();
    popUpWindow(amf);
  }
  
  private void  CheckInBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (cif == null)
      cif = new CheckInForm();
    popUpWindow(cif);
  }
  private void  checkOutBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if(cof == null)
     cof = new CheckOutForm();
    popUpWindow(cof);
  }
  

  private void isleAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (aisf == null)
      aisf = new AddISleForm();
    popUpWindow(aisf);
  }

  private void isleVmBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (gridTable.getModel().getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "There is no item", "WARN", JOptionPane.WARNING_MESSAGE);
      return;
    }
    int curRow = gridTable.getSelectedRow() == -1 ? 0 : gridTable.getSelectedRow();
    ViewISleForm aif = new ViewISleForm(gridTable.getModel().getValueAt(curRow, 0).toString());
    popUpWindow(aif);
  }

  private void isleQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // QueryISleForm aif = new QueryISleForm();
    // popUpWindow(aif);
    gridTable.setModel(main.client.getISleUserInfoTM(0));
  }

  private void osleAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if(aosf == null)
      aosf = new AddOSleForm();
    popUpWindow(aosf);
  }

  private void osleVmBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (gridTable.getModel().getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "There is no item", "WARN", JOptionPane.WARNING_MESSAGE);
      return;
    }
    int curRow = gridTable.getSelectedRow() == -1 ? 0 : gridTable.getSelectedRow();
    ViewOSleForm aif = new ViewOSleForm(gridTable.getModel().getValueAt(curRow, 0).toString());
    popUpWindow(aif);
  }

  private void osleQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (msof == null)
      msof = new ShipOutForm();
    popUpWindow(msof);

  }

  private void LockerAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
    AddStorageForm aif = new AddStorageForm();
    popUpWindow(aif);
  }

  private void LockerVmBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (gridTable.getModel().getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "There is no item", "WARN", JOptionPane.WARNING_MESSAGE);
      return;
    }
    int curRow = gridTable.getSelectedRow() == -1 ? 0 : gridTable.getSelectedRow();
    ViewStorageForm aif = new ViewStorageForm(gridTable.getModel().getValueAt(curRow, 0).toString());
    popUpWindow(aif);
  }

  private void LockerQueryBtnActionPerformed(java.awt.event.ActionEvent evt) {

  }

  private void changPwdBtnActionPerformed(java.awt.event.ActionEvent evt) {
    ChangPwdForm aif = new ChangPwdForm();
    popUpWindow(aif);
  }

  private void userAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
    AddUserForm aif = new AddUserForm();
    popUpWindow(aif);
  }

  private void delUserBtnActionPerformed(java.awt.event.ActionEvent evt) {
  }
  
  private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
    main.client = null;
    this.setVisible(false);
    this.dispose();
    LoginForm lf = new LoginForm(new javax.swing.JFrame(), true);
    double winWidth = Toolkit.getDefaultToolkit().getScreenSize()
        .getWidth();
    double winHeight = Toolkit.getDefaultToolkit().getScreenSize()
        .getHeight();
    Dimension pd = new Dimension(lf.getSize());
    Point pp = new Point((int) (winWidth / 2 - pd.getWidth() / 2),
        (int) (winHeight / 2 - pd.getHeight() / 2));
    lf.setLocation(pp);
    lf.setVisible(true);
  }

  private void userVMBtnActionPerformed(java.awt.event.ActionEvent evt) {
    if (gridTable.getModel().getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "There is no item", "WARN", JOptionPane.WARNING_MESSAGE);
      return;
    }
    int curRow = gridTable.getSelectedRow() == -1 ? 0 : gridTable.getSelectedRow();
    ViewUserForm aif = new ViewUserForm(gridTable.getModel().getValueAt(curRow, 0).toString());
    popUpWindow(aif);
  }

  private void LockerButtonActionPerformed(java.awt.event.ActionEvent evt) {
    changeBtnGroup(LockerBtnGroup);
    gridTable.setModel(main.client.getStorageTM(0));
    gridType = 4;
  }

  private void queryEditorMouseEntered(java.awt.event.MouseEvent evt) {
    // TODO add your handling code here:
    queryEditor.setText("");
  }

  private void invQueryEditorMouseEntered(java.awt.event.MouseEvent evt) {
    // TODO add your handling code here:
    invQueryEditor.setText("");
  }

  private void osleQueryEditorMouseEntered(java.awt.event.MouseEvent evt) {
    osleQueryEditor.setText("");
  }

  private void LockerQueryEditorMouseEntered(java.awt.event.MouseEvent evt) {
    LockerQueryEditor.setText("");
  }
  
  private File chooseCSVFile() {
    String lastPath = System.getProperty("user.dir");
//    String lastPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    JFileChooser file = new JFileChooser(lastPath);
    file.setAcceptAllFileFilterUsed(false);
    file.addChoosableFileFilter(new FileFilter() {
      @Override
      public boolean accept(File f) {
        if (f.getName().contains(".csv")) {
          return true;
        } else if (f.isDirectory()) {
          return true;
        } else {
          return false;
        }
      }

      @Override
      public String getDescription() {
        return "csv file (*.csv)";
      }
    });
    String fileName = null;
    try {
      int result = file.showSaveDialog(null);

      if (result == JFileChooser.FILES_ONLY) {
        fileName = file.getSelectedFile().getAbsolutePath();

        if (!fileName.endsWith(".csv")) {
          fileName += ".csv";
        }
        return new File(fileName);
      } else {
      }
    } catch (Exception e) {
    }
    return null;
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
     * default look and feel. For details see http://download.oracle.com/javase
     * /tutorial/uiswing/lookandfeel/plaf.html
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
    // </editor-fold>
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainForm().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify
  private javax.swing.JPanel accountBtnGroup;
  private javax.swing.JToggleButton accountButton;
  private javax.swing.JToggleButton logoutButton;
  private javax.swing.JButton alarmBtn;
  private javax.swing.JButton CheckInBtn;
  private javax.swing.JButton checkOutBtn;
  private javax.swing.JPanel bottomPanel;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton changPwdBtn;
  private javax.swing.JButton delUserBtn;
  private javax.swing.JScrollPane gridPanel;
  public static org.jdesktop.swingx.JXTable gridTable;
  private javax.swing.JPanel headerPanel;
  private javax.swing.JPanel initialPanel;
  private javax.swing.JButton invAddBtn;
  private javax.swing.JButton invAddBatchBtn;
  private javax.swing.JPanel invBtnGroup;
  private javax.swing.JToggleButton invButton;
  private javax.swing.JToggleButton invCheckButton;
  private javax.swing.JButton invQueryBtn;
  private javax.swing.JButton invVmBtn;
  private javax.swing.JButton isleAddBtn;
  private javax.swing.JPanel isleBtnGroup;
  private javax.swing.JToggleButton isleButton;
  private javax.swing.JButton isleQueryBtn;
  private javax.swing.JButton isleVmBtn;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JToolBar.Separator jSeparator1;
  private javax.swing.JToolBar.Separator jSeparator2;
  private javax.swing.JToolBar.Separator jSeparator3;
  private javax.swing.JToolBar.Separator jSeparator6;
  private javax.swing.JToolBar.Separator jSeparator4;
  private javax.swing.JToolBar.Separator jSeparator5;
  private javax.swing.JToolBar.Separator jSeparator7;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JPanel menuPanel;
  private javax.swing.JButton osleAddBtn;
  private javax.swing.JPanel osleBtnGroup;
  private javax.swing.JToggleButton osleButton;
  private javax.swing.JButton osleQueryBtn;
  private javax.swing.JButton osleVmBtn;
  private javax.swing.JButton reportBtn;
  private javax.swing.JButton LockerAddBtn;
  private javax.swing.JPanel LockerBtnGroup;
  private javax.swing.JToggleButton LockerButton;
  private javax.swing.JButton LockerQueryBtn;
  private javax.swing.JButton LockerVmBtn;
  private org.jdesktop.swingx.JXCollapsiblePane subMenue;
  private javax.swing.JButton userAddBtn;
  private javax.swing.JButton userVMBtn;
  private javax.swing.JButton logoutBtn;
  private javax.swing.JButton verifyInBtn;
  private javax.swing.JButton verifyOutBtn;
  private static int gridType = 0;
  private javax.swing.JTextField queryEditor;
  private javax.swing.JTextField invQueryEditor;
  private javax.swing.JTextField osleQueryEditor;
  private javax.swing.JTextField LockerQueryEditor;
  private AddBatchInvForm abif = new AddBatchInvForm();
  private QueryInvFrame qif = new QueryInvFrame();
  private VerifyInForm vinf = new VerifyInForm();
  VerifyOutForm voutf = new VerifyOutForm();
  AlarmMailForm amf = new AlarmMailForm();
  CheckInForm cif = new CheckInForm();
  CheckOutForm cof = new CheckOutForm();
  AddISleForm aisf = new AddISleForm();
  AddOSleForm aosf = new AddOSleForm();
  ShipOutForm msof = new ShipOutForm();
  // End of variables declaration
}
