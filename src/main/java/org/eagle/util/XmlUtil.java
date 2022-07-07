package org.eagle.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author ljj
 * @description XML工具
 */
public class XmlUtil {
    private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    public static void main(String[] args) {
        File file = new File("E:\\coding\\code\\eagle\\pom.xml");
        try {
            traverseXml(file);
        } catch (IOException e) {
            logger.error("读取文件报错 ---> " + e);
        }
    }

    public static void traverseXml(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BufferedOutputStream outputStream = new BufferedOutputStream(stream);

        byte[] temp = new byte[2048];
        int flag;

        while ((flag = inputStream.read(temp)) != -1) {
            outputStream.write(temp, 0, flag);
        }
        outputStream.flush();
        System.out.println(stream.toString());
        outputStream.close();
        stream.close();
    }
}
