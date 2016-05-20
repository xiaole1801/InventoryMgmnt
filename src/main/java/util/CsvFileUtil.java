package util;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;


public class CsvFileUtil {

  public static CSVWriter createWriter(File out) throws Exception {
    return new CSVWriter(new FileWriter(out));
  }

  public static void closeWriter(CSVWriter w) throws Exception {
    w.close();
  }

  public static void write(CSVWriter w, String[] ss, int offset) throws Exception {
    String[] re = new String[ss.length + offset];
    for (int i = 0; i < offset; i++)
      re[i] = "";
    System.arraycopy(ss, 0, re, offset, ss.length);
    w.writeNext(re);
  }


}