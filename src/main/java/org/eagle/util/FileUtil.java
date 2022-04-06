package org.eagle.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ljj
 * @description 文件工具
 */
public class FileUtil {

    /**
     * <p>文件转字节数组</p>
     *
     * @param file 传入文件
     * @return 字节数组
     */
    public static byte[] fileToByteArray(File file) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024 * 1024];
        int n;

        while (-1 != (n = fileInputStream.read(bytes))) {
            outputStream.write(bytes, 0, n);
        }

        return outputStream.toByteArray();
    }
}
