package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;

public class Label {
  private static String sparator = File.separator;
  // title显示的是打印的内容信息 barcodeNum 12位的 barcodeCrc全的
  public static byte[] creatLabel(String barcodeNum, String barcodeCrc, String title1, String title2) {
    try {
      JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
      localJBarcode.setShowText(false);
      localJBarcode.setXDimension(Double.valueOf(0.6).doubleValue());
      localJBarcode.setBarHeight(Double.valueOf(30).doubleValue());
      localJBarcode.setWideRatio(Double.valueOf(15).doubleValue());
      BufferedImage localBufferedImage = localJBarcode.createBarcode(barcodeNum);
      
      File barcodeFile = new File(System.getProperty("user.dir") + sparator + "barcode.png");
      ImageIO.write(localBufferedImage, "png", barcodeFile);
      
      int width = 261;
      int height = 22;


      File fileOne = createImageFile("title1.png", title1, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageFirst = ImageIO.read(fileOne);
      int[] imageArrayFirst = new int[width * height];
      imageArrayFirst = imageFirst.getRGB(0, 0, width, height, imageArrayFirst, 0, width);

      File fileTwo = createImageFile("title2.png", title2, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageSecond = ImageIO.read(fileTwo);
      int[] imageArraySecond = new int[width * height];
      imageArraySecond = imageSecond.getRGB(0, 0, width, height, imageArraySecond, 0, width);

      int barHeight = 100;
      BufferedImage imageThree = ImageIO.read(barcodeFile);
      int[] imageArrayThree = new int[width * barHeight];
      imageArrayThree = imageThree.getRGB(0, 0, width, barHeight, imageArrayThree, 0, width);

      File fileFour = createImageFile("foot.png", barcodeCrc, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageFour = ImageIO.read(fileFour);
      int[] imageArrayFour = new int[width * height];
      imageArrayFour = imageFour.getRGB(0, 0, width, height, imageArrayFour, 0, width);

      int heightSum = height*3+barHeight;

      BufferedImage imageResult = new BufferedImage(width, heightSum, BufferedImage.TYPE_INT_RGB);
      Graphics g = imageResult.getGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, width, heightSum);
      g.setColor(Color.black);
      g.dispose();
      
      int pos = getPosition(title1, width/2);
      imageResult.setRGB(pos, 0, width-pos, height, imageArrayFirst, 0, width);
      pos = getPosition(title2, width/2);
      imageResult.setRGB(pos, height, width-pos, height, imageArraySecond, 0, width);
      imageResult.setRGB(0, height+height, width, barHeight, imageArrayThree, 0, width);
      pos = getPosition(barcodeCrc, width/2);
      imageResult.setRGB(pos, height + height + barHeight , width-pos, height, imageArrayFour, 0, width);
//      File outFile = new File("barcode-last.png");
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(imageResult, "png", out);
      return out.toByteArray();
    } catch (Exception localException) {
      localException.printStackTrace();
    }
    return null;
  }

  public static byte[] creatInvLabel(String barcodeNum, String barcodeCrc, String InvTitle, String ProNum, String SN) {
    try {
      JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
      localJBarcode.setShowText(false);
      localJBarcode.setXDimension(Double.valueOf(0.6).doubleValue());
      localJBarcode.setBarHeight(Double.valueOf(30).doubleValue());
      localJBarcode.setWideRatio(Double.valueOf(15).doubleValue());
      BufferedImage localBufferedImage = localJBarcode.createBarcode(barcodeNum);
      
      File barcodeFile = new File(System.getProperty("user.dir") + sparator + "barcode.png");
      ImageIO.write(localBufferedImage, "png", barcodeFile);
      
      int width = 261;
      int height = 22;
      
      
      File invTitleFile = createImageFile("title1.png", InvTitle, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageFirst = ImageIO.read(invTitleFile);
      int[] imageArrayFirst = new int[width * height];
      imageArrayFirst = imageFirst.getRGB(0, 0, width, height, imageArrayFirst, 0, width);
      
      File proNumFile = createImageFile("title2.png", ProNum, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageSecond = ImageIO.read(proNumFile);
      int[] imageArraySecond = new int[width * height];
      imageArraySecond = imageSecond.getRGB(0, 0, width, height, imageArraySecond, 0, width);
      
      File snFile = createImageFile("title3.png", SN, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageFive = ImageIO.read(snFile);
      int[] imageArrayFive = new int[width * height];
      imageArrayFive = imageFive.getRGB(0, 0, width, height, imageArrayFive, 0, width);

      int barHeight = 78;
      BufferedImage imageThree = ImageIO.read(barcodeFile);
      int[] imageArrayThree = new int[width * barHeight];
      imageArrayThree = imageThree.getRGB(0, 0, width, barHeight, imageArrayThree, 0, width);
      
      File footFile = createImageFile("foot.png", barcodeCrc, new Font("Arial", Font.BOLD, 16), width, height);
      BufferedImage imageFour = ImageIO.read(footFile);
      int[] imageArrayFour = new int[width * height];
      imageArrayFour = imageFour.getRGB(0, 0, width, height, imageArrayFour, 0, width);
      
      int heightSum = height*4+barHeight;
      
      BufferedImage imageResult = new BufferedImage(width, heightSum, BufferedImage.TYPE_INT_RGB);
      Graphics g = imageResult.getGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, width, heightSum);
      g.setColor(Color.black);
      g.dispose();
      
      int pos = getPosition(InvTitle, width/2);
      imageResult.setRGB(pos, 0, width-pos, height, imageArrayFirst, 0, width);
      pos = getPosition(ProNum, width/2);
      imageResult.setRGB(pos, height, width-pos, height, imageArraySecond, 0, width);
      pos = getPosition(SN, width/2);
      imageResult.setRGB(pos, height*2, width-pos, height, imageArrayFive, 0, width);
      
      
      imageResult.setRGB(0, height*3, width, barHeight, imageArrayThree, 0, width);
      pos = getPosition(barcodeCrc, width/2);
      imageResult.setRGB(pos, height*3 + barHeight , width-pos, height, imageArrayFour, 0, width);
//      File outFile = new File("barcode-last.png");
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(imageResult, "png", out);
      return out.toByteArray();
    } catch (Exception localException) {
      localException.printStackTrace();
    }
    return null;
  }

  
  private static int getPosition(String title, int center) {
    int num = title.length();
    num = num/2;
    num = num*10;
    center = center-num;
    return center;
  }


  private static File createImageFile(String fileName, String fileContent, Font font, int width, int height) {
    File outFile = new File(System.getProperty("user.dir") + sparator + fileName);
    Rectangle2D r = font.getStringBounds(fileContent, new FontRenderContext(AffineTransform.getScaleInstance(1, 1), false, false));
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
    Graphics g = image.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.black);
    g.setFont(font);
    g.drawString(fileContent, 0, font.getSize());
    g.dispose();
    try {
      ImageIO.write(image, "png", outFile);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return outFile;
  }
  
  public static File generateFinalImage(String fileName, byte[] imageContent) {
    ByteArrayInputStream in  = new ByteArrayInputStream(imageContent);
    File outFile = new File(System.getProperty("user.dir") + sparator + fileName);
    try {
      BufferedImage image = ImageIO.read(in);
      ImageIO.write(image,"png", outFile);
    } catch (IOException e) {
      return null;
    }
    return outFile;
    
    
  }
}
