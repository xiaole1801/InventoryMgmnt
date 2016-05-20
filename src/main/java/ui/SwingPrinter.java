package ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

public class SwingPrinter extends JFrame {
  public static void main(String[] args) {
    new SwingPrinter();
  }

  private PageFormat mPageFormat;

  public SwingPrinter() {
    super("SwingPrinter v1.0");
    createUI();
    PrinterJob pj = PrinterJob.getPrinterJob();
    mPageFormat = pj.defaultPage();
    setVisible(true);
  }

  protected void createUI() {
    setSize(300, 285);
    center();

    // Add the menu bar.
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File", true);
    file.add(new FilePrintAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
    file.add(new FilePageSetupAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK
            | Event.SHIFT_MASK));
    file.addSeparator();
    file.add(new FileQuitAction()).setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
    mb.add(file);
    setJMenuBar(mb);

    // Add the contents of the window.
    getContentPane().add(new PatchworkComponent(new ImageIcon("barcode-last.png").getImage()));

    // Exit the application when the window is closed.
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  protected void center() {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension us = getSize();
    int x = (screen.width - us.width) / 2;
    int y = (screen.height - us.height) / 2;
    setLocation(x, y);
  }

  public class FilePrintAction extends AbstractAction {
    public FilePrintAction() {
      super("Print");
    }

    public void actionPerformed(ActionEvent ae) {
      PrinterJob pj = PrinterJob.getPrinterJob();
      ComponentPrintable cp = new ComponentPrintable(getContentPane());
      pj.setPrintable(cp, mPageFormat);
      if (pj.printDialog()) {
        try {
          pj.print();
        } catch (PrinterException e) {
          System.out.println(e);
        }
      }
    }
  }

  public class FilePageSetupAction extends AbstractAction {
    public FilePageSetupAction() {
      super("Page setup...");
    }

    public void actionPerformed(ActionEvent ae) {
      PrinterJob pj = PrinterJob.getPrinterJob();
      mPageFormat = pj.pageDialog(mPageFormat);
    }
  }

  public class FileQuitAction extends AbstractAction {
    public FileQuitAction() {
      super("Quit");
    }

    public void actionPerformed(ActionEvent ae) {
      System.exit(0);
    }
  }
}
class PatchworkComponent extends JComponent implements Printable {
  
  private Image img;

  private float mSide = 36;

  private float mOffset = 36;

  private int mColumns = 8;

  private int mRows = 4;

  private String mString = "Java Source and Support";

  private Font mFont = new Font("Serif", Font.PLAIN, 64);

  private Paint mHorizontalGradient, mVerticalGradient;

  public PatchworkComponent() {
    float x = mOffset;
    float y = mOffset;
    float halfSide = mSide / 2;
    float x0 = x + halfSide;
    float y0 = y;
    float x1 = x + halfSide;
    float y1 = y + (mRows * mSide);
    mVerticalGradient = new GradientPaint(x0, y0, Color.darkGray, x1, y1,
        Color.lightGray, true);
    x0 = x;
    y0 = y + halfSide;
    x1 = x + (mColumns * mSide);
    y1 = y + halfSide;
    mHorizontalGradient = new GradientPaint(x0, y0, Color.darkGray, x1, y1,
        Color.lightGray, true);
  }

  public PatchworkComponent(String s) {
    this();
    mString = s;
  }
  public PatchworkComponent(Image img) {
    this.img = img;
  }

  public void paintComponent(Graphics g) {
//    Graphics2D g2 = (Graphics2D) g;
//
//    g2.rotate(Math.PI / 24, mOffset, mOffset);
//
//    for (int row = 0; row < mRows; row++) {
//      for (int column = 0; column < mColumns; column++) {
//        float x = column * mSide + mOffset;
//        float y = row * mSide + mOffset;
//
//        if (((column + row) % 2) == 0)
//          g2.setPaint(mVerticalGradient);
//        else
//          g2.setPaint(mHorizontalGradient);
//
//        Rectangle2D r = new Rectangle2D.Float(x, y, mSide, mSide);
//        g2.fill(r);
//      }
//    }
//
//    FontRenderContext frc = g2.getFontRenderContext();
//    float width = (float) mFont.getStringBounds(mString, frc).getWidth();
//    LineMetrics lm = mFont.getLineMetrics(mString, frc);
//    float x = ((mColumns * mSide) - width) / 2 + mOffset;
//    float y = ((mRows * mSide) + lm.getAscent()) / 2 + mOffset;
//    g2.setFont(mFont);
//    g2.setPaint(Color.white);
//    g2.drawString(mString, x, y);
    super.paintComponent(g);
    setBackground(Color.white);
    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);

    g2.drawImage( img, 10, 10, 280, 220, this);

  }

  public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
    if (pageIndex != 0)
      return NO_SUCH_PAGE;
    paintComponent(g);
    return PAGE_EXISTS;
  }
}
class ComponentPrintable implements Printable {
  private Component mComponent;

  public ComponentPrintable(Component c) {
    mComponent = c;
  }

  public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
    if (pageIndex > 0)
      return NO_SUCH_PAGE;
    Graphics2D g2 = (Graphics2D) g;
    g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
    boolean wasBuffered = disableDoubleBuffering(mComponent);
    mComponent.paint(g2);
    restoreDoubleBuffering(mComponent, wasBuffered);
    return PAGE_EXISTS;
  }

  private boolean disableDoubleBuffering(Component c) {
    if (c instanceof JComponent == false)
      return false;
    JComponent jc = (JComponent) c;
    boolean wasBuffered = jc.isDoubleBuffered();
    jc.setDoubleBuffered(false);
    return wasBuffered;
  }

  private void restoreDoubleBuffering(Component c, boolean wasBuffered) {
    if (c instanceof JComponent)
      ((JComponent) c).setDoubleBuffered(wasBuffered);
  }
}