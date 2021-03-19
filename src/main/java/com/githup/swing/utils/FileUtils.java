package com.githup.swing.utils;

import java.io.*;

public class FileUtils {

  public boolean writeProp(String path) {

    File file = new File(path);
    FileUtils fileUtils = new FileUtils();
    if (file.exists()) {
      fileUtils.writeFile(file);
    } else {
      String content = fileUtils.readFile(file);
      System.out.println(content);
    }
    return true;
  }

  public void writeFile(File file) {
    try {
      // 判断文件是否存在，如果不存在就新建一个txt
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write("content".getBytes());
      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String readFile(File file) {
    StringBuilder builder = new StringBuilder();
    try {

      InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "GBK");
      BufferedReader bfreader = new BufferedReader(reader);
      String line;
      // 包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
      while ((line = bfreader.readLine()) != null) {
        builder.append(line);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return builder.toString();
  }
}
