package com.github.sources.dubbo.base.serialize.jdk;

import java.io.*;

/**
 *
 */
public class SerializationUtil {

    /**
     * 从一个给定的文件完成反序列化
     */
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * 将给定的对象序列化到指定的文件中去
     */
    public static void serialize(Object obj, String fileName)
            throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }
}
