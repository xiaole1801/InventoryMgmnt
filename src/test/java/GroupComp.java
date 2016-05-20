import java.awt.Button;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import antlr.collections.List;


public class GroupComp {
  
  private JComboBox queryContent = new JComboBox();
  private JTextField queryText = new JTextField();
  private JRadioButton andRadio = new JRadioButton();
  private JRadioButton orRadio = new JRadioButton();
  private JPanel subMainPanel = null;
  private ButtonGroup radioGroup =new ButtonGroup();

  public GroupComp(){
    subMainPanel = new JPanel();
    GroupLayout layout = new GroupLayout(subMainPanel);
    subMainPanel.setLayout(layout);
    Alignment alignment =  Alignment.LEADING;
    ParallelGroup horizonGroup = layout.createParallelGroup(alignment)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(alignment)
                .addComponent(queryContent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(andRadio))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(queryText, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orRadio))
            .addContainerGap(0, Short.MAX_VALUE));
    layout.setHorizontalGroup(horizonGroup);
    ParallelGroup verticalGroup = layout.createParallelGroup(alignment)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(queryContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(queryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(andRadio)
                .addComponent(orRadio))
            .addContainerGap(0, Short.MAX_VALUE));
        
    layout.setVerticalGroup(verticalGroup);
    andRadio.setText("And");
    orRadio.setText("Or");
    radioGroup.add(andRadio);
    radioGroup.add(orRadio);
//    ComboboxItem items[] = new ComboboxItem("CREATETIME <=", "Create Time less");
    orRadio.setSelected(true);
    queryContent.addItem(new ComboboxItem("CREATETIME", "Create Time <"));
    queryContent.addItem(new ComboboxItem("CREATETIME", "Create Time >"));
    queryContent.addItem(new ComboboxItem("CREATEENG", "Create Engnieer"));
    queryContent.addItem(new ComboboxItem("CHECKINTIME", "Check in Time"));
    queryContent.addItem(new ComboboxItem("CHECKOUTTIME", "Check out Time"));
//    subMainPanel.setBounds(0, 0, 50, 50);
    
  }
  public JComboBox getQueryContent() {
    return queryContent;
  }

  public void setQueryContent(JComboBox queryContent) {
    this.queryContent = queryContent;
  }

  public JTextField getQueryText() {
    return queryText;
  }

  public void setQueryText(JTextField queryText) {
    this.queryText = queryText;
  }

  public JRadioButton getAndRadio() {
    return andRadio;
  }

  public void setAndRadio(JRadioButton andRadio) {
    this.andRadio = andRadio;
  }

  public JRadioButton getOrRadio() {
    return orRadio;
  }

  public void setOrRadio(JRadioButton orRadio) {
    this.orRadio = orRadio;
  }
  
  public JPanel getSubPanel() {
    return subMainPanel;
  }
  
  public String getRadioResult(){
    if (andRadio.isSelected()){
      return "AND";
    }else if(orRadio.isSelected()){
      return "OR";
    }
    return "";
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        JFrame jf = new JFrame();
        GroupComp gc= new GroupComp();
        JPanel jp = gc.getSubPanel();
        
//        GroupLayout frameLayout=  new GroupLayout(jf.getContentPane());
//        jf.getContentPane().setLayout(frameLayout);
//        ParallelGroup horizontalGroup = frameLayout.createParallelGroup(Alignment.LEADING).addComponent(gc.getSubPanel(),GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
//        frameLayout.setHorizontalGroup(horizontalGroup);
//        ParallelGroup verticalGroup = frameLayout.createParallelGroup(Alignment.LEADING).addComponent(gc.getSubPanel(),GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE);
//        frameLayout.setVerticalGroup(verticalGroup);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.add(jp);
        jf.pack();
        jf.setVisible(true);
      }
    });
  }
}
