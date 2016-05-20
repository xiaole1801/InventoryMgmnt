import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class TestBarcode {

  
  public static String createBarCode(String savePath, String jbarCode, String imgFormat) {
    try {
      BufferedImage bi = null;
      int len = jbarCode.length();
      JBarcode jbarcode13 = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());
      String barCode = jbarCode.substring(0, len - 1);
      System.err.println(barCode);
      String code = jbarCode.substring(len - 1, len);
      System.err.println(code);
      String checkCode = jbarcode13.calcCheckSum(barCode);
      System.err.println(checkCode);
      if (!code.equals(checkCode)) {
        return "crc wrong";
      }
      jbarcode13.setXDimension(Double.valueOf(1).doubleValue());
      jbarcode13.setBarHeight(Double.valueOf(30).doubleValue());
      jbarcode13.setWideRatio(Double.valueOf(1).doubleValue());
      jbarcode13.setShowCheckDigit(true);
      bi = jbarcode13.createBarcode(barCode);

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
      String imgName = sdf.format(new Date()) + "_" + jbarCode;
      FileOutputStream fileOutputStream = null;
      String imgPath = savePath + imgName + "." + imgFormat;
      savePath = URLDecoder.decode(savePath, "UTF-8");
      File dirFile = new File(savePath);
      if (!dirFile.exists()) {
        dirFile.mkdirs();
      }
      fileOutputStream = new FileOutputStream(imgPath);
      ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
      fileOutputStream.close();
      return imgPath;
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    
    return null;
  }

  public static void main(String[] args) {
    String path = TestBarcode.createBarCode("/Users/zhangle/Desktop/", "6937748304340", ImageUtil.JPEG);
    System.err.println(path);
  }
}