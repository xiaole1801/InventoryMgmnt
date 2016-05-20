package ui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.model.ComboboxItem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;


//public class QueryInvFrame extends JFrame{
//  private ArrayList<GroupComp> listCompGroup = new ArrayList<GroupComp>();
//  private ArrayList<Integer> listB = new ArrayList<Integer>();
//  private JButton addQueryBtn = new JButton("Add");
//  private JButton delQueryBtn = new JButton("Delete");
//  private JButton queryBtn = new JButton("Query");
//  private JPanel mainPanel;
//  private JScrollPane scrollPanel;
//  private JPanel showPanel;
//  private GroupComp firstLineComps;
//  private int compHeight = 45;
//  
//  public QueryInvFrame() {
//    // TODO Auto-generated constructor stub
//    initComponents();
//    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//    scrollPanel.setBounds(0, 0, 500, 305);
//    
//  }
//  private void initComponents(){
//    mainPanel =  new JPanel();
//    showPanel = new JPanel();
//    scrollPanel = new JScrollPane();
//    firstLineComps = new GroupComp();
//    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//    this.setTitle("Query condition settings");
//    Alignment horizontalAlign = Alignment.LEADING;
//    
//    GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
//    mainPanel.setLayout(mainPanelLayout);
//    ParallelGroup mainPanelHorizontalGroup = mainPanelLayout.createParallelGroup(horizontalAlign)
//        .addGroup(mainPanelLayout.createSequentialGroup()
//            .addComponent(scrollPanel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        .addGroup(mainPanelLayout.createSequentialGroup()
//            .addContainerGap()
//            .addComponent(addQueryBtn)
////            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//            .addGap(18, 18, 18)
//            .addComponent(delQueryBtn)
////            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//            .addGap(18, 18, 18)
//            .addComponent(queryBtn));
//    mainPanelLayout.setHorizontalGroup(mainPanelHorizontalGroup);
//    
//    
//    ParallelGroup mainPanelVerticalGroup = mainPanelLayout.createParallelGroup(horizontalAlign)
//        .addGroup(mainPanelLayout.createSequentialGroup()
//            .addGroup(mainPanelLayout.createParallelGroup(horizontalAlign)
//                .addGroup(mainPanelLayout.createSequentialGroup()
//                    .addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(addQueryBtn))
//                .addGroup(mainPanelLayout.createSequentialGroup()
//                    .addGap(355, 355, 355)
//                    .addGroup(mainPanelLayout.createParallelGroup(horizontalAlign)
//                    .addComponent(delQueryBtn)
//                    .addComponent(queryBtn)))));
//    mainPanelLayout.setVerticalGroup(mainPanelVerticalGroup);
//    
//    GroupLayout frameLayout=  new GroupLayout(this.getContentPane());
//    this.getContentPane().setLayout(frameLayout);
//    ParallelGroup horizontalGroup = frameLayout.createParallelGroup(horizontalAlign).addComponent(mainPanel,GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE);
//    frameLayout.setHorizontalGroup(horizontalGroup);
//    ParallelGroup verticalGroup = frameLayout.createParallelGroup(horizontalAlign).addComponent(mainPanel,GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE);
//    frameLayout.setVerticalGroup(verticalGroup);
//    
//    GroupLayout myPanelLayout = new GroupLayout(showPanel);
//    showPanel.setLayout(myPanelLayout);
//    myPanelLayout.setHorizontalGroup(
//        myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//        .addGap(0, 305, Short.MAX_VALUE)
//    );
//    myPanelLayout.setVerticalGroup(
//        myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//        .addGap(0, 333, Short.MAX_VALUE)
//    );
//    firstLineComps.getQueryContent().setBounds(0, 10, 170, 25);
//    firstLineComps.getQueryText().setBounds(175, 10, 128, 20);
//    showPanel.add(firstLineComps.getQueryContent());
//    showPanel.add(firstLineComps.getQueryText());
//    scrollPanel.setViewportView(showPanel);
//    
//    addQueryBtn.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        addQueryBtnActionPerformed(e);
//      }
//    });
//    
//    delQueryBtn.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        delQueryBtnActionPerformed(e);
//      }
//    }); 
//    queryBtn.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        queryBtnActionPerformed(e);
//      }
//    }); 
//    pack();
//    
//  }
//  
//  private void addQueryBtnActionPerformed(ActionEvent e) {
//    if (compHeight < 280) {
//      GroupComp components = new GroupComp();
//      JPanel compPanel = components.getSubPanel();
//      compPanel.setBounds(0, compHeight, 280, 70);
//      listCompGroup.add(components);
//      showPanel.add(compPanel);
//      showPanel.revalidate();
//      showPanel.repaint();
//      compHeight = compHeight + 70;
//    }
//
//  }
//  private void delQueryBtnActionPerformed(ActionEvent e){
//    if (listCompGroup.size() == 0){
//      return;
//    }
//    listCompGroup.remove((listCompGroup.size()-1));
//    showPanel.removeAll();
//    firstLineComps.getQueryContent().setBounds(0, 10, 170, 25);
//    firstLineComps.getQueryText().setBounds(175, 10, 128, 20);
//    showPanel.add(firstLineComps.getQueryContent());
//    showPanel.add(firstLineComps.getQueryText());
//    compHeight = 45;
//    for (int i = 0; i < listCompGroup.size(); i++) {
//      JPanel compPanel = listCompGroup.get(i).getSubPanel();
//      compPanel.setBounds(0, compHeight, 280, 70);
//      showPanel.add(compPanel);
//      compHeight = compHeight + 70;
//    }
//    showPanel.revalidate();
//    showPanel.repaint();
//  }
//  private void queryBtnActionPerformed(ActionEvent e){
//    if(firstLineComps.getQueryText().getText().equals("")){
//      JOptionPane.showMessageDialog(null, "Query content should not be null", "Warning", JOptionPane.INFORMATION_MESSAGE);
//      return;
//    }
//    for (int i = 0; i < listCompGroup.size(); i++) {
//      if (listCompGroup.get(i).getQueryText().getText().equals("")){
//        JOptionPane.showMessageDialog(null, "Query content should not be null", "Warning", JOptionPane.INFORMATION_MESSAGE);
//        return;
//      }
//    }
//    String sqlString = "";
//    if (((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey().contains("TIME"))
//      sqlString = ((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey()+ " date('"+ firstLineComps.getQueryText().getText() + "') ";
//    else
//      sqlString = ((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey()+ " '%"+ firstLineComps.getQueryText().getText() + "%' ";
//      
//    for (int i = 0; i < listCompGroup.size(); i++) {
//      if (((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey().contains("TIME"))
//        sqlString = sqlString + " " + listCompGroup.get(i).getRadioResult()+ " "+((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " date('"+ listCompGroup.get(i).getQueryText().getText()+"')";
//      else
//        sqlString = sqlString + " " + listCompGroup.get(i).getRadioResult()+ " "+((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " '%"+ listCompGroup.get(i).getQueryText().getText()+"%'";
//        
//    }
//    MainForm.gridTable.setModel(init.main.client.getInvInfoTM(0, sqlString));
//    System.err.println(sqlString);
//  }
//   public static void main(String[] args) {
//    EventQueue.invokeLater(new Runnable() {
//      
//      @Override
//      public void run() {
//        // TODO Auto-generated method stub
//        new QueryInvFrame().setVisible(true);
//        
//      }
//    });
//  }
//}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhangle
 */
public class QueryInvFrame extends javax.swing.JFrame {

    /**
     * Creates new form QueryInvFrame
     */
    public QueryInvFrame() {
        initComponents();
        firstLineComps = new GroupComp(false);
        JPanel compPanel = firstLineComps.getSubPanel();
        compPanel.setBounds(30, 20, 280, 30);
//        listCompGroup.add(firstLineComps);
        showPanel.add(compPanel);
        showPanel.revalidate();
        showPanel.repaint();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Search condition settings");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        showPanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.setVisible(false);
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setVisible(false);
        jPanel1 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        queryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        showPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(showPanel);
        showPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(396, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        addBtn.setText("Add");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        queryBtn.setText("Search");
        queryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryBtnActionPerformed(evt);
            }
        });

        queryBtn.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82)
                .addComponent(queryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBtn)
                        .addComponent(deleteBtn))
                    .addComponent(queryBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 474, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(58, 58, 58)))
        );

        pack();
    }// </editor-fold>                        

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
      if (listCompGroup.size() == 0){
          return;
      }
      listCompGroup.remove((listCompGroup.size()-1));
      showPanel.removeAll();
      JPanel compPanel = firstLineComps.getSubPanel();
      compPanel.setBounds(30, 20, 280, 30);
      showPanel.add(compPanel);
      compHeight = 65;
      for (int i = 0; i < listCompGroup.size(); i++) {
        compPanel = listCompGroup.get(i).getSubPanel();
        compPanel.setBounds(30, compHeight, 280, 70);
        showPanel.add(compPanel);
        compHeight = compHeight + 70;
      }
      showPanel.revalidate();
      showPanel.repaint();
      System.err.println(compHeight);
    }                                         
  
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
      if (compHeight < 280) {
      GroupComp components = new GroupComp(true);
      JPanel compPanel = components.getSubPanel();
      compPanel.setBounds(30, compHeight, 280, 70);
      listCompGroup.add(components);
      showPanel.add(compPanel);
      showPanel.revalidate();
      showPanel.repaint();
      compHeight = compHeight + 70;
    }
    }                                      
  
    private void queryBtnActionPerformed(java.awt.event.ActionEvent evt) { 
    if(firstLineComps.getQueryText().getText().equals("")){
    JOptionPane.showMessageDialog(QueryInvFrame.this, "Search content should not be null", "Warning", JOptionPane.INFORMATION_MESSAGE);
    return;
  }
  for (int i = 0; i < listCompGroup.size(); i++) {
    if (listCompGroup.get(i).getQueryText().getText().equals("")){
      JOptionPane.showMessageDialog(QueryInvFrame.this, "Search content should not be null", "Warning", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
  }
  String sqlString = "";
  if (((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey().contains("TIME"))
    sqlString = ((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey()+ " date('"+ firstLineComps.getQueryText().getText() + "') ";
  else
    sqlString = ((ComboboxItem)firstLineComps.getQueryContent().getSelectedItem()).getKey()+ " '%"+ firstLineComps.getQueryText().getText() + "%' ";
    
  for (int i = 0; i < listCompGroup.size(); i++) {
    if (((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey().contains("TIME"))
      sqlString = sqlString + " " + listCompGroup.get(i).getRadioResult()+ " "+((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " date('"+ listCompGroup.get(i).getQueryText().getText()+"')";
    else
      sqlString = sqlString + " " + listCompGroup.get(i).getRadioResult()+ " "+((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " '%"+ listCompGroup.get(i).getQueryText().getText()+"%'";
      
  }
  System.err.println(sqlString);
  MainForm.gridTable.setModel(init.main.client.getInvInfoTM(0, sqlString));
                                        
        // TODO add your handling code here:
    }                                     

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
            java.util.logging.Logger.getLogger(QueryInvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryInvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryInvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryInvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryInvFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton queryBtn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel showPanel;
    private javax.swing.JTextField jTextField1;
    private int compHeight = 65;
    private ArrayList<GroupComp> listCompGroup = new ArrayList<GroupComp>();
    private GroupComp firstLineComps;
    // End of variables declaration                   
}
