import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;


public class QueryInvFrame extends JFrame{
  private ArrayList<GroupComp> listCompGroup = new ArrayList<GroupComp>();
  private ArrayList<Integer> listB = new ArrayList<Integer>();
  private JButton addQueryBtn = new JButton("Add");
  private JButton delQueryBtn = new JButton("Delete");
  private JButton queryBtn = new JButton("Query");
  private JPanel mainPanel;
  private JScrollPane scrollPanel;
  private JPanel showPanel;
  private int compHeight = 0;
  
  public QueryInvFrame() {
    // TODO Auto-generated constructor stub
    initComponents();
    scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPanel.setBounds(0, 0, 500, 305);
    
  }
  private void initComponents(){
    mainPanel =  new JPanel();
    showPanel = new JPanel();
    scrollPanel = new JScrollPane();
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    Alignment horizontalAlign = Alignment.LEADING;
    
    GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    ParallelGroup mainPanelHorizontalGroup = mainPanelLayout.createParallelGroup(horizontalAlign)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addComponent(scrollPanel,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(addQueryBtn)
//            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGap(18, 18, 18)
            .addComponent(delQueryBtn)
//            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGap(18, 18, 18)
            .addComponent(queryBtn));
    mainPanelLayout.setHorizontalGroup(mainPanelHorizontalGroup);
    
    
    ParallelGroup mainPanelVerticalGroup = mainPanelLayout.createParallelGroup(horizontalAlign)
        .addGroup(mainPanelLayout.createSequentialGroup()
            .addGroup(mainPanelLayout.createParallelGroup(horizontalAlign)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addQueryBtn))
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(355, 355, 355)
                    .addGroup(mainPanelLayout.createParallelGroup(horizontalAlign)
                    .addComponent(delQueryBtn)
                    .addComponent(queryBtn)))));
    mainPanelLayout.setVerticalGroup(mainPanelVerticalGroup);
    
    GroupLayout frameLayout=  new GroupLayout(this.getContentPane());
    this.getContentPane().setLayout(frameLayout);
    ParallelGroup horizontalGroup = frameLayout.createParallelGroup(horizontalAlign).addComponent(mainPanel,GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE);
    frameLayout.setHorizontalGroup(horizontalGroup);
    ParallelGroup verticalGroup = frameLayout.createParallelGroup(horizontalAlign).addComponent(mainPanel,GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE);
    frameLayout.setVerticalGroup(verticalGroup);
    
    GroupLayout myPanelLayout = new GroupLayout(showPanel);
    showPanel.setLayout(myPanelLayout);
    myPanelLayout.setHorizontalGroup(
        myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 305, Short.MAX_VALUE)
    );
    myPanelLayout.setVerticalGroup(
        myPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 333, Short.MAX_VALUE)
    );

    scrollPanel.setViewportView(showPanel);
    
    addQueryBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        addQueryBtnActionPerformed(e);
      }
    });
    
    delQueryBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        delQueryBtnActionPerformed(e);
      }
    }); 
    queryBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        queryBtnActionPerformed(e);
      }
    }); 
    pack();
    
  }
  
  private void addQueryBtnActionPerformed(ActionEvent e) {
    if (compHeight < 350) {
      GroupComp components = new GroupComp();
      JPanel compPanel = components.getSubPanel();
      compPanel.setBounds(0, compHeight, 300, 70);
      listCompGroup.add(components);
      showPanel.add(compPanel);
      showPanel.revalidate();
      showPanel.repaint();
      compHeight = compHeight + 70;
    }

  }
  private void delQueryBtnActionPerformed(ActionEvent e){
    if (listCompGroup.size() == 0){
      return;
    }
    listCompGroup.remove((listCompGroup.size()-1));
    showPanel.removeAll();
    compHeight = 0;
    for (int i = 0; i < listCompGroup.size(); i++) {
      JPanel compPanel = listCompGroup.get(i).getSubPanel();
      compPanel.setBounds(0, compHeight, 300, 70);
      showPanel.add(compPanel);
      compHeight = compHeight + 70;
    }
    showPanel.revalidate();
    showPanel.repaint();
  }
  private void queryBtnActionPerformed(ActionEvent e){
//    System.err.println(((ComboboxItem)listCompGroup.get(0).getQueryContent().getSelectedItem()).getValue());
    String sqlString = ((ComboboxItem)listCompGroup.get(0).getQueryContent().getSelectedItem()).getKey()+ " "+ listCompGroup.get(0).getQueryText().getText() + " " + listCompGroup.get(0).getRadioResult()+ " ";
    sqlString = "";
    for (int i = 0; i < listCompGroup.size(); i++) {
      if (i == listCompGroup.size()-1){
        sqlString = sqlString + ((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " "+ listCompGroup.get(i).getQueryText().getText();
      }else
      sqlString = sqlString + ((ComboboxItem)listCompGroup.get(i).getQueryContent().getSelectedItem()).getKey()+ " "+ listCompGroup.get(i).getQueryText().getText() + " " + listCompGroup.get(i).getRadioResult()+ " ";
    }
    System.err.println(sqlString);
  }
   public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        // TODO Auto-generated method stub
        new QueryInvFrame().setVisible(true);
        
      }
    });
  }
}
