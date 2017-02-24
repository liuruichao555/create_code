package com.liuruichao.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * FileUtils
 *
 * @author liuruichao
 * @date 15/7/12 下午3:15
 */
public final class FileUtils {
    private static final Logger logger = Logger.getLogger(FileUtils.class);

    /**
     * 读取文件内容
     * @param path
     * @return
     */
    public static String getFileContent(String path) {
        StringBuffer sbu = new StringBuffer();

        InputStream in = null;
        try {
            in = new FileInputStream(path);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                sbu.append(new String(b, 0, len));
            }
        } catch (Exception e) {
            logger.error("FileUtils getFileContent() error.", e);
        }

        return sbu.toString();
    }
}
