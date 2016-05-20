import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SwingWindow extends JFrame implements ActionListener {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  JPanel jp = (JPanel) this.getContentPane();
  private ArrayList<Group> list = new ArrayList<Group>();
  private ArrayList<Integer> listB = new ArrayList<Integer>();
  int y = 50;
  int num = 0;

  public SwingWindow() {
    this.setTitle("��ʾ����");
    jp.setLayout(null);
    final JButton jb = new JButton("�����");
    jb.setBounds(new Rectangle(20, 20, 80, 25));
    final JButton jbadd = new JButton("ȷ��");
    final JButton jbcz = new JButton("����");
    jbadd.setBounds(new Rectangle(110, 20, 80, 25));
    jbcz.setBounds(new Rectangle(200, 20, 80, 25));
    jp.add(jb);
    jp.add(jbadd);
    jp.add(jbcz);
    jb.addActionListener(this);
    jbadd.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        jp.removeAll();
//        jp.validate();// �ع��������
        
        jp.add(jbadd);
        jp.add(jbcz);
        jp.add(jb);
        
        jp.repaint();// �ػ��������
      }
    });
//    jb.addActionListener(new ActionListener() {
//      
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        // TODO Auto-generated method stub
//        System.err.println("hello");
//        
//      }
//    });

  }

  public static void main(String[] args) {
    SwingWindow frame = new SwingWindow();
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public JTextField getMyJTextField(int y) {
    JTextField jt = null;
    jt = new JTextField(20);
    jt.setBounds(new Rectangle(20, y, 100, 20));
    return jt;
  }

  public JTextField getMyJTextField1(int y) {
    JTextField jt1 = null;
    jt1 = new JTextField(20);
    jt1.setBounds(new Rectangle(130, y, 100, 20));
    return jt1;
  }

  public JButton getMyJButton(int y) {
    JButton jbut = null;
    jbut = new JButton("ɾ����");
    jbut.setBounds(new Rectangle(240, y, 75, 20));
    return jbut;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void advancey() {
    this.y = this.y + 30;
  }

  public void actionPerformed(ActionEvent arg0) {
    JButton button = (JButton) arg0.getSource();
    if (button.getText().equals("�����")) {
      if (num < 50) {
        num++;
        JTextField jt = null;
        JTextField jtx = null;
        JButton jbut = null;
        if (listB.size() > 0) {
          Collections.sort(listB);
          int ny = listB.get(0);
          jt = getMyJTextField(ny);
          jtx = getMyJTextField1(ny);
          jbut = getMyJButton(ny);
          listB.remove(0);
        } else {
          this.advancey();
          jt = getMyJTextField(y);
          jtx = getMyJTextField1(y);
          jbut = getMyJButton(y);
        }
        Group gg = new Group();
        gg.setJb(jbut);
        gg.setJj(jtx);
        gg.setJt(jt);
        list.add(gg);
        StringBuffer sb = new StringBuffer();
        this.panelAdd(jp, gg, sb, list, listB);
        jp.validate();// �ع��������
        jp.repaint();// �ػ��������
      }
    }else if (button.getText().equals("����")){
      jp.validate();// �ع��������
      jp.repaint();// �ػ��������
    }
    return;
  }

  public void panelAdd(final JPanel jp, final Group gg, final StringBuffer sb, final ArrayList<Group> ls, final ArrayList<Integer> lt) {
    jp.add(gg.getJt(), null);
    jp.add(gg.getJj(), null);
    jp.add(gg.getJb(), null);
    gg.getJb().addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jp.remove(gg.getJt());
        jp.remove(gg.getJj());
        jp.remove(gg.getJb());
        jp.validate();// �ع��������
        jp.repaint();// �ػ��������
        sb.setLength(0);
        ls.remove(gg);
        lt.add(gg.getJj().getY());
        num--;
      }
    });
  }
}
