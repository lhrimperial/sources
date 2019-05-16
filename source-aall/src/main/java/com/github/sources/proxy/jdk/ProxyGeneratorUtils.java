package com.github.sources.proxy.jdk;

import com.github.sources.proxy.jdk.impl.ProxyInterfaceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 代理类的生成工具
 *
 * @author hairen.long
 * @date 2019-05-09
 */
public class ProxyGeneratorUtils {

  /**
   * 把代理类的字节码写到硬盘上
   *
   * @param path 保存路径
   */
  public static void writeProxyClassToHardDisk(String path) {

    // 获取代理类的字节码
    byte[] classFile =
        ProxyGenerator.generateProxyClass("$Proxy11", ProxyInterfaceImpl.class.getInterfaces());

    FileOutputStream out = null;

    try {
      out = new FileOutputStream(path);
      out.write(classFile);
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
